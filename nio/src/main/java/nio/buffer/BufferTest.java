package nio.buffer;

import java.nio.DoubleBuffer;

public class BufferTest {

    public static void main(String[] args) {
        DoubleBuffer buffer = DoubleBuffer.allocate(10);
        System.out.println("================= allocate 10 后 =================");
        System.out.println("capacity = " + buffer.capacity());
        System.out.println("position = " + buffer.position());
        System.out.println("limit = " + buffer.limit());

        buffer.put(1.1);
        buffer.put(2.2);
        System.out.println("================= put 1、2 后 =================");
        System.out.println("capacity = " + buffer.capacity());
        System.out.println("position = " + buffer.position());
        System.out.println("limit = " + buffer.limit());

        buffer.put(3);
        buffer.put(4);
        buffer.put(5);

        System.out.println("================= put 3、4、5 后 =================");
        System.out.println("capacity = " + buffer.capacity());
        System.out.println("position = " + buffer.position());
        System.out.println("limit = " + buffer.limit());


        //写切换读
        buffer.flip();
        System.out.println("================= flip 后 =================");
        System.out.println("capacity = " + buffer.capacity());
        System.out.println("position = " + buffer.position());
        System.out.println("limit = " + buffer.limit());

        System.out.println("读取第 1 个位置的数据：" + buffer.get());
        System.out.println("读取第 2 个位置的数据：" + buffer.get());
        System.out.println("================= get 2 后 =================");
        System.out.println("capacity = " + buffer.capacity());
        System.out.println("position = " + buffer.position());
        System.out.println("limit = " + buffer.limit());

        System.out.println("读取第 3 个位置的数据：" + buffer.get());
        System.out.println("读取第 4 个位置的数据：" + buffer.get());
        try {
            System.out.println("读取第 5 个位置的数据：" + buffer.get());
            System.out.println("读取第 6 个位置的数据：" + buffer.get());
            System.out.println("读取第 7 个位置的数据：" + buffer.get());
        } catch (Exception e) {
            System.out.println("发生异常：" + e.getMessage());
        }

        //倒带重复读
        buffer.rewind();
        System.out.println("================= rewind 后 =================");
        System.out.println("capacity = " + buffer.capacity());
        System.out.println("position = " + buffer.position());
        System.out.println("limit = " + buffer.limit());
        for (int i = 0; i < 5; i++) {
            System.out.println("读取第" + i + 1 + "个位置的数据：" + buffer.get());
        }
        System.out.println("capacity = " + buffer.capacity());
        System.out.println("position = " + buffer.position());
        System.out.println("limit = " + buffer.limit());
        buffer.rewind();


        //读切换写，Buffer 被清空了，回归到最初始状态
        buffer.clear();
        System.out.println("================= clear 后 =================");
        System.out.println("capacity = " + buffer.capacity());
        System.out.println("position = " + buffer.position());
        System.out.println("limit = " + buffer.limit());
        buffer.put(6);
        buffer.put(7);
        buffer.put(8);
        buffer.put(9);
        buffer.put(10);
        System.out.println("================= put 6、7、8、9、10 后 =================");
        System.out.println("capacity = " + buffer.capacity());
        System.out.println("position = " + buffer.position());
        System.out.println("limit = " + buffer.limit());

        //compact
        for (int i = 0; i < 5; i++) {
            buffer.clear();
            buffer.put(i);
        }
        for (int i = 0; i < 2; i++) {
            buffer.flip();
            buffer.get();
        }
        buffer.compact();
        System.out.println("================= compact 后 =================");
        System.out.println("capacity = " + buffer.capacity());
        System.out.println("position = " + buffer.position());
        System.out.println("limit = " + buffer.limit());

    }
}
