package com.yanyun.juc.pattern.decorator;

import java.util.concurrent.*;

/**
 * @Auther: xcai
 * @Date: 2020/07/03/13:05
 * @Description: https://blog.csdn.net/ThinkWon/article/details/105870730 结构型模式
 * @Version: 动态地给一个对象添加一些额外的职责。就增加功能来说，装饰器模式相比生成子类更为灵活
 * <p>
 * 1. 装饰器模式强调的是增强自身，在被装饰之后你能够在被增强的类上使用增强后的功能。
 * 为让自己的能力增强，使得增强后的自己能够使用更多的方法，拓展在自己基础之上的功能的，叫装饰器模式
 * 2. 让别人帮助你做你并不关心的事情，叫代理模式
 * 3. 装饰模式是为装饰的对象增强功能；而代理模式对代理的对象施加控制，但不对对象本身的功能进行增强；
 */
public class DecoratorDemo {
    public static void main(String[] args) {
        IShape circle = new Circle();
        IShape redCircle = new RedShapeDecorator(new Circle());
        IShape redRectangle = new RedShapeDecorator(new Rectangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nRectangle of red border");
        redRectangle.draw();

        Callable task = () -> {
            Thread.sleep(3000);
            return 3;
        };

        System.out.println("start");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future s = executorService.submit(task);
        try {
            System.out.println(s.isDone() + " " + s.get());
            System.out.println(s.isDone() + " " + s.isCancelled());
        } catch (Exception e) {
            e.printStackTrace();
        }
        s.cancel(true);
        System.out.println("over");
        executorService.shutdownNow();
    }


}
