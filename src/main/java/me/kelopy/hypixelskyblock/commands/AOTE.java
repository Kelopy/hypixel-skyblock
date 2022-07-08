package me.kelopy.hypixelskyblock.commands;

import me.kelopy.hypixelskyblock.HypixelSkyblock;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import me.kelopy.hypixelskyblock.utils.AOTEUtils;

public class AOTE implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){
            String msg = HypixelSkyblock.getInstance().getConfig().getString("give-aote-msg");
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            ItemStack aote = AOTEUtils.createAOTE();
            p.getInventory().addItem(aote);
        }else{
            System.out.println("This command can only be executed by a player.");
        }

        return true;
    }
}
