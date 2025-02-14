package netty.eventloop;

import io.netty.channel.nio.NioEventLoopGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class EventLoopTest_1 {
    private static final Logger log = LoggerFactory.getLogger(EventLoopTest_1.class.getName());

    public static void main(String[] args) {
        // 1. 创建一个 EventLoopGroup 对象
        // 2. 创建一个 ServerBootstrap 对象
        // 3. 设置 ServerBootstrap 的属性
        // 4. 绑定端口
        NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup(2);
        log.info("{}", eventLoopGroup.next());
        log.info("{}", eventLoopGroup.next());
        log.info("{}", eventLoopGroup.next());
        log.info("{}", eventLoopGroup.next());

        eventLoopGroup.next().submit(() -> {
            log.info("hello，我是大明哥，这是 死磕 Netty 系列-111");
        });

        eventLoopGroup.next().submit(() -> {
            log.info("hello，我是大明哥，这是 死磕 Netty 系列-222");
        });

        log.info("这是主线程拉..");

        eventLoopGroup.next().scheduleAtFixedRate(() -> {
            log.info("hello，我是大明哥，这是 死磕 Netty 系列");
        }, 1, 2, TimeUnit.SECONDS);

        log.info("这是主线程拉..");

    }
}
