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
package dev.vortex.sculk.item.dragon.young;

import dev.vortex.sculk.item.GenericItemType;
import dev.vortex.sculk.item.MaterialStatistics;
import dev.vortex.sculk.item.PlayerBoostStatistics;
import dev.vortex.sculk.item.Rarity;
import dev.vortex.sculk.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class YoungDragonSet implements ArmorSet {
	@Override
	public String getName() {
		return "Young Blood";
	}

	@Override
	public String getDescription() {
		return "Gain +70 Speed when you are above 50% Health.";
	}

	@Override
	public Class<? extends MaterialStatistics> getHelmet() {
		return YoungDragonHelmet.class;
	}

	@Override
	public Class<? extends MaterialStatistics> getChestplate() {
		return YoungDragonChestplate.class;
	}

	@Override
	public Class<? extends MaterialStatistics> getLeggings() {
		return YoungDragonLeggings.class;
	}

	@Override
	public Class<? extends MaterialStatistics> getBoots() {
		return YoungDragonBoots.class;
	}

	@Override
	public PlayerBoostStatistics whileHasFullSet(Player player) {
		return new PlayerBoostStatistics() {
			@Override
			public double getBaseSpeed() {
				if (player.getHealth() > player.getMaxHealth() / 2.0) {
					return 0.7;
				}
				return 0.0;
			}

			@Override
			public String getDisplayName() {
				return null;
			}

			@Override
			public Rarity getRarity() {
				return null;
			}

			@Override
			public String getLore() {
				return null;
			}

			@Override
			public GenericItemType getType() {
				return null;
			}
		};
	}
}
