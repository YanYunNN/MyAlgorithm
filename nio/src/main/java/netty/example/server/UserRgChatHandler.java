package netty.example.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.example.ChannelSessionMemory;
import netty.example.MessageTypeEnum;

public class UserRgChatHandler extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        String[] messages = ((String) msg).split("&");
        String messageType = messages[0];
        if (MessageTypeEnum.RG_USER_MESSAGE.getType().equals(messageType)) {
            String[] values = messages[1].split("\\|");

            // 转发的内容
            String content = values[1];
            // 发给谁
            String toChannelId = values[0];
            Channel toChannel = ChannelSessionMemory.getClientChannel(toChannelId);

            // 从哪里来
            String fromChannelId = ctx.channel().id().toString();

            // message
            content = MessageTypeEnum.RG_USER_MESSAGE.getType() + "&" + fromChannelId + "|" + content;

            // 发送内容
            toChannel.writeAndFlush(content);
        } else {
            ctx.fireChannelRead(msg);
        }
    }
}