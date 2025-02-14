package nio.nio_demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NIOServer {
    private final ByteBuffer buffer = ByteBuffer.allocate(1024);
    private final Selector selector;

    public NIOServer(int port) {
        try {
            // 打开服务器通道
            ServerSocketChannel serverChannel = ServerSocketChannel.open();
            serverChannel.socket().bind(new InetSocketAddress(port));
            serverChannel.configureBlocking(false);

            // 打开选择器并注册通道
            selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("Server started on port: " + port);
        } catch (IOException e) {
            throw new RuntimeException("Server initialization failed", e);
        }
    }

    public void listen() {
        try {
            while (true) {
                // 等待事件发生
                selector.select();
                Iterator<SelectionKey> keys = selector.selectedKeys().iterator();

                while (keys.hasNext()) {
                    SelectionKey key = keys.next();
                    keys.remove(); // 避免重复处理
                    handleKey(key);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error while listening", e);
        }
    }

    private void handleKey(SelectionKey key) {
        try {
            if (key.isAcceptable()) {
                acceptConnection((ServerSocketChannel) key.channel());
            } else if (key.isReadable()) {
                readData((SocketChannel) key.channel());
            } else if (key.isWritable()) {
                writeData((SocketChannel) key.channel());
            }
        } catch (IOException e) {
            closeChannel(key); // 出现异常时关闭通道
        }
    }

    private void acceptConnection(ServerSocketChannel serverChannel) throws IOException {
        SocketChannel clientChannel = serverChannel.accept();
        clientChannel.configureBlocking(false);
        clientChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("Accepted connection from: " + clientChannel.getRemoteAddress());
    }

    private void readData(SocketChannel clientChannel) throws IOException {
        buffer.clear();
        int bytesRead = clientChannel.read(buffer);
        if (bytesRead == -1) {
            closeChannel(clientChannel.keyFor(selector));
            return;
        }

        buffer.flip();
        String message = new String(buffer.array(), 0, buffer.limit());
        System.out.println("Received: " + message);

        // 注册写事件
        clientChannel.register(selector, SelectionKey.OP_WRITE);
    }

    private void writeData(SocketChannel clientChannel) throws IOException {
        buffer.clear();
        buffer.put("HelloClient".getBytes());
        buffer.flip();
        clientChannel.write(buffer);
        System.out.println("Sent: HelloClient");

        // 写完后重新监听读事件
        clientChannel.register(selector, SelectionKey.OP_READ);
    }

    private void closeChannel(SelectionKey key) {
        try {
            if (key != null) {
                key.channel().close();
            }
        } catch (IOException e) {
            System.err.println("Error while closing channel: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new NIOServer(8080).listen();
    }
}
