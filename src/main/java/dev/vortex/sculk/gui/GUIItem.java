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
package dev.vortex.sculk.gui;

import dev.vortex.sculk.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public interface GUIItem {
	int getSlot();

	default ItemStack getItem() {
		return new ItemStack(Material.AIR);
	}

	default boolean canPickup() {
		return false;
	}

	static GUIItem createLoadingItem(Material type, String name, int slot) {
		return new GUIItem() {
			@Override
			public int getSlot() {
				return slot;
			}

			@Override
			public ItemStack getItem() {
				return SUtil.getSingleLoreStack(name, type, (short) 0, 1, ChatColor.DARK_GRAY + "Loading...");
			}
		};
	}
}
