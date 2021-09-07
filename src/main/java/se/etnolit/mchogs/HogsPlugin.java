package se.etnolit.mchogs;

import java.lang.System.Logger;
import java.util.UUID;

import javax.inject.Inject;

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
    @Inject private CommandHOGS commandHOGS;
    @Inject private GreeterListener greeterListener;
    
//    public UUID greeterUUID;

    public HogsPlugin() {
        BinderModule module = new BinderModule(this);
        Injector injector = module.createInjector();
        injector.injectMembers(this);
    }

    @Override
    public void onLoad() {
        this.saveDefaultConfig();
    }

    @Override
    public void onEnable() {
        this.getCommand("cake").setExecutor(this.commandCake);
        this.getCommand("hogs").setExecutor(this.commandHOGS);

        this.getServer().getPluginManager().registerEvents(this.greeterListener, this);
    }

    @Override
    public void onDisable() {
    }
}
