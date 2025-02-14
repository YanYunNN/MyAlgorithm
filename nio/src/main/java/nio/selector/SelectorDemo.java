package nio.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Scanner;

public class SelectorDemo {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(new InetSocketAddress(8081));

        // 打开Selector
        Selector selector = Selector.open();
        // 通常我们都是先注册一个 OP_ACCEPT 事件, 然后在 OP_ACCEPT 到来时, 再将这个 Channel 的 OP_READ
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    // 当客户端连接服务端的时候，我们需要服务端与之建立连接
                    ServerSocketChannel socketChannel = (ServerSocketChannel) key.channel();
                    SocketChannel clientChannel = socketChannel.accept();
                    clientChannel.configureBlocking(false);
                    clientChannel.register(selector, SelectionKey.OP_READ);
                    System.out.println("接收到客户端连接请求");
                } else if (key.isConnectable()) {
                    System.out.println("连接已经建立");
                } else if (key.isReadable()) {
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    ByteBuffer byteBuf = ByteBuffer.allocate(64);
                    int size = clientChannel.read(byteBuf);
                    if (size < 0) {
                        System.out.println("客户端断开连接");
                        clientChannel.close();
                    } else if (size > 0) {
                        byteBuf.flip();
                        CharBuffer charBuffer = StandardCharsets.UTF_8.decode(byteBuf);
                        System.out.println("接收到数据：" + charBuffer);
                        String str = new Scanner(System.in).nextLine();
                        ByteBuffer writeBuffer = StandardCharsets.UTF_8.encode(str);
                        clientChannel.write(writeBuffer);

                        // 如果不能一次性发完只需要触发 write 事件去发
                        if (writeBuffer.hasRemaining()) {
                            key.attach(writeBuffer);
                            key.interestOps(key.interestOps() + SelectionKey.OP_WRITE);
                        }
                    }
                } else if (key.isWritable() && key.isValid()) {
                    SocketChannel clientChannel = (SocketChannel) key.channel();
                    ByteBuffer byteBuffer = (ByteBuffer) key.attachment();
                    byteBuffer.flip();

                    clientChannel.write(byteBuffer);
                    // 如果已完，则只无须关注 write 事件
                    if (!byteBuffer.hasRemaining()) {
                        key.attach(null);
                        key.interestOps(key.interestOps() - SelectionKey.OP_WRITE);
                    }
                    System.out.println("有数据可写");
                }
            }
            // 获取一个 SelectionKey 后，我们要将其删除掉，表示我们已经处理了这个事件
            iterator.remove();
        }
    }

}
