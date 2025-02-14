package nio.socket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class ServerSocketChannelDemo {
    public static void main(String[] args) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(100);
        ServerSocketChannel serverSocket = ServerSocketChannel.open();

        serverSocket.bind(new InetSocketAddress(8080));
        List<SocketChannel> channels = new ArrayList<>();
        while (true) {
            // 非阻塞模式
//            serverSocket.configureBlocking(false);

            SocketChannel sc = serverSocket.accept();
            if (sc != null) {
                channels.add(sc);
            }

            for (SocketChannel asc : channels) {
//                asc.configureBlocking(false);

                int size = asc.read(buffer);
                if (size > 0) {
                    buffer.flip();
                    System.out.println("接收到数据：" + new String(buffer.array(), 0, size));
                    buffer.clear();
                }
            }
        }
    }
}
