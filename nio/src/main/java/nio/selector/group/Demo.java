package nio.selector.group;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Demo {
    public static void main(String[] args) throws IOException {
        Thread.currentThread().setName("boss-thread");

        ServerSocketChannel scc = ServerSocketChannel.open();
        scc.configureBlocking(false);

        Selector selector = Selector.open();
        scc.register(selector, SelectionKey.OP_ACCEPT);

        scc.bind(new InetSocketAddress("127.0.0.1", 8808));

        // 新建 Worker 线程
        WorkerThread workerThread = new WorkerThread("worker-thread");
        // 新建两个 Worker 线程
        WorkerThread[] workerThreads = new WorkerThread[2];
        workerThreads[0] = new WorkerThread("worker-thread-0");
        workerThreads[1] = new WorkerThread("worker-thread-1");
        workerThreads[0].register();
        workerThreads[1].register();

        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                if (key.isAcceptable()) {
                    SocketChannel sc = scc.accept();
                    sc.configureBlocking(false);

                    System.out.println("已连接,客户端：" + sc.getRemoteAddress());
                    // 初始化 worker
                    workerThread.getSelector().wakeup();

                    // sc 关联到 Worker 线程
                    System.out.println("注册到 Worker 线程的 Selector 上...");
                    sc.register(workerThread.getSelector(), SelectionKey.OP_READ);
                    System.out.println("注册到 Worker 线程的 Selector 上，已完成...");
                }
            }
        }
    }
}
