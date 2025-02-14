package netty.channel;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LoggingHandler;

import java.util.concurrent.TimeUnit;

public class ChannelServerDemo {
    public static void main(String[] args) throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new LoggingHandler());
                    }

                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        super.channelRead(ctx, msg);
                    }
                });
        Channel channel = bootstrap.bind(8081).channel();

        System.out.println("isOpen:" + channel.isOpen() + ";;;isRegistered:" + channel.isRegistered() + ";;;isActive:" + channel.isActive());

        System.out.println("eventLoop():" + channel.eventLoop());
        System.out.println("pipeline():" + channel.pipeline());

        TimeUnit.SECONDS.sleep(5);
        System.out.println("=============================");
        System.out.println("isOpen:" + channel.isOpen() + ";;;isRegistered:" + channel.isRegistered() + ";;;isActive:" + channel.isActive());
    }
}
