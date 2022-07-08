package me.kelopy.hypixelskyblock;

import me.kelopy.hypixelskyblock.commands.AOTE;
import me.kelopy.hypixelskyblock.commands.GrapplingHook;
import me.kelopy.hypixelskyblock.events.AOTEEvent;
import me.kelopy.hypixelskyblock.events.GrapplingHookEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class HypixelSkyblock extends JavaPlugin {

    private static HypixelSkyblock instance;

    @Override
    public void onEnable() {
        System.out.println("Grinding hypixel skyblock...");

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        instance = this;

        getCommand("aote").setExecutor(new AOTE());
        getCommand("grapplinghook").setExecutor(new GrapplingHook());
        getServer().getPluginManager().registerEvents(new AOTEEvent(), this);
        getServer().getPluginManager().registerEvents(new GrapplingHookEvent(), this);
    }

    public static HypixelSkyblock getInstance(){
        return instance;
    }

}
