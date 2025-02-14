package netty.demo;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HelloWorldClient {
    public static void main(String[] args) throws InterruptedException {
        // 创建服务端启动引导器
        Bootstrap bootstrap = new Bootstrap();
        // 配置线程模型
        bootstrap.group(new NioEventLoopGroup());
        bootstrap.channel(NioSocketChannel.class);
        // 配置处理器
        // 配置 IO 处理器
        bootstrap.handler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ch.pipeline().addLast(new StringEncoder());
            }
        });
        // 建立连接
        Channel channel = bootstrap.connect("127.0.0.1", 8080).channel();
        // 发送消息
        while (true) {
            channel.writeAndFlush(new Date() + "hello world..");
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
