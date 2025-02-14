package netty.example;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import netty.example.server.UserRgChatHandler;
import netty.example.server.AiAnswerHandler;
import netty.example.server.RgRegisterHandler;
import netty.example.server.UserRegisterHandler;

public class ChatServer {
    public static void main(String[] args) {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(new NioEventLoopGroup(), new NioEventLoopGroup());
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ch.pipeline().addLast(new StringDecoder());     // 解码
                ch.pipeline().addLast(new StringEncoder());     // 编码

                ch.pipeline().addLast(new UserRegisterHandler());
                ch.pipeline().addLast(new RgRegisterHandler());
                ch.pipeline().addLast(new AiAnswerHandler());
                ch.pipeline().addLast(new UserRgChatHandler());
            }
        });
        bootstrap.bind(8081);
    }

}
