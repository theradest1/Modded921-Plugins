package com.landonbakken.modded921;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerAnimationEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractions implements Listener {
	void onLeftClick(PlayerInteractEvent event){
		event.getPlayer().sendMessage("You left clicked!");
	}

	void onRightClick(PlayerInteractEvent event){
		event.getPlayer().sendMessage("You right clicked!");
	}

	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
			//left click
			onLeftClick(event);
			//stop normal things from happening
			event.setCancelled(true);
			}
			if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			//right click
			onRightClick(event);
			//stop normal things from happening
			event.setCancelled(true);
		}
	}

	@EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        // Check if the damager is a player
        if (event.getDamager() instanceof Player) {
            // Cancel the event to prevent the attack
            event.setCancelled(true);
            // Optionally, notify the player
            ((Player) event.getDamager()).sendMessage("You cannot attack mobs!");
        }
    }

	@EventHandler
    public void onPlayerAnimation(PlayerAnimationEvent event) {
        if (event.getPlayer() instanceof Player) {
            event.setCancelled(true);  // Cancel the animation
        }
    }
}
