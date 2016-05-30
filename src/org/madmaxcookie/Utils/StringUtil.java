package org.madmaxcookie.Utils;

import net.md_5.bungee.api.ChatColor;

/**
 * Created by Raymart on 5/30/2016.
 */
public class StringUtil {

    public static String consolidateStrings(String[] args, int start) {
        String ret = args[start];
        if (args.length > (start + 1)) {
            for (int i = (start + 1); i < args.length; i++)
                ret = ret + " " + args[i];
        }
        return ret;
    }

    public static String Color(String arg0) {
        return ChatColor.translateAlternateColorCodes('&', arg0);
    }
}
