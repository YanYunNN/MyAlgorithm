package nio.nio_demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOClient {
    private static final ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    private static final ByteBuffer readBuffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) {
        try {
            // 创建 SocketChannel 和 Selector
            SocketChannel socketChannel = SocketChannel.open();
            Selector selector = Selector.open();
            socketChannel.configureBlocking(false);
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
            socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));

            while (true) {
                // 等待事件发生
                selector.select();
                Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

                while (keys.hasNext()) {
                    SelectionKey key = keys.next();
                    keys.remove(); // 清除已处理的 key

                    if (key.isValid()) {
                        handleKey(key);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
        }
    }

    private static void handleKey(SelectionKey key) {
        try {
            if (key.isConnectable()) {
                handleConnect(key);
            } else if (key.isReadable()) {
                handleRead(key);
            }
        } catch (IOException e) {
            System.err.println("Error handling key: " + e.getMessage());
            closeKey(key); // 安全关闭连接
        }
    }

    private static void handleConnect(SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        if (client.isConnectionPending()) {
            client.finishConnect();
            System.out.println("完成连接!");
            sendMessage(client, "HelloServer");
        }
        client.register(key.selector(), SelectionKey.OP_READ); // 注册读取事件
    }

    private static void handleRead(SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        readBuffer.clear();
        int bytesRead = client.read(readBuffer);
        if (bytesRead == -1) {
            closeKey(key); // 服务器关闭连接
            return;
        }
        readBuffer.flip();
        String message = new String(readBuffer.array(), 0, readBuffer.limit());
        System.out.println("接收到服务器消息: " + message);
    }

    private static void sendMessage(SocketChannel client, String message) throws IOException {
        writeBuffer.clear();
        writeBuffer.put(message.getBytes());
        writeBuffer.flip();
        client.write(writeBuffer);
        System.out.println("发送消息到服务器: " + message);
    }

    private static void closeKey(SelectionKey key) {
        try {
            if (key != null) {
                key.channel().close();
                key.cancel();
            }
        } catch (IOException e) {
            System.err.println("Error closing key: " + e.getMessage());
        }
    }
}
