package netty.channel;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.time.LocalTime;
import java.util.Map;

public class ChannelHandlerTest_1_server extends ChannelInboundHandlerAdapter {
    public static void main(String[] args) {
        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ChannelHandlerTest());
                    }
                });
        bootstrap.bind(8081);
    }

    private static class ChannelHandlerTest extends ChannelInboundHandlerAdapter {
        @Override
        public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
            System.out.println(LocalTime.now() + "--handlerAdded：handler 被添加到 ChannelPipeline");
            super.handlerAdded(ctx);
        }

        @Override
        public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println(LocalTime.now() + "--channelRegistered：Channel 注册到 EventLoop");
            super.channelRegistered(ctx);
        }

        @Override
        public void channelActive(ChannelHandlerContext ctx) throws Exception {
            System.out.println(LocalTime.now().toString() + "--channelActive：Channel 准备就绪");
            super.channelActive(ctx);
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            System.out.println(LocalTime.now().toString() + "--channelRead：Channel 中有可读数据");
            Map<String, String> map = (Map<String, String>) msg;
            System.out.println("接收到的数据：" + map.toString());
            String code = map.get("code");
            System.out.println("code：" + code);
            super.channelRead(ctx, msg);
        }

        @Override
        public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
            System.out.println(LocalTime.now().toString() + "--channelReadComplete：Channel 读取数据完成");
            super.channelReadComplete(ctx);
        }

        @Override
        public void channelInactive(ChannelHandlerContext ctx) throws Exception {
            System.out.println(LocalTime.now().toString() + "--channelInactive：Channel 被关闭，不在活跃");
            super.channelInactive(ctx);
        }

        @Override
        public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
            System.out.println(LocalTime.now().toString() + "--channelUnregistered：Channe 从 EventLoop 中被取消");
            super.channelUnregistered(ctx);
        }

        @Override
        public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
            System.out.println(LocalTime.now().toString() + "--handlerRemoved：handler 从 ChannelPipeline 中移除");
            super.handlerRemoved(ctx);
        }
    }
}
