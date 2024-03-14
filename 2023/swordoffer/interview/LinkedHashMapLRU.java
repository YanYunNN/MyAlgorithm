package com.yanyun.code.interview;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/09/25/12:30
 * @description
 */
public class LinkedHashMapLRU {

    public static class SimpleCache<K, V> extends LinkedHashMap<K, V> {

        private static final int MAX_NODE_NUM = 100;

        private int limit;

        public SimpleCache() {
            this(MAX_NODE_NUM);
        }

        public SimpleCache(int limit) {
            super(limit, 0.75f, true);
            this.limit = limit;
        }

        public V save(K key, V val) {
            return put(key, val);
        }

        public V getOne(K key) {
            return get(key);
        }

        public boolean exists(K key) {
            return containsKey(key);
        }

        /**
         * 判断节点数是否超限
         * @param eldest
         * @return 超限返回 true，否则返回 false
         */
        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > limit;
        }

    }

    public static void main(String[] args) {
        SimpleCache<Integer, Integer> cache = new SimpleCache<>(3);

        for (int i = 0; i < 10; i++) {
            cache.save(i, i * i);
        }

        System.out.println("插入10个键值对后，缓存内容：");
        System.out.println(cache + "\n");

        System.out.println("访问键值为7的节点后，缓存内容：");
        cache.getOne(7);
        System.out.println(cache + "\n");

        System.out.println("插入键值为1的键值对后，缓存内容：");
        cache.save(1, 1);
        System.out.println(cache);
    }
}
