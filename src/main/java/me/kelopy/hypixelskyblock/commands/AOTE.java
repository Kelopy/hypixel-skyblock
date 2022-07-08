package me.kelopy.hypixelskyblock.commands;

import me.kelopy.hypixelskyblock.HypixelSkyblock;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import me.kelopy.hypixelskyblock.utils.AOTEUtils;

public class AOTE implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            if(args.length == 0){
                ItemStack aote = AOTEUtils.createAOTE();
                p.getInventory().addItem(aote);
                String msg = "&7You've been given an &bAspect of the End&7!";
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }else if(args.length == 1){
                Player target = Bukkit.getPlayerExact(args[0]);

                if(target != null){
                    ItemStack aote = AOTEUtils.createAOTE();
                    target.getInventory().addItem(aote);
                    String msgOther = "&7You've given &b" + target.getDisplayName() + " &7an &bAspect of the End&7!";
                    String msgOtherPlayer = "&7You've been given an &bAspect of the End&7!";
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', msgOther));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', msgOtherPlayer));
                }else{
                    p.sendMessage(ChatColor.RED + "Player not found.");
                }

            }

        }else if(sender instanceof ConsoleCommandSender && args.length == 1){
            Player target = Bukkit.getPlayerExact(args[0]);

            if(target != null){
                ItemStack aote = AOTEUtils.createAOTE();
                target.getInventory().addItem(aote);
                System.out.println("CONSOLE has given " + target.getName() + " an Aspect of the End");
                String consoleGive = "&7You were given an &bAspect of the End &7by &bCONSOLE";
                target.sendMessage(ChatColor.translateAlternateColorCodes('&', consoleGive));
            }else{
                System.out.println("Player not found");
            }

        }else{
            System.out.println("This command can only be executed by a player.");
        }

        return true; // im confused
    }

}
