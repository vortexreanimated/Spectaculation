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
import dev.vortex.sculk.user.PlayerUtils;
import java.util.Set;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class AspectOfTheEnd implements ToolStatistics, MaterialFunction, Ability {
	@Override
	public int getBaseDamage() {
		return 100;
	}

	@Override
	public double getBaseStrength() {
		return 100;
	}

	@Override
	public String getDisplayName() {
		return "Aspect of the End";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.RARE;
	}

	@Override
	public GenericItemType getType() {
		return GenericItemType.WEAPON;
	}

	@Override
	public SpecificItemType getSpecificType() {
		return SpecificItemType.SWORD;
	}

	@Override
	public String getLore() {
		return null;
	}

	@Override
	public String getAbilityName() {
		return "Instant Transmission";
	}

	@Override
	public String getAbilityDescription() {
		return "Teleports you 8 blocks ahead and gain +50% Speed for 3 seconds.";
	}

	@Override
	public void onAbilityUse(Player player, SItem sItem) {
		try {
			Location location = player.getTargetBlock((Set<Material>) null, 8).getLocation();
			location.setYaw(player.getLocation().getYaw());
			location.setPitch(player.getLocation().getPitch());
			player.teleport(location);
		} catch (IllegalStateException ex) {
		} // suppress bullshit errors thrown by Player#getTargetBlock
		player.playSound(player.getLocation(), Sound.ENDERMAN_TELEPORT, 3f, 1f);
		PlayerUtils.boostPlayer(PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId()), new PlayerBoostStatistics() {
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

			@Override
			public double getBaseSpeed() {
				return 0.5;
			}
		}, 60);
	}

	@Override
	public int getAbilityCooldownTicks() {
		return 0;
	}

	@Override
	public int getManaCost() {
		return 50;
	}

	@Override
	public void load() {
		ShapedRecipe recipe = new ShapedRecipe(SMaterial.ASPECT_OF_THE_END);
		recipe.shape("a", "b", "c");
		recipe.set('a', SMaterial.ENCHANTED_EYE_OF_ENDER, 16);
		recipe.set('b', SMaterial.ENCHANTED_EYE_OF_ENDER, 16);
		recipe.set('c', SMaterial.ENCHANTED_DIAMOND);
	}
}
