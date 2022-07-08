package me.kelopy.hypixelskyblock.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class AOTEUtils {

    public static ItemStack createAOTE(){

        ItemStack aote = new ItemStack(Material.DIAMOND_SWORD, 1);
        aote.addEnchantment(Enchantment.DAMAGE_ALL, 5);

        ItemMeta aoteMeta = aote.getItemMeta();
        aoteMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&9Warped Stone Aspect of the End"));
        aoteMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        aoteMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        aoteMeta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        aoteMeta.setUnbreakable(true);

        ArrayList<String> aoteLore = new ArrayList<>();
        aoteLore.add(ChatColor.GRAY + "Gear Score: " + ChatColor.LIGHT_PURPLE + "550 " + ChatColor.DARK_GRAY + "(1287)");
        aoteLore.add(ChatColor.GRAY + "Damage: " + ChatColor.RED + "+275 " + ChatColor.BLUE + "(Warped Stone +20) " + ChatColor.DARK_GRAY + "(+643.5)");
        aoteLore.add(ChatColor.GRAY + "Strength: " + ChatColor.RED + "+275 " + ChatColor.BLUE + "(Warped Stone +20) " + ChatColor.DARK_GRAY + "(+643.5)");
        aoteLore.add("");
        aoteLore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Ultimate Wise 5");
        aoteLore.add("");
        aoteLore.add(ChatColor.GOLD + "Item Ability: Instant Transmission " + ChatColor.YELLOW + "" + ChatColor.BOLD + "RIGHT CLICK");
        aoteLore.add(ChatColor.GRAY + "Teleport " + ChatColor.GREEN + "8 blocks " + ChatColor.GRAY + "ahead of");
        aoteLore.add(ChatColor.GRAY + "you and gain " + ChatColor.GREEN + "+50 " + ChatColor.WHITE + "✦ Speed");
        aoteLore.add(ChatColor.GRAY + "for " + ChatColor.GREEN + "3 seconds" + ChatColor.GRAY + ".");
        aoteLore.add(ChatColor.DARK_GRAY + "Mana Cost " + ChatColor.DARK_AQUA + "25");
        aoteLore.add("");
        aoteLore.add(ChatColor.BLUE + "" + ChatColor.BOLD + "RARE DUNGEON SWORD");

        aoteMeta.setLore(aoteLore);
        aote.setItemMeta(aoteMeta);

        return aote;
    }

}
