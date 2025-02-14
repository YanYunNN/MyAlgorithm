package netty.example.client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import netty.example.MessageTypeEnum;

import java.util.Scanner;

public class RgHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.channel().writeAndFlush(MessageTypeEnum.RG_REGISTER.getType() + "&我是人工坐席:" + ctx.channel().id().toString());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        String[] message = ((String) msg).split("&");
        String messageType = message[0];
        String[] values = message[1].split("\\|");
        String userChannelId = values[0];

        String rgChannelId = ctx.channel().id().toString();

        if (MessageTypeEnum.USER_HELLO.getType().equals(messageType)) {
            System.out.println("有用户[" + userChannelId + "]在等待人工坐席，请尽快接入");

            ctx.channel().writeAndFlush(MessageTypeEnum.RG_USER_MESSAGE.getType() + "&" + userChannelId + "|您好，我是工号[" + rgChannelId + "]，请问您有什么问题需要咨询吗？");
        } else if (MessageTypeEnum.RG_USER_MESSAGE.getType().equals(messageType)) {
            String content = values[1];

            System.out.println("用户说：" + content);
            System.out.println();

            Scanner scanner = new Scanner(System.in);
            String rgContent = scanner.nextLine();

            // 人工坐席 Channel
            String toChannelId = values[0];
            rgContent = MessageTypeEnum.RG_USER_MESSAGE.getType() + "&" + toChannelId + "|" + rgContent;

            ctx.channel().writeAndFlush(rgContent);
        }

    }
}