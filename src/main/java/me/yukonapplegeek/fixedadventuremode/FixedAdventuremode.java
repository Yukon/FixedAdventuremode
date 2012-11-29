package me.yukonapplegeek.fixedadventuremode;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class FixedAdventuremode extends JavaPlugin implements Listener {
    public void onDisable() {
        // TODO: Place any custom disable code here.
    }

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (event.getPlayer().getGameMode() == GameMode.ADVENTURE){
            if (event.getBlock().getType() == Material.GLASS){
                event.setCancelled(true);
            } else if (event.getBlock().getType() == Material.THIN_GLASS) {
                event.setCancelled(true);
            }
        }
    }
}