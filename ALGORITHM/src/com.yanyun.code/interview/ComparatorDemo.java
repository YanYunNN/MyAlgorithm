package com.yanyun.code.interview;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/09/24/19:30
 * @description
 */
public class ComparatorDemo {
    /**
     * @see java.lang.Comparable // public int compareTo(T o);
     * @see java.util.Comparator @FunctionalInterface // int compare(T o1, T o2);
     */
    Comparator comparator = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }
    };


    Comparable comparable = new Comparable() {
        @Override
        public int compareTo(Object o) {
            return 0;
        }
    };

    static class Person implements Comparable<Person> {
        private Integer age;

        Person(Integer age) {
            this.age = age;
        }

        @Override
        public int compareTo(Person o) {
            if (this.age > o.age) {
                return 1;
            } else if (this.age < o.age) {
                return -1;
            }
            return age;
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        list.add(3);
        list.add(3);
        list.add(-5);
        list.add(7);
        list.add(4);
        list.add(-9);
        list.add(-7);
        Collections.reverse(list);
        Collections.sort(list, (o1, o2) -> o2 - o1);
        System.out.println(list);

        TreeMap<Person, Integer> map = new TreeMap<>();
        map.put(new Person(12), 12);
        map.put(new Person(11), 12);
        map.forEach((person, integer) -> {
            System.out.println(person + " " + person.age.intValue());
        });
    }
}
