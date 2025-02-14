package nio.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBuffer {
    private static String FILE = "nio/src/main/java/buffer/ChannelTestFile.txt";

    public static void main(String[] args) throws IOException {
        writeFile();
        writeFile1();
        writeFile2();

    }

    private static void writeFile() {
        int size = 1024 * 10;
        File file = new File(FILE);

        byte[] bytes = new byte[size];
        for (int i = 0; i < size; i++) {
            bytes[i] = new Integer(i).byteValue();
        }
        //多线程写入文件
        try {
            java.io.FileOutputStream fos = new java.io.FileOutputStream(file);
            java.io.BufferedOutputStream bos = new java.io.BufferedOutputStream(fos);
            for (int i = 0; i < size; i++) {
                bos.write(bytes);
            }
            bos.close();
            fos.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }


    private static void writeFile1() throws IOException {
        File file = new File(FILE);
        FileInputStream in = new FileInputStream(file);
        FileChannel channel = in.getChannel();

        ByteBuffer buff = ByteBuffer.allocate(1024);

        long begin = System.currentTimeMillis();
        while (channel.read(buff) != -1) {
            buff.flip();
            buff.clear();
        }
        long end = System.currentTimeMillis();
        System.out.println("time is:" + (end - begin));
    }

    private static void writeFile2() throws IOException {
        int BUFFER_SIZE = 1024;

        File file = new File(FILE);
        FileChannel fileChannel = new FileInputStream(file).getChannel();
        java.nio.MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());

        byte[] b = new byte[1024];
        int length = (int) file.length();

        long begin = System.currentTimeMillis();

        for (int i = 0; i < length; i += 1024) {
            if (length - i > BUFFER_SIZE) {
                mappedByteBuffer.get(b);
            } else {
                mappedByteBuffer.get(new byte[length - i]);
            }
        }

        long end = System.currentTimeMillis();

        System.out.println("time is:" + (end - begin));
    }
}
