package netty.eventloop;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.concurrent.TimeUnit;

public class EventLoopTest_5_Server {
    private static final Logger log = LoggerFactory.getLogger(EventLoopTest_5_Server.class.getName());

    public static void main(String[] args) {
        // 处理耗时较长的 EventLoopGroup
        EventLoopGroup otherGroup = new DefaultEventLoopGroup(2);

        new ServerBootstrap()
                .group(new NioEventLoopGroup(), new NioEventLoopGroup(2)) // 切换成主从多线程的模式,BossEventLoopGroup 和 WorkerEventLoopGroup
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                ByteBuf byteBuf = (ByteBuf) msg;
                                String objMsg = byteBuf.toString(Charset.defaultCharset());
                                log.info(objMsg);

                                ctx.fireChannelRead(objMsg);
                            }
                        });
                        ch.pipeline().addLast(otherGroup, "other-eventGroup", new ChannelInboundHandlerAdapter() {
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                TimeUnit.SECONDS.sleep(10);
                                log.info("{}", msg);
                            }
                        });
                    }
                })
                .bind(8081);
    }
}
