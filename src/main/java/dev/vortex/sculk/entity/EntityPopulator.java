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
package dev.vortex.sculk.entity;

import dev.vortex.sculk.Spectaculation;
import dev.vortex.sculk.region.Region;
import dev.vortex.sculk.region.RegionType;
import dev.vortex.sculk.util.SUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class EntityPopulator {
	private static final List<EntityPopulator> POPULATORS = new ArrayList<>();

	public static List<EntityPopulator> getPopulators() {
		return POPULATORS;
	}

	private final int amount;
	private final int max;
	private final long delay;
	private final SEntityType type;
	private final Predicate<World> condition;
	@Getter
	private final RegionType regionType;
	private BukkitTask task;
	private final List<SEntity> spawned;

	public EntityPopulator(int amount, int max, long delay, SEntityType type, RegionType regionType,
			Predicate<World> condition) {
		this.amount = amount;
		this.max = max;
		this.delay = delay;
		this.type = type;
		this.regionType = regionType;
		this.spawned = new ArrayList<>();
		this.condition = condition;
		POPULATORS.add(this);
	}

	public EntityPopulator(int amount, int max, long delay, SEntityType type, RegionType regionType) {
		this(amount, max, delay, type, regionType, null);
	}

	public void start() {
		this.task = new BukkitRunnable() {
			@Override
			public void run() {
				spawned.removeIf(sEntity -> sEntity.getEntity().isDead());
				List<Region> regions = Region.getRegionsOfType(regionType);
				if (regions.isEmpty()) {
					return;
				}
				if (Region.getPlayersWithinRegionType(regionType).isEmpty()) {
					for (SEntity s : spawned)
						s.remove();
					spawned.clear();
					return;
				}
				if (condition != null && !condition.test(SUtil.getRandom(regions).getFirstLocation().getWorld())) {
					return;
				}
				if (spawned.size() >= max) {
					return;
				}
				for (int i = 0; i < amount; i++) {
					Location available;
					int attempts = 0;
					do {
						available = SUtil.getRandom(regions).getRandomAvailableLocation();
						attempts++;
					} while (available == null && attempts <= 150);
					if (available != null) {
						spawned.add(new SEntity(available.clone().add(0.5, 0.0, 0.5), type));
					}
				}
			}
		}.runTaskTimer(Spectaculation.getPlugin(), 0, delay);
	}

	public void stop() {
		if (this.task == null) {
			return;
		}
		this.task.cancel();
	}

	public static void stopAll() {
		for (EntityPopulator populator : POPULATORS)
			populator.stop();
	}
}
