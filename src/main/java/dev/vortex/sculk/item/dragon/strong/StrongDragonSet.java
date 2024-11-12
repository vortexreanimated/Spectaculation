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

import dev.vortex.sculk.item.MaterialStatistics;
import dev.vortex.sculk.item.armor.ArmorSet;

public class StrongDragonSet implements ArmorSet {
	@Override
	public String getName() {
		return "Strong Blood";
	}

	@Override
	public String getDescription() {
		return "Improves the Aspect of the End: +75 Base Damage, +2 Teleport distance, +3 seconds of speed, Strength on ability";
	}

	@Override
	public Class<? extends MaterialStatistics> getHelmet() {
		return StrongDragonHelmet.class;
	}

	@Override
	public Class<? extends MaterialStatistics> getChestplate() {
		return StrongDragonChestplate.class;
	}

	@Override
	public Class<? extends MaterialStatistics> getLeggings() {
		return StrongDragonLeggings.class;
	}

	@Override
	public Class<? extends MaterialStatistics> getBoots() {
		return StrongDragonBoots.class;
	}
}
