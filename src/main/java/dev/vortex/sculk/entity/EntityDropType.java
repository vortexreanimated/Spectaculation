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
package dev.vortex.sculk.entity;

import lombok.Getter;
import org.bukkit.ChatColor;

public enum EntityDropType {
	GUARANTEED(ChatColor.GREEN), COMMON(ChatColor.GREEN), OCCASIONAL(ChatColor.BLUE), RARE(ChatColor.GOLD), VERY_RARE(
			ChatColor.AQUA), EXTRAORDINARILY_RARE(ChatColor.DARK_PURPLE), CRAZY_RARE(ChatColor.LIGHT_PURPLE);

	@Getter
	private final ChatColor color;

	EntityDropType(ChatColor color) {
		this.color = color;
	}

	public String getDisplay() {
		return "" + color + ChatColor.BOLD + name().replaceAll("_", " ");
	}
}
