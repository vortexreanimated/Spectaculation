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
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public interface GUIClickableItem extends GUIItem {
	void run(InventoryClickEvent e);

	static GUIClickableItem getCloseItem(int slot) {
		return new GUIClickableItem() {
			@Override
			public void run(InventoryClickEvent e) {
				e.getWhoClicked().closeInventory();
			}

			@Override
			public int getSlot() {
				return slot;
			}

			@Override
			public ItemStack getItem() {
				return SUtil.createNamedItemStack(Material.BARRIER, ChatColor.RED + "Close");
			}
		};
	}

	static GUIClickableItem createGUIOpenerItem(GUI gui, Player player, String name, int slot, Material type,
			short data, String... lore) {
		return new GUIClickableItem() {
			@Override
			public ItemStack getItem() {
				return SUtil.getStack(name, type, data, 1, lore);
			}

			@Override
			public void run(InventoryClickEvent e) {
				if (gui == null) {
					return;
				}
				gui.open(player);
			}

			@Override
			public int getSlot() {
				return slot;
			}
		};
	}

	static GUIClickableItem createGUIOpenerItem(GUIType guiType, Player player, String name, int slot, Material type,
			short data, String... lore) {
		return createGUIOpenerItem(guiType.getGUI(), player, name, slot, type, data, lore);
	}

	static GUIClickableItem createGUIOpenerItem(GUIType guiType, Player player, String name, int slot, Material type,
			String... lore) {
		return createGUIOpenerItem(guiType, player, name, slot, type, (short) 0, lore);
	}
}
