package ajava;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.SortedMap;
import java.util.TreeMap;

public class KetamaHashStrategy {

    private final SortedMap<Long, String> circle = new TreeMap<>();
    private final int numberOfReplicas;

    public KetamaHashStrategy(int numberOfReplicas) {
        this.numberOfReplicas = numberOfReplicas;
    }

    public void addNode(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.put(hash(node + i), node);
        }
    }

    public void removeNode(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.remove(hash(node + i));
        }
    }

    public String getNode(String key) {
        if (circle.isEmpty()) {
            return null;
        }
        long hash = hash(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Long, String> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    private long hash(String key) {
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found");
        }
        byte[] digest = md5.digest(key.getBytes(StandardCharsets.UTF_8));
        return ((long) (digest[3] & 0xFF) << 24)
                | ((long) (digest[2] & 0xFF) << 16)
                | ((long) (digest[1] & 0xFF) << 8)
                | (digest[0] & 0xFF);
    }

    public static void main(String[] args) {
        KetamaHashStrategy ketamaHash = new KetamaHashStrategy(3);

        // 添加节点
        ketamaHash.addNode("NodeA");
        ketamaHash.addNode("NodeB");
        ketamaHash.addNode("NodeC");

        // 分配数据
        System.out.println("Key1 is mapped to " + ketamaHash.getNode("Key1"));
        System.out.println("Key2 is mapped to " + ketamaHash.getNode("Key2"));
        System.out.println("Key3 is mapped to " + ketamaHash.getNode("Key3"));

        // 移除节点
        ketamaHash.removeNode("NodeB");
        System.out.println("After removing NodeB:");
        System.out.println("Key1 is mapped to " + ketamaHash.getNode("Key1"));
        System.out.println("Key2 is mapped to " + ketamaHash.getNode("Key2"));
        System.out.println("Key3 is mapped to " + ketamaHash.getNode("Key3"));
    }
}
