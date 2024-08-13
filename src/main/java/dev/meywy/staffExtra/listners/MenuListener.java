package dev.meywy.staffExtra.listners;

import dev.meywy.staffExtra.util.Message;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MenuListener implements Listener {

    private List<UUID> vanish = new ArrayList<>();
    private List<UUID> flying = new ArrayList<>();

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {

        if (e.getView().getTitle().equals(Message.colorize("&6&lStaff Menu")) && e.getCurrentItem() != null) {
            Player p = (Player) e.getWhoClicked();
            e.setCancelled(true);

            switch (e.getRawSlot()) {
                case 10: // FLY
                    if (flying.contains(p.getUniqueId())) {
                        flying.remove(p.getUniqueId());
                        p.sendMessage(Message.prefix + Message.colorize("&bFly &fdisabled"));
                        p.setAllowFlight(false);
                    } else {
                        flying.add(p.getUniqueId());
                        p.sendMessage(Message.prefix + Message.colorize("&bFly &fenabled"));
                        p.setAllowFlight(true);
                    }
                    break;
                case 12: // GAMEMODE
                    if (p.getGameMode() != GameMode.CREATIVE) {
                        p.setGameMode(GameMode.CREATIVE);
                        p.sendMessage(Message.prefix + Message.colorize("&aCreative &fEnabled"));
                    } else if (p.getGameMode() != GameMode.SURVIVAL) {
                        p.setGameMode(GameMode.SURVIVAL);
                        p.sendMessage(Message.prefix + Message.colorize("&4Survival &fEnabled"));
                    }
                    break;
                case 14: // VANISH
                    if (vanish.contains(p.getUniqueId())) {
                        vanish.remove(p.getUniqueId());
                        for (Player target : Bukkit.getOnlinePlayers()) {
                            target.showPlayer(p);
                        }
                        p.sendMessage(Message.prefix + Message.colorize("&fVanish: &cOff"));
                    } else {
                        vanish.add(p.getUniqueId());
                        for (Player target : Bukkit.getOnlinePlayers()) {
                            target.hidePlayer(p);
                        }
                        p.sendMessage(Message.prefix + Message.colorize("&fVanish: &aOn"));
                    }
                    break;
                case 16: // DAY
                    p.getWorld().setTime(1000);
                    break;
                case 22:
                    break;
                default:
                    return;
            }
            p.closeInventory();

        }




    }
}
