package medium;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class Q146_II_LRUCache {

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {

        class Node {
            Node prev;
            Node next;
            private int key;
            private int value;
        }

        //头插法
        void addNode(Node node) {
            node.next = head.next;
            head.next.prev = node;

            head.next = node;
            node.prev = head;
        }

        void delNode(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        private void moveToHead(Node node) {
            delNode(node);
            addNode(node);
        }

        Node popTail() {
            Node res = tail.prev;
            delNode(res);
            return res;
        }

        private HashMap<Integer, Node> cache = new HashMap<>();
        private int cap, size;
        private Node head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.cap = capacity;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }


        public int get(int key) {
            Node node = cache.get(key);
            if (node == null) return -1;

            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            Node node = cache.get(key);
            if (cache != null) {
                node.value = value;
                moveToHead(node);
                return;
            }
            node = new Node();
            node.key = key;
            node.value = value;
            addNode(node);
            cache.put(key, node);
            size++;

            if (size > cap) {
                Node tail= popTail();
                cache.remove(tail.key);
                size--;
            }
        }
    }

}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

