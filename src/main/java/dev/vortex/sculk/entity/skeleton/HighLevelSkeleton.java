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
package dev.vortex.sculk.entity.skeleton;

import dev.vortex.sculk.Spectaculation;
import dev.vortex.sculk.entity.EntityFunction;
import dev.vortex.sculk.entity.EntityStatistics;
import dev.vortex.sculk.entity.SEntity;
import dev.vortex.sculk.entity.SEntityType;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

public class HighLevelSkeleton implements EntityStatistics, EntityFunction {
	@Override
	public String getEntityName() {
		return "Skeleton";
	}

	@Override
	public double getEntityMaxHealth() {
		return 200.0;
	}

	@Override
	public double getDamageDealt() {
		return 47.0;
	}

	@Override
	public double getXPDropped() {
		return 6.0;
	}

	@Override
	public void onDeath(SEntity sEntity, Entity killed, Entity damager) {
		Item item = sEntity.getEntity().getWorld().dropItem(sEntity.getEntity().getLocation(),
				new ItemStack(Material.BONE, 2));
		new BukkitRunnable() {
			@Override
			public void run() {
				if (item.isDead()) {
					return;
				}
				Location spawn = item.getLocation().clone().add(0, 1, 0);
				for (int i = 0; i < 5; i++) {
					item.getWorld().spigot().playEffect(spawn, Effect.PARTICLE_SMOKE, 0, 1, 0f, 0f, 0f, 0f, 1, 20);
				}
				new SEntity(spawn, SEntityType.HIGH_LEVEL_SKELETON);
				item.remove();
			}
		}.runTaskLater(Spectaculation.getPlugin(), 100);
	}
}
