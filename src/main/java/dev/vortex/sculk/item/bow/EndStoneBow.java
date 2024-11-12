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
package dev.vortex.sculk.item.bow;

import dev.vortex.sculk.item.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class EndStoneBow implements ToolStatistics, MaterialFunction, Ability {
	@Override
	public String getAbilityName() {
		return "Extreme Focus";
	}

	@Override
	public String getAbilityDescription() {
		return "Consumes all your Mana, and your next hit will deal that much more Damage!";
	}

	@Override
	public void onAbilityUse(Player player, SItem sItem) {
		player.sendMessage(ChatColor.GRAY + "Incomplete ability.");
	}

	@Override
	public int getAbilityCooldownTicks() {
		return 0;
	}

	@Override
	public int getManaCost() {
		return -1;
	}

	// TODO: TEMPORARY
	@Override
	public AbilityActivation getAbilityActivation() {
		return AbilityActivation.NO_ACTIVATION;
	}

	@Override
	public String getDisplayName() {
		return "End Stone Bow";
	}

	@Override
	public int getBaseDamage() {
		return 140;
	}

	@Override
	public Rarity getRarity() {
		return Rarity.EPIC;
	}

	@Override
	public GenericItemType getType() {
		return GenericItemType.RANGED_WEAPON;
	}

	@Override
	public SpecificItemType getSpecificType() {
		return SpecificItemType.BOW;
	}
}
