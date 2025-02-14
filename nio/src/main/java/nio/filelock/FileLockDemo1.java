package nio.filelock;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class FileLockDemo1 {
    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile file = new RandomAccessFile("nio/src/main/java/filelock/ChannelTest.txt", "rw");
        FileChannel channel = file.getChannel();
        FileLock fileLock = channel.lock();
        System.out.println("进程 1 开始写内容：" + LocalTime.now());
        for (int i = 1; i <= 10; i++) {
            file.writeChars("a_" + i);
            TimeUnit.SECONDS.sleep(2);
        }
        System.out.println("进程 1 完成写内容：" + LocalTime.now());
        fileLock.close();
        channel.close();
        file.close();
    }
}
