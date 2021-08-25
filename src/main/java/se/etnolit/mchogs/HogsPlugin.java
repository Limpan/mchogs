package se.etnolit.mchogs;

import javax.inject.Inject;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;

import org.bukkit.plugin.java.JavaPlugin;

/** 
 * Entry point for MC-HOGS plugin.
 * 
 * @author Linus Törngren
 * @version 1.0-SNAPSHOT
 * @since 1.0-SNAPSHOT
 */
@Singleton
public class HogsPlugin extends JavaPlugin {
    
    @Inject private CommandCake commandCake;

    public HogsPlugin() {
        Injector injector = Guice.createInjector();
        commandCake = injector.getInstance(CommandCake.class);
    }

    @Override
    public void onEnable() {
        BinderModule module = new BinderModule(this);
        Injector injector = module.createInjector();
        injector.injectMembers(this);

        this.getCommand("cake").setExecutor(this.commandCake);
        
        this.saveDefaultConfig();

        getLogger().info("onEnable called!");
    }

    @Override
    public void onDisable() {
        getLogger().info("onDisable called!");
    }
}

