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
package dev.vortex.sculk.item.dragon.unstable;

import dev.vortex.sculk.item.MaterialStatistics;
import dev.vortex.sculk.item.armor.ArmorSet;

public class UnstableDragonSet implements ArmorSet {
	@Override
	public String getName() {
		return "Unstable Blood";
	}

	@Override
	public String getDescription() {
		return "Every 10 seconds, strike nearby mobs within a 7 block radius dealing 3,000 Damage!";
	}

	@Override
	public Class<? extends MaterialStatistics> getHelmet() {
		return UnstableDragonHelmet.class;
	}

	@Override
	public Class<? extends MaterialStatistics> getChestplate() {
		return UnstableDragonChestplate.class;
	}

	@Override
	public Class<? extends MaterialStatistics> getLeggings() {
		return UnstableDragonLeggings.class;
	}

	@Override
	public Class<? extends MaterialStatistics> getBoots() {
		return UnstableDragonBoots.class;
	}
}
