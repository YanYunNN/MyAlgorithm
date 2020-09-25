package com.yanyun.code.interview;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.lang.reflect.*;
import java.util.Objects;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/09/21/21:46
 * @description Equal与Hashcode
 */
@Data
@EqualsAndHashCode
public class Eual {
    private String str;
    private final static String name = "name";
    private static int i = 0;

    static {
        i = 999;
        System.out.println(i);
    }

    public static void main(String[] args) throws Exception {
        int a = 1;
        float f = 1.0f;
        if (a == f) {
            System.out.println(1);
        }
        Integer aA = 1;
        Float fF = 1.1f;
        Double dD = 1.1d;
        Eual eual = new Eual();

        if (!aA.equals(fF)) {
            //得到字节码对象
            Class<?> clz = Class.forName("com.yanyun.code.interview.Eual");
            //获取变量名为"NAME"的私有字段
            Field field = clz.getDeclaredField("name");
            //无视private修饰符,暴力访问
            field.setAccessible(true);
            Field modifiers = Field.class.getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            //去掉final修饰符
            modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            System.out.println("修改前: " + field.get(null));
            field.set(null, "BBB");
            System.out.println("修改后: " + field.get(null));
            System.out.println("原值: " + Eual.name);
        }
        if (fF.equals(dD)) {
            Class<? extends Eual> clazz = eual.getClass();
            Field[] fields = clazz.getFields();
            Field str = clazz.getDeclaredField("str");
            str.setAccessible(true);
            str.set(eual, "my");
            Constructor<? extends Eual> declaredConstructor = clazz.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            Eual eual1 = declaredConstructor.newInstance(null);

            System.out.println(eual == eual1);
            System.out.println(eual.equals(eual1));
            for (int i = fields.length - 1; i >= 0; i--) {

            }
            Method methodMain = clazz.getMethod("main", String[].class);
            methodMain.invoke(null, (Object) new String[]{"a", "b", "c"});
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Eual eual = (Eual) o;
        return Objects.equals(str, eual.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }
}
