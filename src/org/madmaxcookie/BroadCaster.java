package org.madmaxcookie;

import org.bukkit.plugin.java.JavaPlugin;
import org.madmaxcookie.Messaging.MessageFormatter;

import java.util.List;

/**
 * Created by Raymart on 5/30/2016.
 */
public class BroadCaster extends JavaPlugin {

    private static BroadCaster instance = null;

    private static MessageFormatter messageFormatter = null;

    private List<String> broadcastmsgs = null;

    public void onEnable() {
        instance = this;
        messageFormatter = new MessageFormatter();
        initConfig();
        getLogger().info("Broadcaster v" + getDescription().getVersion() + " successfully enabled");
    }

    public void onDisable() {
        instance = null;
        messageFormatter = null;
        broadcastmsgs = null;
        getLogger().info("Broadcaster v" + getDescription().getVersion() + " successfully disabled");
    }

    public static BroadCaster getInstance() {
        return instance;
    }

    public void initConfig() {
        saveDefaultConfig();
        broadcastmsgs = getConfig().getStringList("Broadcast Messages");
    }

    public List<String> getBroadcastMessages() {
        return broadcastmsgs;
    }

    public MessageFormatter getMessageFormatter() {
        return messageFormatter;
    }
}
