package netty.example;

import io.netty.channel.Channel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChannelSessionMemory {
    private final static Map<String, Channel> memory = new HashMap<>();
    private final static List<String> waitingUsers = new ArrayList<>();
    private final static List<String> rgs = new ArrayList<>();

    public static void put(String key, Channel value) {
        memory.put(key, value);
    }

    public static Channel get(String key) {
        return memory.get(key);
    }

    public static String getWaitingUser() {
        return waitingUsers.get(0) == null ? "" : waitingUsers.get(0);
    }

    public static void putWaitingUser(String userChannelId) {
        waitingUsers.add(userChannelId);
    }

    public static void deleteWaitingUser(String userChannelId) {
        waitingUsers.remove(userChannelId);
    }

    public static String getRgChannelId() {
        return null;
    }

    public static void putRg(String channelId) {
        rgs.add(channelId);
    }

    public static Channel getClientChannel(String toChannelId) {
        return null;
    }
}
