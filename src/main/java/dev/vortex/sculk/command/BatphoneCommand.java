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

import dev.vortex.sculk.gui.GUI;
import dev.vortex.sculk.gui.GUIType;
import dev.vortex.sculk.item.oddities.MaddoxBatphone;
import dev.vortex.sculk.util.SUtil;
import java.util.*;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

@CommandParameters(description = "Hidden command for Maddox Batphone.")
public class BatphoneCommand extends SCommand {
	public static final UUID ACCESS_KEY = UUID.randomUUID();
	public static final List<String> KEYS = new ArrayList<>();

	@Override
	public void run(CommandSource sender, String[] args) {
		if (sender instanceof ConsoleCommandSender) {
			throw new CommandFailException("Console senders cannot use this command!");
		}
		if (!args[0].equals(ACCESS_KEY.toString())) {
			return;
		}
		if (!KEYS.contains(args[1])) {
			throw new CommandFailException(ChatColor.RED + "✆ It's too late now, the phone line is off! Call again!");
		}
		Player player = sender.getPlayer();
		MaddoxBatphone.CALL_COOLDOWN.add(player.getUniqueId());
		SUtil.delay(() -> MaddoxBatphone.CALL_COOLDOWN.remove(player.getUniqueId()), 20 * 20);
		GUI gui = GUIType.SLAYER.getGUI();
		gui.open(player);
	}
}
