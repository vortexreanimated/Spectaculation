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
package dev.vortex.sculk.item.dragon.old;

import dev.vortex.sculk.item.MaterialStatistics;
import dev.vortex.sculk.item.PlayerBoostStatistics;
import dev.vortex.sculk.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class OldDragonSet implements ArmorSet {
	@Override
	public String getName() {
		return "Old Blood";
	}

	@Override
	public String getDescription() {
		return "Increases the strength of Growth, Protection, Feather Falling, Sugar Rush, and True Protection enchantments while worn.";
	}

	@Override
	public Class<? extends MaterialStatistics> getHelmet() {
		return OldDragonHelmet.class;
	}

	@Override
	public Class<? extends MaterialStatistics> getChestplate() {
		return OldDragonChestplate.class;
	}

	@Override
	public Class<? extends MaterialStatistics> getLeggings() {
		return OldDragonLeggings.class;
	}

	@Override
	public Class<? extends MaterialStatistics> getBoots() {
		return OldDragonBoots.class;
	}

	@Override
	public PlayerBoostStatistics whileHasFullSet(Player player) {
		return null; // TODO
	}
}
