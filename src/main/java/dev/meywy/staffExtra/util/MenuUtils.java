package dev.meywy.staffExtra.util;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;

import java.util.Arrays;

public class MenuUtils {

    public static void openStaffMenu(Player p) {

        Inventory inv = Bukkit.createInventory(p, 27, Message.colorize("&6&lStaff Menu"));

        // FLY
        ItemStack fly = new ItemStack(Material.FEATHER);
        ItemMeta flyMeta = fly.getItemMeta();
        flyMeta.setDisplayName(Message.colorize("&b&lFly"));
        flyMeta.setLore(Arrays.asList(Message.colorize("&7Enables and disables Fly")));
        fly.setItemMeta(flyMeta);
        inv.setItem(10, fly);

        // GAMEMODE
        ItemStack creative = new ItemStack(Material.BEDROCK);
        ItemMeta creativeMeta = creative.getItemMeta();
        creativeMeta.setDisplayName(Message.colorize("&a&lGamemode"));
        creativeMeta.setLore(Arrays.asList(Message.colorize("&7Changes your gamemode between Survival and Creative")));
        creative.setItemMeta(creativeMeta);
        inv.setItem(12, creative);

        // VANISH
        ItemStack vanish = new ItemStack(Material.POTION);
        PotionMeta vanishMeta = (PotionMeta) vanish.getItemMeta();
        vanishMeta.setDisplayName(Message.colorize("&f&lVanish"));
        vanishMeta.addItemFlags(ItemFlag.HIDE_ADDITIONAL_TOOLTIP);
        vanishMeta.setColor(Color.WHITE);
        vanishMeta.setLore(Arrays.asList(Message.colorize("&7Turns Vanish &aON &7and &cOFF")));
        vanish.setItemMeta(vanishMeta);
        inv.setItem(14, vanish);

        // DAY
        ItemStack day = new ItemStack(Material.CLOCK);
        ItemMeta dMeta = day.getItemMeta();
        dMeta.setDisplayName(Message.colorize("&e&lDay"));
        dMeta.setLore(Arrays.asList(Message.colorize("&7Sets time to day")));
        day.setItemMeta(dMeta);
        inv.setItem(16, day);

        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName(Message.colorize("&c&lClose Menu"));
        close.setItemMeta(closeMeta);
        inv.setItem(22, close);

        ItemStack frame = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
        for (int i : new int[]{0,1,2,3,4,5,6,7,8,9,17,18,19,20,21,23,24,25,26}) {
            inv.setItem(i, frame);
        }

        p.openInventory(inv);
    }

}
