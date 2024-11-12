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

import dev.vortex.sculk.user.User;
import lombok.Getter;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@Getter
public class CommandSource {
	private final CommandSender sender;
	private final Player player;
	private final User user;

	public CommandSource(CommandSender sender) {
		this.sender = sender;
		this.player = sender instanceof Player p ? p : null;
		this.user = player != null ? User.getUser(player.getUniqueId()) : null;
	}

	public void send(String message) {
		sender.sendMessage(message);
	}
}
