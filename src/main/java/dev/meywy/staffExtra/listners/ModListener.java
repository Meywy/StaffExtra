package dev.meywy.staffExtra.listners;

import dev.meywy.staffExtra.commands.StaffModCMD;
import dev.meywy.staffExtra.util.MenuUtils;
import dev.meywy.staffExtra.util.Message;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ModListener implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getHand() == null) return;
        ItemStack inHand = p.getInventory().getItem(e.getHand());

        if (inHand == null || !inHand.hasItemMeta() || !inHand.getItemMeta().hasCustomModelData()) return;

        try {
            if (inHand.getItemMeta().getCustomModelData() == 1) {
                MenuUtils.openStaffMenu(p);
            }

            if (inHand.getItemMeta().getCustomModelData() == 2) {
                Random rand = new Random();
                Player target = (Player) Bukkit.getOnlinePlayers().toArray()[rand.nextInt(Bukkit.getOnlinePlayers().size())];
                p.teleport(target);
                p.sendMessage(Message.prefix + Message.colorize("&7Teleported to &d") + target.getName());
            }

            if (inHand.getItemMeta().getCustomModelData() == 3) {
                StaffModCMD.staffmod.remove(p.getUniqueId());
                p.getInventory().clear();
                p.sendMessage(Message.prefix + Message.colorize("&7StaffMod: &cOff"));
            }


        } catch (Exception exc) {
            Bukkit.getLogger().warning(exc.getMessage());
        }
    }


}
