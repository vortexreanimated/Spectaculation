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
package dev.vortex.sculk.item;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class MaterialQuantifiable {
	@Getter
	private SMaterial material;
	@Getter
	private int amount;

	public MaterialQuantifiable(SMaterial material, int amount) {
		this.material = material;
		this.amount = amount;
	}

	public MaterialQuantifiable(SMaterial material) {
		this(material, 1);
	}

	public MaterialQuantifiable setMaterial(SMaterial material) {
		this.material = material;
		return this;
	}

	public MaterialQuantifiable setAmount(int amount) {
		this.amount = amount;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof MaterialQuantifiable)) {
			return false;
		}
		MaterialQuantifiable material = (MaterialQuantifiable) o;
		return material.material == this.material && material.amount == this.amount;
	}

	public MaterialQuantifiable clone() {
		return new MaterialQuantifiable(material, amount);
	}

	@Override
	public String toString() {
		return "MQ{material=" + (material != null ? material.name() : "?") + ", amount=" + amount + "}";
	}

	public static MaterialQuantifiable of(ItemStack stack) {
		if (stack == null || stack.getType() == Material.AIR) {
			return new MaterialQuantifiable(SMaterial.AIR, (stack != null ? stack.getAmount() : 1));
		}
		SItem found = SItem.find(stack);
		if (found == null) {
			found = SItem.of(SMaterial.getSpecEquivalent(stack.getType(), stack.getDurability()));
		}
		return new MaterialQuantifiable(found.getType(), stack.getAmount());
	}

	public static MaterialQuantifiable[] of(ItemStack[] stacks) {
		MaterialQuantifiable[] materials = new MaterialQuantifiable[stacks.length];
		for (int i = 0; i < stacks.length; i++) {
			materials[i] = of(stacks[i]);
		}
		return materials;
	}
}
