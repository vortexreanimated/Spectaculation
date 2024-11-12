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

import net.minecraft.server.v1_8_R3.EntityHuman;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftHumanEntity;
import org.bukkit.entity.Player;

@CommandParameters(description = "Modify your absorption amount.", permission = "spt.player")
public class AbsorptionCommand extends SCommand {
	@Override
	public void run(CommandSource sender, String[] args) {
		if (args.length != 1) {
			throw new CommandArgumentException();
		}
		if (sender instanceof ConsoleCommandSender) {
			throw new CommandFailException("Console senders cannot use this command!");
		}
		Player player = sender.getPlayer();
		EntityHuman human = ((CraftHumanEntity) player).getHandle();
		float f = Float.parseFloat(args[0]);
		human.setAbsorptionHearts(f);
		send("You now have " + f + " absorption hearts.");
	}
}
