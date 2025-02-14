package netty.channel;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.TimeUnit;

public class ChannelClientDemo {
    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new LoggingHandler());
                    }
                });
        Channel channel = bootstrap.connect("127.0.0.1", 8081).channel();

        System.out.println("isOpen:" + channel.isOpen() + ";;;isRegistered:" + channel.isRegistered() + ";;;isActive:" + channel.isActive());

        System.out.println("eventLoop():" + channel.eventLoop());
        System.out.println("pipeline():" + channel.pipeline());

        TimeUnit.SECONDS.sleep(5);
        System.out.println("=============================");
        System.out.println("isOpen:" + channel.isOpen() + ";;;isRegistered:" + channel.isRegistered() + ";;;isActive:" + channel.isActive());
    }
}
