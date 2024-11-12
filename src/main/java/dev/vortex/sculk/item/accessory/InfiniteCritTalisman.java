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

public class InfiniteCritTalisman implements AccessoryStatistics, MaterialFunction {
	@Override
	public String getURL() {
		return "ddafb23efc57f251878e5328d11cb0eef87b79c87b254a7ec72296f9363ef7c";
	}

	@Override
	public String getDisplayName() {
		return "Infinite Crit Talisman";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.EXCLUSIVE;
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
	public double getBaseCritChance() {
		return 1.0;
	}
}
