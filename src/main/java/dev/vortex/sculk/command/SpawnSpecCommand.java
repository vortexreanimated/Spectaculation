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
package dev.vortex.sculk.command;

import dev.vortex.sculk.entity.SEntity;
import dev.vortex.sculk.entity.SEntityType;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

@CommandParameters(description = "Spawn a mob from Spec.", aliases = "spspec", permission = "spt.spawn")
public class SpawnSpecCommand extends SCommand {
	@Override
	public void run(CommandSource sender, String[] args) {
		if (args.length == 0) {
			throw new CommandArgumentException();
		}
		if (sender instanceof ConsoleCommandSender) {
			throw new CommandFailException("Console senders cannot use this command!");
		}
		Player player = sender.getPlayer();
		SEntityType type = SEntityType.getEntityType(args[0]);
		if (type == null) {
			throw new CommandFailException("Invalid entity type.");
		}
		SEntity entity;
		switch (type) {
			case REVENANT_HORROR :
			case SVEN_PACKMASTER :
			case TARANTULA_BROODFATHER : {
				if (args.length != 2) {
					throw new CommandArgumentException();
				}
				int tier = Integer.parseInt(args[1]);
				entity = new SEntity(player, type, tier, player.getUniqueId());
				break;
			}
			default :
				entity = new SEntity(player, type);
				break;
		}
		send("You have spawned a(n) " + entity.getStatistics().getEntityName());
	}
}
