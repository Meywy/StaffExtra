package dev.meywy.staffExtra.util;

import org.bukkit.ChatColor;

public class Message {

    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String prefix = colorize("&6StaffExtra&7: ");
}
