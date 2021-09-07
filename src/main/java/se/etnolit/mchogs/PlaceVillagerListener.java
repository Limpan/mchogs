package se.etnolit.mchogs;

import com.google.inject.Inject;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlaceVillagerListener implements Listener {
    
    private HogsPlugin plugin;

    @Inject
    public PlaceVillagerListener(HogsPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
//        String message = this.plugin.getConfig().getString("message");
        event.getPlayer().sendMessage("Welcome back!");
    }

    @EventHandler
    public void placeGameMasterVillager(PlayerInteractEvent event) {
        Location location = event.getPlayer().getLocation();
        //Villager villager = (Villager) Bukkit.getServer().getWorld("world").spawnEntity(location, EntityType.VILLAGER);
        Villager villager = (Villager) event.getPlayer().getWorld().spawnEntity(location, EntityType.VILLAGER);

    }
}
