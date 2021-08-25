package se.etnolit.mchogs;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandCake implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            ItemStack cake = new ItemStack(Material.CAKE, 1);

            player.getInventory().addItem(cake);
        } else {
            sender.sendMessage("Only players can have cake!");
            return false;
        }

        return true;
    }
}