package org.madmaxcookie.Messaging;

import org.bukkit.ChatColor;
import org.madmaxcookie.Utils.StringUtil;

/**
 * Created by Raymart on 5/30/2016.
 */
public class MessageFormatter {

    private final MessageFile messageFile;

    public MessageFormatter() {
        this.messageFile = new MessageFile("messages.yml");
    }

    public String format(String key, Object... args) {
        return format(true, key, args);
    }

    public String format(boolean prefix, String key, Object... args) {
        String message = prefix ? messageFile.get("prefix") + messageFile.get(key) : messageFile.get(key);
        for (int i = 0; i < args.length; i++)
            message = message.replace("{" + i + "}", String.valueOf(args[i]));
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public String prefix(String message) {
        return StringUtil.Color(messageFile.get("prefix") + message);
    }

    public MessageFile getMessageFile() {
        return messageFile;
    }
}
