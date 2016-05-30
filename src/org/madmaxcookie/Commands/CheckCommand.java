package org.madmaxcookie.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.madmaxcookie.BroadCaster;
import org.madmaxcookie.Utils.StringUtil;

import java.util.List;

/**
 * Created by Raymart on 5/30/2016.
 */
public class CheckCommand extends CommandUtil {

    public static final String NAME = "Check";
    public static final String DESCRIPTION = "Check existed broadcasts message";
    public static final String PERMISSION = "broadcaster.check";
    public static final String USAGE = "/broadcaster check";
    public static final String[] SUBPERMISSIONS = {""};

    public CheckCommand(CommandSender sender) {
        super(sender, NAME, DESCRIPTION, PERMISSION, USAGE, SUBPERMISSIONS);
    }
    BroadCaster broadCaster = BroadCaster.getInstance();
    @Override
    public void publish(CommandSender sender, Command cmd, String label, String[] args) {
        if(!hasPermission()) {
            sender.sendMessage(broadCaster.getMessageFormatter().format("error.no-permission"));
            return;
        }
        if(args.length == 0) {
            sendUsage();
            return;
        }
        if(broadCaster.getBroadcastMessages().isEmpty()) {
            sender.sendMessage(StringUtil.Color(broadCaster.getMessageFormatter().format("error.no-broadcastmsgs")));
            return;
        }
        for(String msgs : broadCaster.getBroadcastMessages()) {
            sender.sendMessage(StringUtil.Color("&6Showing broadcast messages"));
            sender.sendMessage(StringUtil.Color("&7- &b" + msgs));
        }
        return;
    }
}
