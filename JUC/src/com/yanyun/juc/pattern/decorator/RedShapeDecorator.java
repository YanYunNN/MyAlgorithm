package com.yanyun.juc.pattern.decorator;

/**
 * @Auther: xcai
 * @Date: 2020/07/03/13:10
 * @Description:
 * @Version: 1.0
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(IShape decoratorShape) {
        super(decoratorShape);

    }

    private void setRedBorder(IShape decoratorShape) {
        System.out.println("Border Color：Red");
    }

    @Override
    public void draw() {
        decoratorShape.draw();
        //装饰着模式增强自身对象
        setRedBorder(decoratorShape);
    }
}
