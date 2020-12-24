package com.yanyun.sword.juc.pattern.factory;

/**
 * @Auther: xcai
 * @Date: 2020/07/03/12:42
 * @Description: https://blog.csdn.net/ThinkWon/article/details/105870730
 * @Version: 定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。
 */
public class ShapeFactory {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        IShape circle = shapeFactory.getshape("CIRCLE");
        circle.draw();

        IShape rectangle = shapeFactory.getshape("RECTANGLE");
        rectangle.draw();

        IShape square = shapeFactory.getshape("SQUARE");
        square.draw();

    }

    public IShape getshape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        shapeType = shapeType.toLowerCase();
        switch (shapeType) {
            case "circle":
                return new Circle();
            case "rectangle":
                return new Rectangle();
            case "square":
                return new Square();
            default:
                return null;
        }
    }
}
