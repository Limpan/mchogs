package se.etnolit.mchogs;

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
    @Inject private PlaceVillagerListener placeVillagerListener;

    public HogsPlugin() {
        BinderModule module = new BinderModule(this);
        Injector injector = module.createInjector();
        injector.injectMembers(this);
    }

    @Override
    public void onLoad() {
        
    }

    @Override
    public void onEnable() {

        this.saveDefaultConfig();

        
        this.getCommand("cake").setExecutor(this.commandCake);

        this.getServer().getPluginManager().registerEvents(this.placeVillagerListener, this);
    }

    @Override
    public void onDisable() {
    }
}
