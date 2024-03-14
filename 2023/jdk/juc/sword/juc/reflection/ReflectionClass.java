package com.yanyun.sword.juc.reflection;

import java.util.Random;

/**
 * 用于练习反射的类
 * <p/>
 * Created by sunyiwei on 2016/10/30.
 */
@SuppressWarnings("unchecked")
@Deprecated
final public class ReflectionClass implements Comparable {
    private String stringProp;
    private int intProp;
    private int[] intArray;

    public ReflectionClass(String stringProp, int intProp, int[] intArray) {
        this.stringProp = stringProp;
        this.intProp = intProp;
        this.intArray = intArray;
    }

    private ReflectionClass() {
    }

    public int[] getIntArray() {
        return intArray;
    }

    public void setIntArray(int[] intArray) {
        this.intArray = intArray;
    }

    @Override
    public int compareTo(Object o) {
        return new Random().nextBoolean() ? -1 : 1;
    }

    private void privateVoidMethod() {

    }

    private String privateStringMethod() {
        return "private";
    }

    protected void protectedVoidMethod() {

    }

    protected String protectedStringMethod() {
        return "protected";
    }

    void packageVoidMethod() {

    }

    String packageStringMethod() {
        return "package";
    }

    public void pubilcVoidMethod() {

    }

    public String publicStringMethod() {
        return "public";
    }

    public String getStringProp() {
        return stringProp;
    }

    public void setStringProp(String stringProp) {
        this.stringProp = stringProp;
    }

    public int getIntProp() {
        return intProp;
    }

    public void setIntProp(int intProp) {
        this.intProp = intProp;
    }
}
