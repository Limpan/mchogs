package se.etnolit.mchogs;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class BinderModule extends AbstractModule {
    
    private final HogsPlugin plugin;

    public BinderModule(HogsPlugin plugin) {
        this.plugin = plugin;
    }

    public Injector createInjector() {
        return Guice.createInjector(this);
    }

    @Override
    public void configure() {
        this.bind(HogsPlugin.class).toInstance(this.plugin);
    }
}
