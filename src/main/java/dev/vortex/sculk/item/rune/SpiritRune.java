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
package dev.vortex.sculk.item.rune;

import dev.vortex.sculk.item.GenericItemType;
import dev.vortex.sculk.item.Rarity;
import dev.vortex.sculk.item.Rune;
import dev.vortex.sculk.item.SpecificItemType;
import org.bukkit.ChatColor;

public class SpiritRune implements Rune {
	@Override
	public String getDisplayName() {
		return ChatColor.AQUA + "◆ Spirit Rune";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.RARE;
	}

	@Override
	public GenericItemType getType() {
		return GenericItemType.ITEM;
	}

	@Override
	public SpecificItemType getSpecificType() {
		return SpecificItemType.COSMETIC;
	}

	@Override
	public String getURL() {
		return "c738b8af8d7ce1a26dc6d40180b3589403e11ef36a66d7c4590037732829542e";
	}
}
