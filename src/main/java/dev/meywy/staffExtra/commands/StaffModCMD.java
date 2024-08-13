package dev.meywy.staffExtra.commands;

import dev.meywy.staffExtra.util.Message;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class StaffModCMD implements CommandExecutor, TabCompleter {

    public static List<UUID> staffmod = new ArrayList<>();

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0], Arrays.asList("on", "off"), new ArrayList<>());
        }

        return new ArrayList<>();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (!(sender instanceof Player p)) {
            sender.sendMessage(Message.prefix + "You need to be player to do that");
            return true;
        }

        boolean hasPermission = p.hasPermission("staffextra.staffmod") || p.hasPermission("staffextra.*");
        if (!hasPermission) {
            p.sendMessage(Message.prefix + Message.colorize("&cYou can't do that!"));
            return true;
        }

        if (args.length == 0) {
            p.sendMessage(Message.prefix + Message.colorize("&7Usage: /staffmod <on/off>"));
            return true;
        }

        Inventory inv = p.getInventory();

        // TODO: Add save inventory feature
        if (args[0].equalsIgnoreCase("on")) {
            if (!(staffmod.contains(p.getUniqueId()))) {
                staffmod.add(p.getUniqueId());
                inv.clear();
                p.sendMessage(Message.prefix + Message.colorize("&7StaffMod: &aOn"));

                ItemStack menu = new ItemStack(Material.BOOK);
                ItemMeta menuMeta = menu.getItemMeta();
                menuMeta.setDisplayName(Message.colorize("&6Menu"));
                menuMeta.setLore(Arrays.asList(Message.colorize("&7Opens StaffMod Menu")));
                menuMeta.setCustomModelData(1);
                menu.setItemMeta(menuMeta);
                inv.setItem(0, menu);

                ItemStack rtp = new ItemStack(Material.COMPASS);
                ItemMeta rtpMeta = rtp.getItemMeta();
                rtpMeta.setDisplayName(Message.colorize("&5Random Teleport"));
                rtpMeta.setLore(Arrays.asList(Message.colorize("&7Teleport to random player")));
                rtpMeta.setCustomModelData(2);
                rtp.setItemMeta(rtpMeta);
                inv.setItem(4, rtp);

                ItemStack exit = new ItemStack(Material.RED_DYE);
                ItemMeta exitMeta = exit.getItemMeta();
                exitMeta.setDisplayName(Message.colorize("&cExit StaffMod"));
                exitMeta.setLore(Arrays.asList(Message.colorize("&7Exits the StaffMod")));
                exitMeta.setCustomModelData(3);
                exit.setItemMeta(exitMeta);
                inv.setItem(8, exit);

                return true;
            }
            p.sendMessage(Message.prefix + Message.colorize("&cYou are already in StaffMod"));
            return true;
        }

        if (args[0].equalsIgnoreCase("off")) {
            if (staffmod.contains(p.getUniqueId())) {
                staffmod.remove(p.getUniqueId());
                inv.clear();
                p.sendMessage(Message.prefix + Message.colorize("&7StaffMod: &cOff"));
                return true;
            }
            p.sendMessage(Message.prefix + Message.colorize("&cYou are not in StaffMod"));
            return true;
        }

        p.sendMessage(Message.prefix + Message.colorize("&7Usage: /staffmod <on/off>"));
        return true;
    }
}
