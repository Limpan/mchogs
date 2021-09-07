package se.etnolit.mchogs;

import java.lang.System.Logger;

import com.google.inject.Inject;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class GreeterListener implements Listener {
    
    private HogsPlugin plugin;

    @Inject
    public GreeterListener(HogsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Welcome back!");
    }

    @EventHandler
    public void onGreeterInteraction(PlayerInteractEntityEvent event) {

        if (event.getRightClicked().hasMetadata("greeter")) {
            event.getPlayer().sendMessage("Event");
            plugin.getLogger().info("event");
        }

    }

/*
    @EventHandler
    public void placeGameMasterVillager(PlayerInteractEvent event) {
        Location location = event.getPlayer().getLocation();
        //Villager villager = (Villager) Bukkit.getServer().getWorld("world").spawnEntity(location, EntityType.VILLAGER);
        Villager villager = (Villager) event.getPlayer().getWorld().spawnEntity(location, EntityType.VILLAGER);

        villager.setGravity(false);

    }
    */
}
