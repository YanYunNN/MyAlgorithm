package nio.selector.group;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class BossThread {
    public static void main(String[] args) throws IOException {
        Thread.currentThread().setName("boss-thread");

        ServerSocketChannel scc = ServerSocketChannel.open();
        scc.configureBlocking(false);

        Selector selector = Selector.open();
        scc.register(selector, SelectionKey.OP_ACCEPT);

        scc.bind(new InetSocketAddress("127.0.0.1", 8808));

        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                iterator.remove();

                if (key.isAcceptable()) {
                    SocketChannel sc = scc.accept();
                    sc.configureBlocking(false);

                    System.out.println("收到新连接：" + sc.getRemoteAddress());
                }
            }
        }
    }

}
