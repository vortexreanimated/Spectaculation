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
package dev.vortex.sculk.item;

import lombok.Getter;

public enum SpecificItemType {
	SWORD(false), HELMET(false), CHESTPLATE(false), LEGGINGS(false), BOOTS(false), BOW(false), COSMETIC(
			false), ACCESSORY(false), AXE(false), PICKAXE(
					false), SHOVEL(false), HOE(false), SHEARS(false), DUNGEON_ITEM, NONE, ROD(false), ARROW_POISON;

	@Getter
	private final boolean stackable;

	SpecificItemType(boolean stackable) {
		this.stackable = stackable;
	}

	SpecificItemType() {
		this(true);
	}

	public String getName() {
		return name().replaceAll("_", " ");
	}
}
