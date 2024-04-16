package medium;

import java.util.HashMap;

public class Q146_II_LRUCache {

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private Node head, tail;
        int cap;
        int size;
        HashMap<Integer, Node> cache = new HashMap<>();

        class Node {
            private int key;
            private int value;
            Node prev;
            Node next;
        }

        void addNode(Node node) {
            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        void delNode(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        void moveToHead(Node node) {
            delNode(node);
            addNode(node);
        }

        Node pop() {
            Node node = tail.prev;
            delNode(node);
            return node;
        }

        public LRUCache(int capacity) {
            this.cap = capacity;
            this.size = 0;
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
            if (node != null) {
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
                Node pop = pop();
                cache.remove(pop.key);
                size--;
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

}
