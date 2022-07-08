package me.kelopy.hypixelskyblock;

import me.kelopy.hypixelskyblock.commands.AOTE;
import me.kelopy.hypixelskyblock.events.AOTEEvent;
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
        getServer().getPluginManager().registerEvents(new AOTEEvent(), this);
    }

    public static HypixelSkyblock getInstance(){
        return instance;
    }

}
