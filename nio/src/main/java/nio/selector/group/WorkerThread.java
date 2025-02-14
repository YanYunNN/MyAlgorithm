package nio.selector.group;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class WorkerThread implements Runnable {
    private Thread thread;
    private Selector selector;
    private String name;
    //变量 isInit 用于标识当前 Worker 线程是否已完成初始化
    private boolean isInit = false;

    public WorkerThread(String name) {
        this.name = name;
    }

    public Selector getSelector() {
        return this.selector;
    }

    public void register() throws IOException {
        if (!isInit) {
            /**
             * 一个 Worker 线程会有多个 SocketChannel 注册进来，但是我们的 Worker 线程只能初始化一次
             */
            this.selector = Selector.open();
            this.thread = new Thread(this, name);
            this.thread.start();

        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Worker 线程开始执行 select()...");
                selector.select();
                System.out.println("Worker 线程执行完成 select()...");

                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if (key.isReadable()) {
                        ByteBuffer buffer = ByteBuffer.allocate(16);
                        SocketChannel socketChannel = (SocketChannel) key.channel();

                        socketChannel.read(buffer);
                        buffer.flip();

                        System.out.println("收到数据：" + new String(buffer.array()));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
