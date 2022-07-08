package me.kelopy.hypixelskyblock.commands;

import me.kelopy.hypixelskyblock.utils.GrapplingHookUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class GrapplingHook implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p){

            if(args.length == 0){
                ItemStack hook = GrapplingHookUtils.createGrapplingHook();
                p.getInventory().addItem(hook);
                String msg = "&7You've been given a &aGrappling Hook&7!";
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            }else if(args.length == 1){
                Player target = Bukkit.getPlayerExact(args[0]);

                if(target != null){
                    ItemStack hook = GrapplingHookUtils.createGrapplingHook();
                    target.getInventory().addItem(hook);
                    String msgOther = "&7You've given &b" + target.getDisplayName() + " &7a &aGrappling Hook&7!";
                    String msgOtherPlayer = "&7You've been given a &aGrappling Hook&7!";
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', msgOther));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', msgOtherPlayer));
                }else{
                    p.sendMessage(ChatColor.RED + "Player not found.");
                }

            }

        }else if(sender instanceof ConsoleCommandSender && args.length == 1){
            Player target = Bukkit.getPlayerExact(args[0]);

            if(target != null){
                ItemStack hook = GrapplingHookUtils.createGrapplingHook();
                target.getInventory().addItem(hook);
                System.out.println("CONSOLE has given " + target.getName() + " a Grappling Hook");
                String consoleGive = "&7You were given a &aGrappling Hook &7by &bCONSOLE";
                target.sendMessage(ChatColor.translateAlternateColorCodes('&', consoleGive));
            }else{
                System.out.println("Player not found");
            }

        }else{
            System.out.println("This command can only be executed by a player.");
        }

        return true;
    }

}
