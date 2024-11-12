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
package dev.vortex.sculk.listener;

import dev.vortex.sculk.command.RegionCommand;
import dev.vortex.sculk.region.Region;
import dev.vortex.sculk.region.RegionGenerator;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockListener extends PListener {
	@EventHandler
	public void onBlockInteract(PlayerInteractEvent e) {
		Block block = e.getClickedBlock();
		if (block == null) {
			return;
		}
		Player player = e.getPlayer();
		if (!RegionCommand.REGION_GENERATION_MAP.containsKey(player)) {
			return;
		}
		e.setCancelled(true);
		RegionGenerator generator = RegionCommand.REGION_GENERATION_MAP.get(player);
		switch (generator.getPhase()) {
			case 1 : {
				generator.setFirstLocation(block.getLocation());
				generator.setPhase(2);
				player.sendMessage(ChatColor.GRAY + "Set your clicked block as the first location of the region!");
				player.sendMessage(ChatColor.DARK_AQUA + "Click the second corner of your region.");
				break;
			}
			case 2 : {
				generator.setSecondLocation(block.getLocation());
				if (generator.getModificationType().equals("create")) {
					Region.create(generator.getName(), generator.getFirstLocation(), generator.getSecondLocation(),
							generator.getType());
				} else {
					Region region = Region.get(generator.getName());
					region.setFirstLocation(generator.getFirstLocation());
					region.setSecondLocation(generator.getSecondLocation());
					region.setType(generator.getType());
					region.save();
				}
				player.sendMessage(ChatColor.GRAY + "Region \"" + generator.getName() + "\" has been fully set up and "
						+ (generator.getModificationType()) + "d!");
				RegionCommand.REGION_GENERATION_MAP.remove(player);
				break;
			}
		}
	}
}
