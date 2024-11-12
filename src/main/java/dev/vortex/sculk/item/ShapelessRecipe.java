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

import dev.vortex.sculk.util.SUtil;
import java.util.*;
import lombok.Getter;
import org.bukkit.inventory.ItemStack;

public class ShapelessRecipe extends Recipe<ShapelessRecipe> {
	private static final List<ShapelessRecipe> CACHED_RECIPES = new ArrayList<>();

	@Getter
	private final List<MaterialQuantifiable> ingredientList;

	public ShapelessRecipe(SItem result, boolean usesExchangeables) {
		super(result, usesExchangeables);
		this.ingredientList = new ArrayList<>();
		CACHED_RECIPES.add(this);
	}

	public ShapelessRecipe(SItem result) {
		this(result, false);
	}

	public ShapelessRecipe(SMaterial material, int amount) {
		this(SUtil.setSItemAmount(SItem.of(material), amount));
	}

	public ShapelessRecipe(SMaterial material) {
		this(SItem.of(material));
	}

	@Override
	public ShapelessRecipe setResult(SItem result) {
		this.result = result;
		return this;
	}

	public ShapelessRecipe add(MaterialQuantifiable material) {
		ingredientList.add(material.clone());
		return this;
	}

	public ShapelessRecipe add(SMaterial material, int amount) {
		return add(new MaterialQuantifiable(material, amount));
	}

	@Override
	public List<MaterialQuantifiable> getIngredients() {
		return ingredientList;
	}

	@Override
	public String toString() {
		return "ShapelessRecipe{" + ingredientList.toString() + "}";
	}

	protected static ShapelessRecipe parseShapelessRecipe(ItemStack[] stacks) {
		if (stacks.length != 9) {
			throw new UnsupportedOperationException("Recipe parsing requires a 9 element array!");
		}
		MaterialQuantifiable[] materials = SUtil
				.unnest(airless(new MaterialQuantifiable[][]{MaterialQuantifiable.of(Arrays.copyOfRange(stacks, 0, 3)),
						MaterialQuantifiable.of(Arrays.copyOfRange(stacks, 3, 6)),
						MaterialQuantifiable.of(Arrays.copyOfRange(stacks, 6, 9))}), MaterialQuantifiable.class);
		for (ShapelessRecipe recipe : CACHED_RECIPES) {
			List<MaterialQuantifiable> ingredients = recipe.getIngredientList();
			if (materials.length != ingredients.size()) {
				continue;
			}
			boolean found = true;
			MaterialQuantifiable[] copy = Arrays.copyOf(materials, materials.length);
			for (MaterialQuantifiable ingredient : ingredients) {
				if (!contains(recipe.useExchangeables, copy, ingredient)) {
					found = false;
					break;
				}
			}
			if (!found) {
				continue;
			}
			return recipe;
		}
		return null;
	}

	private static boolean contains(boolean usesExchangeables, MaterialQuantifiable[] grid, MaterialQuantifiable test) {
		List<SMaterial> exchangeables = getExchangeablesOf(test.getMaterial());
		for (int i = 0; i < grid.length; i++) {
			MaterialQuantifiable material = grid[i];
			if (material == null) {
				continue;
			}
			if (usesExchangeables && exchangeables != null && exchangeables.contains(material.getMaterial())
					&& material.getAmount() >= test.getAmount()) {
				grid[i] = null;
				return true;
			}
			if (material.getMaterial() == test.getMaterial() && material.getAmount() >= test.getAmount()) {
				grid[i] = null;
				return true;
			}
		}
		return false;
	}
}
