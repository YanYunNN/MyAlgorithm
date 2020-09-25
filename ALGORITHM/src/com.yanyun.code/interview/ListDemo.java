package com.yanyun.code.interview;

import java.util.*;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/09/23/10:44
 * @description
 */
public class ListDemo {
    /**
     * randomAccess随机访问标识，没有实际意义，就是一种标识
     * 不是实现了该接口就具有随机访问，而是具有随机访问才标识该接口
     */
    RandomAccess randomAccess = new Vector<>();

    /**
     * @see java.util.Vector;
     * class Vector<E> extends AbstractList<E> implements List<E>, RandomAccess
     * 方法加上了sychronized，线程安全，效率很低
     */
    List<Object> objectVector = new Vector<>();

    /**
     * @see java.util.ArrayList;
     * class ArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess
     * 线程不安全
     * transient Object[] elementData;//list真正的构造
     * private static final Object[] EMPTY_ELEMENTDATA = {};
     * private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
     * private static final int DEFAULT_CAPACITY = 10; //第一次扩容容量
     * private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8; //上界
     * private int size; //实际值
     * ---------------------------------------------------------------------------
     * new——初始化：
     * 无参：空对象数组 ：elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
     * 有参：不为0，new Object[initialCapacity]；为0则直接赋值EMPTY_ELEMENTDATA
     * 集合参：toArray length不为0：Arrays.copyOf；为0则直接赋值EMPTY_ELEMENTDATA
     */
    List<Object> objectList = new ArrayList<>();
    /**
     * add()——扩容:
     * - ensureCapacityInternal(/minCapacity/size + 1);如果elementData为默认空，minCapacity=max(/DEFAULT_CAPACITY/10,minCapacity)，`得到最小扩容量`
     * - - ensureExplicitCapacity(minCapacity); //minCapacity - elementData.length > 0：是否需要扩容（注意modCount++）
     * - - - grow（minCapacity）; //扩容核心方法
     * - - - - int newCapacity = oldCapacity + (oldCapacity >> 1);//扩容1.5倍（防int越界，位运算更快）
     * - - - - if (newCapacity - minCapacity < 0)   newCapacity = minCapacity;
     * - - - - if (newCapacity - MAX_ARRAY_SIZE > 0)   newCapacity = hugeCapacity(minCapacity); (minCapacity>MAX_ARRAY_SIZE)?Integer.MAX_VALUE:MAX_ARRAY_SIZE;
     * - - - - elementData = Arrays.copyOf(elementData, newCapacity); //fail-failure安全失败机制，elementData拷贝至扩容的副本
     * - elementData[size++] = e;
     * --------------------------------------------------------------------------------------------------------------------------------
     * # add 进第1个元素时，minCapacity为1，在Math.max()方法比较后，minCapacity 为10，然后触发扩容条件，grow() 扩容到10
     * # add一直加，直到 size+1 = minCapacity >10 触发扩容
     * # 扩容grow()需要比较 *1.5的 newCapacity、ensureCapacityInternal最小扩容量minCapacity、MAX_ARRAY_SIZE=IntMax-8,取大值，若还不够，取IntMax
     * # grow()会新建一个扩容的准确值newCapacity的 Object[],并将源数组elementData进行拷贝
     * ## Arrays.copyOf(elementData, newCapacity)，底层是 native System.arraycopy(src,index,dest,index+1,size-index)
     * # 最后赋值末位，元素大小+1： elementData[size++] = e;
     * --------------------------------------------------------------------------------------------------------------------------------
     * 在 add大量元素之前用 ensureCapacity 方法，以减少增量重新分配的次数
     */
    List<Object> capacityList = new ArrayList<>(8);

    public static void main(String[] args) {
        List<Object> objectList = new ArrayList<>();
        objectList.add("1");
    }

}
