package com.yanyun.sword.juc.reflection.dynamic;

/**
 * Created by sunyiwei on 2016/11/9.
 */
public class HorseFactory extends AbstractAnimalFactory {
    @Override
    Animal create() {
        return new Horse();
    }
}
