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

public class BlankTalisman implements AccessoryStatistics, MaterialFunction {
	@Override
	public String getDisplayName() {
		return "Blank Talisman";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.EXCLUSIVE;
	}

	@Override
	public String getLore() {
		return "Apply reforges to this talisman to get effects.";
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
	public String getURL() {
		return "1ad6c81f899a785ecf26be1dc48eae2bcfe777a862390f5785e95bd83bd14d";
	}
}
