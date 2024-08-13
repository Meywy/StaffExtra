package dev.meywy.staffExtra.commands;

import dev.meywy.staffExtra.util.MenuUtils;
import dev.meywy.staffExtra.util.Message;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffMenuCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {

        if (!(sender instanceof Player p)) {
            sender.sendMessage(Message.prefix + "You need to be player to do that");
            return true;
        }

        boolean hasPermission = p.hasPermission("staffextra.menu") || p.hasPermission("staffextra.*");
        if (!hasPermission) {
            p.sendMessage(Message.prefix + Message.colorize("&cYou can't do that!"));
            return true;
        }

        MenuUtils.openStaffMenu(p);
        return true;
    }
}
