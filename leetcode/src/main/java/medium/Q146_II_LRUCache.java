package medium;

import java.util.LinkedHashMap;

public class Q146_II_LRUCache {

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private Node head, tail;

        class Node {
            private int key;
            private int value;
            Node prev;
            Node next;

            void addNode(Node node) {
                next = node;
                node.prev = this;


            }

            void delNode(Node node) {

            }
        }


        int cap;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
