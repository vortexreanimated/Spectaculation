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
package dev.vortex.sculk.entity.den;

import dev.vortex.sculk.entity.SEntity;
import dev.vortex.sculk.entity.SEntityType;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.entity.Entity;

public class BroodMother extends BaseSpider {
	@Override
	public String getEntityName() {
		return "Brood Mother";
	}

	@Override
	public double getEntityMaxHealth() {
		return 6000.0;
	}

	@Override
	public double getDamageDealt() {
		return 100.0;
	}

	@Override
	public void onDeath(SEntity sEntity, Entity killed, Entity damager) {
		int am = SUtil.random(4, 5);
		for (int i = 0; i < am; i++) {
			new SEntity(sEntity.getEntity(), SEntityType.CAVE_SPIDER);
		}
	}

	@Override
	public double getXPDropped() {
		return 17.0;
	}
}
