package netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;

public class ByteBufDemo {
    public static void main(String[] args) {
        ByteBuf byteBuf = ByteBufAllocator.DEFAULT.buffer(15, 20);
        printByteBuf(byteBuf, "new buffer(15,20)");

        byteBuf.writeBytes(new byte[]{1, 2, 3, 4, 5, 6});
        printByteBuf(byteBuf, "write 6 bytes");

        byteBuf.readInt();
        printByteBuf(byteBuf, "read 4 bytes");

        // 读取两个字节
        byteBuf.readBytes(new byte[2]);
        printByteBuf(byteBuf, "读取 2 个字节");

        // 写入 8 个字节
        byteBuf.writeBytes(new byte[]{7, 8, 9, 10, 11, 12, 13, 14});
        printByteBuf(byteBuf, "写入 8 个字节");

        // getXx 获取 ByteBuf 中的值
        System.out.println("getByte(3) = " + byteBuf.getByte(3));
        printByteBuf(byteBuf, "getByte(3)");

        // setBytes
        byteBuf.setByte(8, 1);
        printByteBuf(byteBuf, "setByte(8,1)");

        // slice
        ByteBuf sliceByte = byteBuf.slice();
        printByteBuf(sliceByte, "sliceByte");

        // duplicateByte
        ByteBuf duplicateByte = byteBuf.duplicate();
        printByteBuf(duplicateByte, "duplicateByte");


        // 读取 sliceByte
        sliceByte.readInt();
        printByteBuf(sliceByte, "sliceByte.readInt()");

        // 读取
        duplicateByte.readInt();
        printByteBuf(duplicateByte, "duplicateByte.readInt()");

        // 读取后原始 ByteBuf
        printByteBuf(byteBuf, "读取后，原始 ByteBuf");


        // 写 duplicateByte
        duplicateByte.writeBytes(new byte[]{1});
        printByteBuf(duplicateByte, "duplicateByte.writeByte(0)");

        // 写后原始 ByteBuf
        printByteBuf(byteBuf, "写后，原始 ByteBuf");

        System.out.println("setByte(8,123) 之前，duplicateByte = " + duplicateByte.getByte(8));
        System.out.println("setByte(8,123) 之前，byteBuf = " + byteBuf.getByte(8));

        duplicateByte.setByte(8, 123);
        System.out.println("setByte(8,123) 之后，duplicateByte = " + duplicateByte.getByte(8));
        System.out.println("setByte(8,123) 之后，byteBuf = " + byteBuf.getByte(8));

        // 继续写 2 个字节
        byteBuf.writeBytes(new byte[]{15, 16});
        printByteBuf(byteBuf, "写 2 个字节后");
        // 再写 1 个
        byteBuf.writeBytes(new byte[]{17});
        printByteBuf(byteBuf, "写 1 个字节后");

        byteBuf.discardReadBytes();
        printByteBuf(byteBuf,"discardReadBytes 之后");
    }


    private static void printByteBuf(ByteBuf byteBuf, String action) {
        System.out.println("===========" + action + "============");
        System.out.println("capacity = " + byteBuf.capacity());
        System.out.println("maxCapacity = " + byteBuf.maxCapacity());
        System.out.println("readerIndex = " + byteBuf.readerIndex());
        System.out.println("writerIndex = " + byteBuf.writerIndex());
        System.out.println("readableBytes = " + byteBuf.readableBytes());
        System.out.println("isWritable = " + byteBuf.isWritable());
        System.out.println("isReadable = " + byteBuf.isReadable());
        System.out.println();

    }
}
