package netty.channelpipeline;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PipelineServer {
    private static final Logger log = LoggerFactory.getLogger(PipelineServer.class);

    public static void main(String[] args) {
        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new InboundHandler("InboundHandler-1", false));
                        pipeline.addLast(new InboundHandler("InboundHandler-2", false));
                        pipeline.addLast(new OutboundHandler("OutboundHandler-1"));
                        pipeline.addLast(new OutboundHandler("OutboundHandler-2"));
                        pipeline.addLast(new InboundHandler("InboundHandler-3", true));
                        pipeline.addLast(new ExceptionHandler());
                    }
                });
        bootstrap.bind(8081);
    }

    private static class InboundHandler extends ChannelInboundHandlerAdapter {
        // handler 的名称
        private String handlerName;
        // 是否写数据
        private Boolean flushFlag;

        public InboundHandler(String handlerName, Boolean flushFlag) {
            this.handlerName = handlerName;
            this.flushFlag = flushFlag;
        }

        @Override
        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
            log.info("InboundHandler :{}", handlerName);

            if ("InboundHandler-2".equals(handlerName)) {
                throw new RuntimeException("InboundHandler Exception");
            }

            if (!flushFlag) {
                // 不需要写数据，传递给下一个节点
                ctx.fireChannelRead(msg);
            } else {
                // 写数据，则调用 channel.writeAndFlush()
                log.info("==============================");
//                ctx.channel().writeAndFlush(msg);
                ctx.writeAndFlush(msg);
            }
        }

        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
            System.out.println("InBoundHandler Exception: " + handlerName);

            // 将异常传播下去
            ctx.fireExceptionCaught(cause);
        }
    }

    private static class OutboundHandler extends ChannelOutboundHandlerAdapter {
        // handler 的名称
        private String handlerName;

        public OutboundHandler(String handlerName) {
            this.handlerName = handlerName;
        }

        @Override
        public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
            log.info("OutboundHandler :{}", handlerName);
            super.write(ctx, msg, promise);
        }
    }

    private static class ExceptionHandler extends ChannelDuplexHandler {
        @Override
        public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
            if (cause instanceof Exception) {
                log.info("ExceptionHandler");
            }

        }
    }
}
