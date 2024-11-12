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

import java.util.List;

public interface MaterialStatistics {
	String getDisplayName();

	Rarity getRarity();

	default String getLore() {
		return null;
	}

	default List<String> getListLore() {
		return null;
	}

	GenericItemType getType();

	default SpecificItemType getSpecificType() {
		return SpecificItemType.NONE;
	}

	default boolean isStackable() {
		return true;
	}

	default boolean isEnchanted() {
		return false;
	}

	default boolean displayKills() {
		return false;
	}

	default boolean displayRarity() {
		return true;
	}

	default long getPrice() {
		return 1;
	}

	default long getValue() {
		return 1;
	}

	default ItemCategory getCategory() {
		return ItemCategory.TOOLS_MISC;
	}

	default void load() {
	}
}
