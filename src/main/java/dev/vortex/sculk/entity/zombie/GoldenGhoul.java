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
package dev.vortex.sculk.entity.zombie;

import dev.vortex.sculk.entity.EntityDrop;
import dev.vortex.sculk.entity.EntityDropType;
import dev.vortex.sculk.entity.SEntityEquipment;
import dev.vortex.sculk.item.SMaterial;
import dev.vortex.sculk.util.SUtil;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GoldenGhoul extends BaseZombie {
	@Override
	public String getEntityName() {
		return "Golden Ghoul";
	}

	@Override
	public double getEntityMaxHealth() {
		return 45000.0;
	}

	@Override
	public double getDamageDealt() {
		return 800.0;
	}

	@Override
	public SEntityEquipment getEntityEquipment() {
		return new SEntityEquipment(new ItemStack(Material.GOLD_SWORD), null, new ItemStack(Material.GOLD_CHESTPLATE),
				new ItemStack(Material.GOLD_LEGGINGS), new ItemStack(Material.GOLD_BOOTS));
	}

	@Override
	public List<EntityDrop> drops() {
		return Arrays.asList(
				new EntityDrop(new ItemStack(Material.ROTTEN_FLESH, SUtil.random(2, 4)), EntityDropType.GUARANTEED,
						1.0),
				new EntityDrop(new ItemStack(Material.GOLD_INGOT, SUtil.random(1, 11)), EntityDropType.GUARANTEED, 1.0),
				new EntityDrop(SMaterial.GOLDEN_POWDER, EntityDropType.CRAZY_RARE, 0.006));
	}

	@Override
	public double getXPDropped() {
		return 50.0;
	}

	@Override
	public boolean isBaby() {
		return false;
	}

	@Override
	public boolean isVillager() {
		return false;
	}
}
