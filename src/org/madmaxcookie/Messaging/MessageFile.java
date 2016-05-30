package org.madmaxcookie.Messaging;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.jline.internal.InputStreamReader;

/**
 * Created by Raymart on 5/30/2016.
 */
public class MessageFile {

    private FileConfiguration config = null;

    public MessageFile(String name) {
        this.config = YamlConfiguration.loadConfiguration(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(name)));
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public String get(String key) {
        return config.getString(key);
    }
}
