
package se.etnolit.mchogs;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.junit.jupiter.api.Test;

class CommandCakeTest {
    @Test
    void testAddsCakeToInventoryOfPlayer() {
        CommandExecutor subject = new CommandCake();

        Player player = mock(Player.class);
        PlayerInventory inventory = mock(PlayerInventory.class);
        when(player.getInventory()).thenReturn(inventory);

        Command command = mock(Command.class);

        subject.onCommand(player, command, "/cake", new String[0]);

        verify(inventory).addItem(any(ItemStack.class));
    }

    @Test
    void testWontAllowConsole() {
        CommandExecutor subject = new CommandCake();

        ConsoleCommandSender console = mock(ConsoleCommandSender.class);
        
        Command command = mock(Command.class);

        subject.onCommand(console, command, "/cake", new String[0]);

        verify(console, atLeastOnce()).sendMessage("Only players can have cake!");
    }
}
