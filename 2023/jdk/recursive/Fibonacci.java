package com.yanyun.code.recursive;

/**
 * @Auther: xcai
 * @Date: 2020/07/06/21:45
 * @Description: 直接或间接调用自身的函数，也就是自身调用自己
 * @算法描述 递归方法实际上体现了“以此类推”、“用同样的步骤重复”这样的思想。
 * 还有些数据结构如二叉树，结构本身固有递归特性；此外，有一类问题，其本身没有明显的递归结构，但用递归程序求解比其他方法更容易编写程序。
 * @Version: 1.0
 */

/**
 * 递归阶乘n! = n * (n-1) * (n-2) * ...* 1(n>0)
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(multiplication(10));
        System.out.println(fibonacci(10));
    }

    public static Integer multiplication(int n) {
        if (n == 1) {
            return 1;
        }
        return n * multiplication(n - 1);
    }

    public static Integer fibonacci(int n) {
        if (n < 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
