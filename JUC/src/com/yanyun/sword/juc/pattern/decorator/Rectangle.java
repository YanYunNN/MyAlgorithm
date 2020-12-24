package com.yanyun.sword.juc.pattern.decorator;


/**
 * @Auther: xcai
 * @Date: 2020/07/03/12:44
 * @Description:
 * @Version: 1.0
 */
public class Rectangle implements IShape {

    @Override
    public void draw() {
        System.out.println("I'm a rectangle");
    }
}
