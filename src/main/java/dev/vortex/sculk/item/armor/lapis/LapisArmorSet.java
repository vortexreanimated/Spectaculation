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
package dev.vortex.sculk.item.armor.lapis;

import dev.vortex.sculk.item.GenericItemType;
import dev.vortex.sculk.item.MaterialStatistics;
import dev.vortex.sculk.item.PlayerBoostStatistics;
import dev.vortex.sculk.item.Rarity;
import dev.vortex.sculk.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class LapisArmorSet implements ArmorSet {
	@Override
	public String getName() {
		return "Health";
	}

	@Override
	public String getDescription() {
		return "Increases the wearer's maximum Health by 60.";
	}

	@Override
	public Class<? extends MaterialStatistics> getHelmet() {
		return LapisArmorHelmet.class;
	}

	@Override
	public Class<? extends MaterialStatistics> getChestplate() {
		return LapisArmorChestplate.class;
	}

	@Override
	public Class<? extends MaterialStatistics> getLeggings() {
		return LapisArmorLeggings.class;
	}

	@Override
	public Class<? extends MaterialStatistics> getBoots() {
		return LapisArmorBoots.class;
	}

	@Override
	public PlayerBoostStatistics whileHasFullSet(Player player) {
		return new PlayerBoostStatistics() {
			@Override
			public String getDisplayName() {
				return null;
			}

			@Override
			public Rarity getRarity() {
				return null;
			}

			@Override
			public GenericItemType getType() {
				return null;
			}

			@Override
			public double getBaseHealth() {
				return 60;
			}
		};
	}
}
