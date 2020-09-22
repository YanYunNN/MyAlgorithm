package com.yanyun.code.interview;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/09/21/21:07
 * @description 抽象类与接口
 */
public interface Impl {
    //Modifier 'abstract' is redundant for interface methods
    abstract int add();

    //Modifier 'public' is redundant for interface methods
    public double exce();

    default int multi() {
        return 0;
    }
    //Illegal combination of modifiers: 'final' and 'abstract'
    //final int mlu();

    //Modifier 'private' not allowed here
    //private int plus();
}
