package nio.socket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("www.ctrip.com", 80));
        System.out.println("连接到 www.ctrip.com 网站");
        // 测试SocketChannel是否为open状态
        System.out.println(socketChannel.isOpen());
        // 测试SocketChannel是否已经被连接
        System.out.println(socketChannel.isConnected());
        // 测试SocketChannel是否正在进行连接
        System.out.println(socketChannel.isConnectionPending());
        // 校验正在进行套接字连接的SocketChannel是否已经完成连接
        socketChannel.configureBlocking(false);

        ByteBuffer buf = ByteBuffer.allocate(1024);
        int bytesRead = socketChannel.read(buf);
        System.out.println(bytesRead);
        System.out.println(new String(buf.array()));

        socketChannel.finishConnect();
        socketChannel.close();
    }
}
