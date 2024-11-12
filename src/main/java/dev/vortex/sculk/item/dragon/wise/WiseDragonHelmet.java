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
package dev.vortex.sculk.item.dragon.wise;

import dev.vortex.sculk.item.*;

public class WiseDragonHelmet implements MaterialFunction, SkullStatistics, ToolStatistics {
	@Override
	public double getBaseIntelligence() {
		return 125;
	}

	@Override
	public double getBaseHealth() {
		return 70;
	}

	@Override
	public double getBaseDefense() {
		return 110;
	}

	@Override
	public String getURL() {
		return "5a2984cf07c48da9724816a8ff0864bc68bce694ce8bd6db2112b6ba031070de";
	}

	@Override
	public String getDisplayName() {
		return "Wise Dragon Helmet";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.LEGENDARY;
	}

	@Override
	public GenericItemType getType() {
		return GenericItemType.ARMOR;
	}

	@Override
	public SpecificItemType getSpecificType() {
		return SpecificItemType.HELMET;
	}

	@Override
	public String getLore() {
		return null;
	}
}
