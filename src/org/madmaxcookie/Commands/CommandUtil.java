package org.madmaxcookie.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.RemoteConsoleCommandSender;
import org.bukkit.entity.Player;
import org.madmaxcookie.BroadCaster;

/**
 * Created by Raymart on 5/30/2016.
 */
public abstract class CommandUtil {

    private final CommandSender sender;

    private final String name;

    private final String description;

    private final String permission;

    private final String usage;

    private final String[] subPermissions;

    public CommandUtil(CommandSender sender, String name, String description, String permission, String usage, String[] subPermissions) {
        this.sender = sender;
        this.name = name;
        this.description = description;
        this.permission = permission;
        this.usage = usage;
        this.subPermissions = subPermissions;
    }

    public CommandSender getSender() {
        return sender;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPermission() {
        return permission;
    }

    public String[] getSubPermissions() {
        return subPermissions;
    }

    public String getUsage() {
        return usage;
    }

    public boolean hasPermission() {
        return sender.hasPermission(permission) || isSenderConsole() || isSenderRemoteConsole();
    }

    public boolean hasPermission(String arg0) {
        String permission = this.permission + "." + arg0;
        return sender.hasPermission(permission) || isSenderConsole() || isSenderRemoteConsole();
    }

    public void sendUsage() {
        BroadCaster broadcast = BroadCaster.getInstance();
        sender.sendMessage(broadcast.getMessageFormatter().format(false, "error.usage.command", name));
        sender.sendMessage(broadcast.getMessageFormatter().format(false, "error.usage.description", description));
        sender.sendMessage(broadcast.getMessageFormatter().format(false, "error.usage.usage", usage));
    }

    public boolean isSenderPlayer() {
        return (sender instanceof Player);
    }

    public boolean isSenderConsole() {
        return (sender instanceof ConsoleCommandSender);
    }

    public boolean isSenderRemoteConsole() {
        return (sender instanceof RemoteConsoleCommandSender);
    }

    public abstract void publish(CommandSender sender, Command command, String label, String[] args);
}
