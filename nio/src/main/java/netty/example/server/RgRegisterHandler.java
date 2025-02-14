package netty.example.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.example.ChannelSessionMemory;
import netty.example.MessageTypeEnum;

public class RgRegisterHandler extends SimpleChannelInboundHandler {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        String[] messages = ((String) msg).split("&");
        String key = messages[0];

        if (MessageTypeEnum.RG_REGISTER.getType().equals(key)) {
            Channel channel = ctx.channel();
            String channelId = channel.id().toString();
            // 注册
            ChannelSessionMemory.put(channelId, channel);

            String waitingUser = ChannelSessionMemory.getWaitingUser();
            if (waitingUser == null || "".equals(waitingUser)) {
                // 无用户等待，则直接加入
                ChannelSessionMemory.putRg(channelId);
            } else {
                // 这里的消息体 messageType&channelId|message
                // -1 消息体表示用户刚刚进来，需要人工去打招呼
                channel.writeAndFlush(MessageTypeEnum.USER_HELLO.getType() + "&" + waitingUser + "|-1");
            }
        } else {
            ctx.fireChannelRead(msg);
        }
    }
}
