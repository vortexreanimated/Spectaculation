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
import dev.vortex.sculk.user.User;
import org.bukkit.Sound;
import org.bukkit.entity.*;

public class AspectOfTheDragons implements ToolStatistics, MaterialFunction, Ability {
	@Override
	public int getBaseDamage() {
		return 225;
	}

	@Override
	public double getBaseStrength() {
		return 100;
	}

	@Override
	public String getDisplayName() {
		return "Aspect of the Dragons";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.LEGENDARY;
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
		return "Dragon Rage";
	}

	@Override
	public String getAbilityDescription() {
		return "All Monsters in front of you take 5,000 Ability Damage. Hit monsters take large knockback.";
	}

	@Override
	public void onAbilityUse(Player player, SItem sItem) {
		player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 5f, 5f);
		for (Entity entity : player.getWorld().getNearbyEntities(
				player.getLocation().add(player.getLocation().getDirection().multiply(3.0)), 3.0, 3.0, 3.0)) {
			if (!(entity instanceof LivingEntity)) {
				continue;
			}
			if (entity instanceof Player || entity instanceof EnderDragon || entity instanceof EnderDragonPart) {
				continue;
			}
			User user = User.getUser(player.getUniqueId());
			entity.setVelocity(player.getLocation().toVector().subtract(entity.getLocation().toVector()).normalize()
					.multiply(-1.0).multiply(50.0));
			user.damageEntity((LivingEntity) entity, 12000.0);
		}
	}

	@Override
	public int getAbilityCooldownTicks() {
		return 100;
	}

	@Override
	public int getManaCost() {
		return 100;
	}
}
