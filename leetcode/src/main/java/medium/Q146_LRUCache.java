package medium;

import java.util.LinkedHashMap;

public class Q146_LRUCache {

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        int cap;
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>();

        public LRUCache(int capacity) {
            this.cap = capacity;
        }

        public int get(int key) {
            if (!cache.containsKey(key)) {
                return -1;
            }
            this.moveToHead(key);
            return cache.get(key);
        }

        public void put(int key, int value) {
            if (cache.containsKey(key)) {
                cache.put(key, value);
                moveToHead(key);
                return;
            }
            if (cache.size() > cap) {
                Integer first = cache.keySet().iterator().next();
                cache.remove(first);
                cache.put(key, value);
            }
        }

        private void moveToHead(int key) {
            Integer val = cache.get(key);
            cache.remove(key, val);
            cache.put(key, val);
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
