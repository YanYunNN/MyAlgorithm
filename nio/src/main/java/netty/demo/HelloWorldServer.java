package netty.demo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

import java.util.Date;

public class HelloWorldServer {
    public static void main(String[] args) {
        // 创建服务端启动引导器
        ServerBootstrap bootstrap = new ServerBootstrap();
        // 配置线程模型
        bootstrap.group(new NioEventLoopGroup());
        bootstrap.channel(NioServerSocketChannel.class);
        // 配置处理器
        // 定义处理器 Handler
        bootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                // 解码
                ch.pipeline().addLast(new StringDecoder());

                ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                    @Override
                    public void channelActive(ChannelHandlerContext ctx) throws Exception {
                        System.out.println(ctx.channel() + ",hello world");
                    }

                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        System.out.println(new Date() + "：" + msg);
                    }
                });
            }
        });
        // 绑定端口
        bootstrap.bind(8080);
    }
}
