package com.yanyun.code.interview;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/09/23/10:44
 * @description
 */
public class MapDemo {
    /**
     * @see java.util.HashMap,java.util.Hashtable,java.util.HashSet;
     * class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>
     * class Hashtable<K,V> extends Dictionary<K,V> implements Map<K,V>
     * class HashSet<E> extends AbstractSet<E> implements Set<E>
     * ------------------------------------------------------------------------
     * Hashtable:initialCapacity = 11；扩容2n+1；方法加上了 synchronized，线程安全，效率很低，废弃; key!=null
     * HashMap:initialCapacity = 16；loadfoctor = 0.75；size=2^n ;扩容 2n；线程不安全; key允许一个null
     * HashSet:底层基于 HashMap<E,new Object()> map;add时判重：先判断key是否存在相同hashcode，再比较equal结果
     */
    HashMap<Object, Object> map = new HashMap<>();
    Hashtable<Object, Object> table = new Hashtable<>();
    HashSet<Object> set = new HashSet<>();

    /**
     * @HashMap 1.8
     * <p>参数
     * DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
     * MAXIMUM_CAPACITY = 1 << 30;
     * DEFAULT_LOAD_FACTOR = 0.75f;
     * TREEIFY_THRESHOLD = 8; //树化阈值
     * UNTREEIFY_THRESHOLD = 6 //退树化阈值
     * MIN_TREEIFY_CAPACITY = 64; //树化要求最小容量；否则，若桶内元素太多时，则直接扩容，而不是树形化；
     * ---------------------------//不能小于4 * TREEIFY_THRESHOLD =32 ，为了避免进行扩容、树形化选择的冲突
     * <p>内部类
     * final class EntrySet extends AbstractSet<Map.Entry<K,V>>
     * static class Node<K,V> implements Map.Entry<K,V> //静态内部类，节点
     * 属性
     * Node<K,V>[] table //哈希桶数组
     * Set<Map.Entry<K,V>> entrySet //节点集，便于foreach
     * Set<K> keySet //键集
     * Collection<V> values //值集
     * size //键值对数
     * modCount // fail-fast ConcurrentModificationException 记录HashMap内部结构发生变化的次数，主要用于迭代的快速失败，某个key对应的value值被覆盖不属于
     * threshold //阈值threshold = length * Load factor(默认12)，超过就需要扩容， threshold = tableSizeFor(initialCapacity);//找最近的2幂值
     * loadFactor //装载因子
     * ----------------------------------------------------------------------------------------------
     * <p>方法
     * 扰动函数：`hash(Object key)`： (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16) //高16位异或低16位
     * 容量函数：`tableSizeFor(int cap)` : 返回 2的幂次
     * 算出位置：indexFor(h,length){ (length - 1) & hash }
     */
    Map<Object, Object> initMap = new HashMap<>(10, 0.75f);

    /**
     * @HashMap 1.7
     * 数组和链表，(n-1) & hash { =hash(key)//扰动函数,减少碰撞 } 判断当前元素存放的位置
     * 如果当前位置存在元素的话，就判断该元素与要存⼊的元素的 hash 值以及 key 是否相同，如果相同的话，直接覆盖，不相同就通过拉链法解决冲突
     * hash(int hashcode)：扰动函数 4次右移异或，性能比1.8一次差
     */
    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    /**
     * @see java.util.concurrent.ConcurrentHashMap
     * class ConcurrentHashMap<K,V> extends AbstractMap<K,V> implements ConcurrentMap<K,V>
     * - static class Segment<K,V> extends ReentrantLock
     */

    public static void main(String[] args) {
        Map<Object, Object> initMap = new HashMap<>(10, 0.75f);
        Set<Map.Entry<Object, Object>> entries = initMap.entrySet();
        Set<Object> objects = initMap.keySet();
        Collection<Object> values = initMap.values();
        initMap.size();
        ArrayDeque<String> deque = new ArrayDeque();
        PriorityQueue priorityQueue = new PriorityQueue();
        Objects.hash();
        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
    }

}
