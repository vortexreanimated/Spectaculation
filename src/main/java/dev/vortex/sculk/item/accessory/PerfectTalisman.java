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

public class PerfectTalisman implements AccessoryStatistics, MaterialFunction {
	@Override
	public String getURL() {
		return "13e8bbc8d174aecd6b46888fa63f9bade14b042e5e17063139d67f8e0163a38";
	}

	@Override
	public String getDisplayName() {
		return "Perfect Talisman";
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

	@Override
	public double getBaseIntelligence() {
		return 800;
	}

	@Override
	public double getBaseStrength() {
		return 500;
	}

	@Override
	public double getBaseHealth() {
		return 300;
	}

	@Override
	public double getBaseDefense() {
		return 100;
	}

	@Override
	public double getBaseCritDamage() {
		return 1.5;
	}

	@Override
	public double getBaseSpeed() {
		return 2.0;
	}

	@Override
	public double getBaseMagicFind() {
		return 100.0;
	}
}
