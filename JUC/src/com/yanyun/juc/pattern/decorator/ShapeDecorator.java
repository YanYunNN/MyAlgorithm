package com.yanyun.juc.pattern.decorator;

import java.lang.reflect.Proxy;

/**
 * @Auther: xcai
 * @Date: 2020/07/03/13:10
 * @Description:
 * @Version: 1.0
 */
public abstract class ShapeDecorator implements IShape {

    protected IShape decoratorShape;

    public ShapeDecorator(IShape shape) {
        this.decoratorShape = shape;

    }

    @Override
    public void draw() {
        decoratorShape.draw();
    }
}
