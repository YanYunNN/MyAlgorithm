package netty.example.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.example.ChannelSessionMemory;
import netty.example.MessageTypeEnum;

public class ClientRegisterHandler extends SimpleChannelInboundHandler {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        String[] messages = ((String) msg).split("&");

        String key = messages[0];
        String value = messages[1];
        Channel channel = ctx.channel();

        if (MessageTypeEnum.USER_REGISTER.getType().equals(key)) {
            // 用户
            ChannelSessionMemory.put(channel.id().toString(), channel);
            // 用户注册成功后，立刻向用户发送问题列表
            sendInitMessage(channel);
        } else {
            ctx.fireChannelRead(value);
        }
    }

    /**
     * 发送消息
     * @param channel
     */
    private void sendInitMessage(Channel channel) {
        StringBuilder message = new StringBuilder(channel.id().toString() + ",您好，我是智能客服小磕。请告诉你想咨询的服务").append("\r\n")
                .append("1. 死磕 Java 目前哪些系列").append("\r\n")
                .append("2. 死磕 Java 的网址哪个").append("\r\n")
                .append("3. 投诉与建议").append("\r\n")
                .append("0. 人工").append("\r\n")
                .append("==================请输入咨询问题的编号==================");
        channel.writeAndFlush(message);
    }
}
