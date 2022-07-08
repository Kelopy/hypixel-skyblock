package me.kelopy.hypixelskyblock.events;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class AOTEEvent implements Listener {

    @EventHandler
    public void onSwordBlock(PlayerInteractEvent e){
        Player p = e.getPlayer();

        ItemStack itemInMainHand = p.getInventory().getItemInMainHand();

        if(itemInMainHand.getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&9Warped Stone Aspect of the End"))){

            float pitch = p.getLocation().getPitch();
            float yaw = p.getLocation().getYaw();

            if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Block block = p.getTargetBlock(null, 10);
                Location location = new Location(block.getWorld(), block.getX(), block.getY(), block.getZ(), yaw, pitch);
                p.teleport(location);
                p.playSound(location, Sound.BLOCK_NOTE_PLING, 1.0f, 1.0f);
            }

        }

    }

}
