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
package dev.vortex.sculk.item.accessory;

import com.google.common.util.concurrent.AtomicDouble;
import dev.vortex.sculk.item.GenericItemType;
import dev.vortex.sculk.item.Rarity;
import dev.vortex.sculk.item.SItem;
import dev.vortex.sculk.item.SpecificItemType;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class TarantulaTalisman implements AccessoryStatistics, AccessoryFunction {
	private static final Map<UUID, Integer> HITS = new HashMap<>();

	@Override
	public String getDisplayName() {
		return "Tarantula Talisman";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.EPIC;
	}

	@Override
	public GenericItemType getType() {
		return GenericItemType.ACCESSORY;
	}

	@Override
	public SpecificItemType getSpecificType() {
		return SpecificItemType.ACCESSORY;
	}

	@Override
	public String getURL() {
		return "442cf8ce487b78fa203d56cf01491434b4c33e5d236802c6d69146a51435b03d";
	}

	@Override
	public void onDamageInInventory(SItem weapon, Player damager, Entity damaged, SItem accessory,
			AtomicDouble damage) {
		HITS.put(damager.getUniqueId(), HITS.getOrDefault(damager.getUniqueId(), 0) + 1);
		if (HITS.get(damager.getUniqueId()) >= 10) {
			damage.addAndGet(damage.get() * 0.1);
			HITS.remove(damager.getUniqueId());
		}
	}
}
