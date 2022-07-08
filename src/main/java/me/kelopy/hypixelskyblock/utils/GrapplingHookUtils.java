package me.kelopy.hypixelskyblock.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GrapplingHookUtils {

    public static ItemStack createGrapplingHook(){

        ItemStack hook = new ItemStack(Material.FISHING_ROD, 1);

        ItemMeta hookMeta = hook.getItemMeta();
        hookMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aGrappling Hook"));
        hookMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        hookMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        hookMeta.setUnbreakable(true);

        ArrayList<String> hookLore = new ArrayList<>();
        hookLore.add(ChatColor.GRAY + "Travel around in style using");
        hookLore.add(ChatColor.GRAY + "this Grappling Hook. ");
        hookLore.add(ChatColor.DARK_GRAY + "No Cooldown.");
        hookLore.add("");
        hookLore.add(ChatColor.GREEN + "" + ChatColor.BOLD + "UNCOMMON");

        hookMeta.setLore(hookLore);
        hook.setItemMeta(hookMeta);

        return hook;
    }

}
