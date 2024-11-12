/*
 * This file belongs to Sculk, a Hypixel Skyblock recreation.
 * Copyright (c) 2024 VortexReanimated
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this library; if not, see <https://www.gnu.org/licenses/>.
 * 
 */
package dev.vortex.sculk.item.oddities;

import dev.vortex.sculk.Spectaculation;
import dev.vortex.sculk.item.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class GrapplingHook implements ToolStatistics, FishingRodFunction {
	private static final List<UUID> COOLDOWN = new ArrayList<>();

	@Override
	public void onFish(SItem instance, PlayerFishEvent e) {
		PlayerFishEvent.State state = e.getState();
		if (state != PlayerFishEvent.State.FAILED_ATTEMPT && state != PlayerFishEvent.State.IN_GROUND) {
			return;
		}
		Player player = e.getPlayer();
		if (COOLDOWN.contains(player.getUniqueId())) {
			player.sendMessage(ChatColor.RED + "Whow! Slow down there!");
			return;
		}
		player.setVelocity(player.getLocation().toVector().subtract(e.getHook().getLocation().toVector()).multiply(-1.0)
				.multiply(0.5).setY(0.9));
		if (player.getGameMode() != GameMode.CREATIVE && player.getGameMode() != GameMode.SPECTATOR) {
			COOLDOWN.add(player.getUniqueId());
			new BukkitRunnable() {
				@Override
				public void run() {
					COOLDOWN.remove(player.getUniqueId());
				}
			}.runTaskLater(Spectaculation.getPlugin(), 40);
		}
	}

	@Override
	public String getDisplayName() {
		return "Grappling Hook";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.UNCOMMON;
	}

	@Override
	public GenericItemType getType() {
		return GenericItemType.ITEM;
	}

	@Override
	public String getLore() {
		return "Travel around in style using this Grappling Hook. 2 Second Cooldown";
	}
}
