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
import java.util.Collections;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class RevenantSycophant extends BaseZombie {
	@Override
	public String getEntityName() {
		return "Revenant Sycophant";
	}

	@Override
	public double getEntityMaxHealth() {
		return 24000;
	}

	@Override
	public double getDamageDealt() {
		return 850.0;
	}

	@Override
	public double getXPDropped() {
		return 300.0;
	}

	@Override
	public SEntityEquipment getEntityEquipment() {
		return new SEntityEquipment(SUtil.enchant(new ItemStack(Material.DIAMOND_SWORD)), null,
				SUtil.enchant(new ItemStack(Material.DIAMOND_CHESTPLATE)),
				SUtil.enchant(new ItemStack(Material.CHAINMAIL_LEGGINGS)), new ItemStack(Material.IRON_BOOTS));
	}

	@Override
	public List<EntityDrop> drops() {
		return Collections.singletonList(new EntityDrop(SMaterial.REVENANT_FLESH, EntityDropType.GUARANTEED, 1.0));
	}
}
