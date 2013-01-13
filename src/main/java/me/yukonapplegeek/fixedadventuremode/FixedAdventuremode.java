package me.yukonapplegeek.fixedadventuremode;

import org.bukkit.GameMode;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
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
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onHangingBreakByEntity(HangingBreakByEntityEvent event) {
        if (event.getRemover().getType() == EntityType.PLAYER){
            if (((Player)event.getRemover()).getGameMode() == GameMode.ADVENTURE){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onHangingInteract(PlayerInteractEntityEvent event){
        if (event.getPlayer().getGameMode() == GameMode.ADVENTURE){
            if (event.getRightClicked().getType() == EntityType.ITEM_FRAME){
                event.setCancelled(true);
            }
        }
    }
}