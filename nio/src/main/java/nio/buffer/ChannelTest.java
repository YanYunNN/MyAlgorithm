package nio.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

public class ChannelTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile file = new RandomAccessFile("nio/src/main/java/buffer/ChannelTest.java", "rw");
        FileChannel channel = file.getChannel();
        System.out.println("FileChannel: " + channel);

        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int readCount = channel.read(buffer);
        System.out.println("Read " + readCount + " bytes");
        System.out.println(new String(buffer.array()));
        channel.close();

        String fileContent = "这是 chenssy 的 死磕 Java 系列中的文章....";
        RandomAccessFile accessFile = new RandomAccessFile("nio/src/main/java/buffer/ChannelTestFile.txt","rw");
        FileChannel fileChannel = accessFile.getChannel();

        ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
        writeBuffer.put(fileContent.getBytes(StandardCharsets.UTF_8));
        writeBuffer.flip();
        int write = fileChannel.write(writeBuffer);
        fileChannel.close();
    }

}
