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

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

@CommandParameters(description = "Play a Bukkit enum sound.", usage = "/playenumsound <sound>")
public class PlayEnumEffectCommand extends SCommand {
	@Override
	public void run(CommandSource sender, String[] args) {
		if (args.length < 1 || args.length > 2) {
			throw new CommandArgumentException();
		}
		if (sender instanceof ConsoleCommandSender) {
			throw new CommandFailException("Console senders cannot use this command!");
		}
		Player player = sender.getPlayer();
		Effect effect = Effect.valueOf(args[0].toUpperCase());
		int count = 1;
		if (args.length == 2) {
			count = Integer.parseInt(args[1]);
		}
		for (int i = 0; i < count; i++) {
			player.getWorld().playEffect(player.getLocation(), effect, effect.getData());
		}
		player.sendMessage(ChatColor.GRAY + "Played " + effect.name() + ".");
	}
}
