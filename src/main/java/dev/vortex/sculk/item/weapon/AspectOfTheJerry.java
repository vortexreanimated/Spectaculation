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
package dev.vortex.sculk.item.weapon;

import dev.vortex.sculk.item.*;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class AspectOfTheJerry implements ToolStatistics, MaterialFunction, Ability {
	@Override
	public String getAbilityName() {
		return "Parley";
	}

	@Override
	public String getAbilityDescription() {
		return "Release your inner Jerry.";
	}

	@Override
	public int getAbilityCooldownTicks() {
		return 100;
	}

	@Override
	public void onAbilityUse(Player player, SItem sItem) {
		player.playSound(player.getLocation(), Sound.VILLAGER_IDLE, 1f, 1f);
	}

	@Override
	public int getManaCost() {
		return 50;
	}

	@Override
	public String getDisplayName() {
		return "Aspect of the Jerry";
	}

	@Override
	public int getBaseDamage() {
		return 1;
	}

	@Override
	public Rarity getRarity() {
		return Rarity.COMMON;
	}

	@Override
	public GenericItemType getType() {
		return GenericItemType.WEAPON;
	}

	@Override
	public SpecificItemType getSpecificType() {
		return SpecificItemType.SWORD;
	}
}
