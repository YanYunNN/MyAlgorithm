package netty.example.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import netty.example.ChannelSessionMemory;
import netty.example.MessageTypeEnum;

import java.util.Map;

public class AiAnswerHandler extends SimpleChannelInboundHandler {
    private Map<String, String> answerSet = Map.of(
            "1", "死磕 Java 并发 : https: //www.skjava.com/series/1391296887813967872\n" +
                    "死磕 Java 基础 :https://www.skjava.com/series/1411518540095295488\n" +
                    "死磕 Spring 之 10c : https://www.skjava.com/series/1391374860344758272\n" +
                    "死磕 N10 : https://www.skjava.com/series/1435619891100127232\n" +
                    "死磕 Redis : https://www.skjava.c0m/series/1391389927996002304\n" +
                    "死磕 Netty : https:/ /www.skjava.com/series/1391390190000002560\n",
            "2", "死磕 Java 的网址是：https://www.skjava.com/",
            "3", "请输入您的建议与反馈~"
    );

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        String[] messages = ((String) msg).split("&");
        String key = messages[0];

        Channel channel = ctx.channel();
        String userChannelId = channel.id().toString();

        if (MessageTypeEnum.USER_QUESTION.getType().equals(key)) {
            String value = messages[1];

            if ("0".equals(value)) {
                // 转交给人工 handler 处理
                String rgChannelId = ChannelSessionMemory.getRgChannelId();
                if (rgChannelId == null) {
                    // 如果没有，先将用户添加到等待队列，然后返回给用户目前暂无人工坐席
                    ChannelSessionMemory.putWaitingUser(userChannelId);
                    channel.writeAndFlush("当前暂无人工坐席，继续等待请输入 0 ，退出请输入 9");
                } else {
                    Channel rgChannel = ChannelSessionMemory.get(rgChannelId);
                    rgChannel.writeAndFlush(MessageTypeEnum.USER_HELLO.getType() + "&" + userChannelId + "|有用户咨询");
                }
            } else if ("9".equals(value)) {
                // 用户退出
                ChannelSessionMemory.deleteWaitingUser(userChannelId);
                channel.writeAndFlush("对不起，无法解决您的问题，深感抱歉");
            } else {
                String answer = answerSet.getOrDefault(value, "对不起，无法解决您的问题，深感抱歉");
                channel.writeAndFlush(answer);
            }
        }
    }
}