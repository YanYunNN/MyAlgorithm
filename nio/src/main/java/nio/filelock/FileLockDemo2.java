package nio.filelock;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class FileLockDemo2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        RandomAccessFile file = new RandomAccessFile("nio/src/main/java/filelock/ChannelTest.txt", "rw");
        FileChannel channel = file.getChannel();
        // 这里是独占锁
        FileLock fileLock = channel.lock();
        System.out.println("开始读文件的时间：" + LocalTime.now());

        for (int i = 0; i < 10; i++) {
            System.out.println("文件大小为：" + file.length());
            // 这里等待 1 秒
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("结束读文件的时间：" + LocalTime.now());
        // 完成后要释放掉锁
        fileLock.release();
        channel.close();
        file.close();
    }
}
