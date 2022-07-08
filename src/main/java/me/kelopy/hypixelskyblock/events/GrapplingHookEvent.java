package me.kelopy.hypixelskyblock.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.util.Vector;

public class GrapplingHookEvent implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onFish(PlayerFishEvent e){

        double hookThreshold = 0.25;
        double hForceMult = 0.3;
        double hForceMax = 7.5;
        double vForceMult = 0.7;
        double vForceBonus = 0.5;
        double vForceMax = 1.5;

        Vector vector3;
        Entity entity;
        Block block;
        Player player;
        double d;

          if (e.getState().equals(PlayerFishEvent.State.IN_GROUND) || e.getState().equals(PlayerFishEvent.State.FAILED_ATTEMPT)) {
            entity = e.getHook();
            block = entity.getWorld().getBlockAt(entity.getLocation().add(0.0, -hookThreshold, 0.0));

            if (!block.isEmpty() && !block.isLiquid()) {
                player = e.getPlayer();

                vector3 = entity.getLocation().subtract(player.getLocation()).toVector();

                if (vector3.getY() < 0.0)
                    vector3.setY(0.0);

                vector3.setX(vector3.getX() * hForceMult);
                vector3.setY(vector3.getY() * vForceMult + vForceBonus);
                vector3.setZ(vector3.getZ() * hForceMult);

                d = hForceMax * hForceMax;
                if (vector3.clone().setY(0.0).lengthSquared() > d) {
                    d = d / vector3.lengthSquared();
                    vector3.setX(vector3.getX() * d);
                    vector3.setZ(vector3.getZ() * d);
                }

                if (vector3.getY() > vForceMax)
                    vector3.setY(vForceMax);

                player.setVelocity(vector3);
            }

        }

    }

}
