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

import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

@CommandParameters(description = "Spec test command.", aliases = "test")
public class SpecTestCommand extends SCommand {
	@Override
	public void run(CommandSource sender, String[] args) {
		if (args.length != 0) {
			throw new CommandArgumentException();
		}
		if (sender instanceof ConsoleCommandSender) {
			throw new CommandFailException("Console senders cannot use this command!");
		}
		Player player = sender.getPlayer();
		player.setVelocity(new Vector(-670.5, 58.0, -275.5).multiply(-1.0).multiply(3.0).setY(100.0));
	}
}
