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
package dev.vortex.sculk.item.accessory;

import dev.vortex.sculk.item.GenericItemType;
import dev.vortex.sculk.item.MaterialFunction;
import dev.vortex.sculk.item.Rarity;
import dev.vortex.sculk.item.SpecificItemType;
import java.util.Arrays;
import java.util.List;
import org.bukkit.ChatColor;

public class PiggyBank implements AccessoryStatistics, MaterialFunction {
	@Override
	public String getURL() {
		return "198df42f477f213ff5e9d7fa5a4cc4a69f20d9cef2b90c4ae4f29bd17287b5";
	}

	@Override
	public String getDisplayName() {
		return "Piggy Bank";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.UNCOMMON;
	}

	@Override
	public GenericItemType getType() {
		return GenericItemType.ACCESSORY;
	}

	@Override
	public SpecificItemType getSpecificType() {
		return SpecificItemType.ACCESSORY;
	}

	@Override
	public List<String> getListLore() {
		return Arrays.asList("Saves your coins from death.", "Only when in player inventory.",
				ChatColor.RED + "Fragile!", "", ChatColor.DARK_GRAY + "Triggers when losing 20k+ coins.");
	}
}
