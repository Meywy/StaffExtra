package dev.meywy.staffExtra;

import dev.meywy.staffExtra.commands.StaffMenuCMD;
import dev.meywy.staffExtra.commands.StaffModCMD;
import dev.meywy.staffExtra.listners.MenuListener;
import dev.meywy.staffExtra.listners.ModListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class StaffExtra extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("staffmenu").setExecutor(new StaffMenuCMD());
        getCommand("staffmod").setExecutor(new StaffModCMD());
        getCommand("staffmod").setTabCompleter(new StaffModCMD());

        Bukkit.getPluginManager().registerEvents(new MenuListener(), this);
        Bukkit.getPluginManager().registerEvents(new ModListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
