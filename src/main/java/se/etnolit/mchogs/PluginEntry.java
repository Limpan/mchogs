package se.etnolit.mchogs;

import org.bukkit.plugin.java.JavaPlugin;

/** 
 * Entry point for MC-HOGS plugin.
 * 
 * @author Linus Törngren
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
public class PluginEntry extends JavaPlugin {
    
    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        getLogger().info("onEnable called!");
    }

    @Override
    public void onDisable() {
        getLogger().info("onDisable called!");
    }
}
