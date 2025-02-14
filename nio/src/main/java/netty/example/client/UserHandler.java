package netty.example.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import netty.example.MessageTypeEnum;

import java.util.Scanner;

public class UserHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().writeAndFlush(MessageTypeEnum.USER_REGISTER.getType() + "&我是用户:" + ctx.channel().id().toString());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String message = (String) msg;
        System.out.println(message);

        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        ctx.channel().writeAndFlush(MessageTypeEnum.USER_QUESTION.getType() + "&" + key);
    }
}