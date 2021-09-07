package se.etnolit.mchogs;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.google.inject.Inject;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.metadata.FixedMetadataValue;

public class CommandHOGS implements CommandExecutor {

    private HogsPlugin plugin;

    @Inject
    public void CommandHOGS(HogsPlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Location location = player.getLocation();
            Villager villager = (Villager) player.getWorld().spawnEntity(location, EntityType.VILLAGER);
    
            //plugin.greeterUUID = villager.getUniqueId();

            villager.setMetadata("greeter", new FixedMetadataValue(this.plugin, "greeter"));

            villager.setCustomName("Greeter");
            villager.setCustomNameVisible(true);
            
        } else {
            sender.sendMessage("Only players can have cake!");
            return false;
        }

        return true;
    }
}