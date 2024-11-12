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
package dev.vortex.sculk.item.storage;

import dev.vortex.sculk.item.*;
import dev.vortex.sculk.util.SUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.minecraft.server.v1_8_R3.MojangsonParseException;
import net.minecraft.server.v1_8_R3.MojangsonParser;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

public abstract class Storage implements MaterialStatistics, MaterialFunction, ItemData {
	private static final Map<UUID, Inventory> OPENED_STORAGE_UNITS = new HashMap<>();

	public static Inventory getCurrentStorageOpened(Player player) {
		return OPENED_STORAGE_UNITS.get(player.getUniqueId());
	}

	public static void closeCurrentStorage(Player player) {
		OPENED_STORAGE_UNITS.remove(player.getUniqueId());
	}

	@Override
	public boolean isStackable() {
		return false;
	}

	@Override
	public void onInteraction(PlayerInteractEvent e) {
		SItem instance = SItem.find(e.getItem());
		Inventory inventory = Bukkit.createInventory(e.getPlayer(), getSlots(),
				instance.getType().getDisplayName(instance.getVariant()));
		for (int i = 0; i < getSlots(); i++) {
			try {
				NBTTagCompound compound = MojangsonParser.parse(new String(SUtil.gzipUncompress(
						instance.getData().getCompound("storage_data").getByteArray(String.valueOf(i)))));
				if (compound == null || compound.isEmpty()) {
					continue;
				}
				inventory.setItem(i, SItem.of(compound).getStack());
			} catch (MojangsonParseException ex) {
			}
		}
		OPENED_STORAGE_UNITS.put(e.getPlayer().getUniqueId(), inventory);
		e.getPlayer().openInventory(inventory);
	}

	@Override
	public NBTTagCompound getData() {
		return new NBTTagCompound();
	}

	@Override
	public GenericItemType getType() {
		return GenericItemType.ITEM;
	}

	public abstract int getSlots();
}
