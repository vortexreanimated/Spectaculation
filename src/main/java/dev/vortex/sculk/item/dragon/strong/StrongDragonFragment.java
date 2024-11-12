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
package dev.vortex.sculk.item.dragon.strong;

import dev.vortex.sculk.item.GenericItemType;
import dev.vortex.sculk.item.MaterialFunction;
import dev.vortex.sculk.item.Rarity;
import dev.vortex.sculk.item.SkullStatistics;

public class StrongDragonFragment implements SkullStatistics, MaterialFunction {
	@Override
	public String getURL() {
		return "6ee32fbd4c7b03b869078aa1f493a390e6e13b461d613707eafb326dbcd2b4b5";
	}

	@Override
	public String getDisplayName() {
		return "Strong Dragon Fragment";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.EPIC;
	}

	@Override
	public GenericItemType getType() {
		return GenericItemType.ITEM;
	}
}
