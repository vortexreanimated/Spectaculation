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

public class Dagger implements ToolStatistics, MaterialFunction
{
    @Override
    public int getBaseDamage()
    {
        return 35;
    }

    @Override
    public String getDisplayName()
    {
        return "Dagger";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.UNCOMMON;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType()
    {
        return SpecificItemType.SWORD;
    }

    @Override
    public String getLore()
    {
        return "Slice through your enemies in a fierce way!";
    }

    @Override
    public void load()
    {
        ShapedRecipe recipe = new ShapedRecipe(SMaterial.DAGGER).shape("ab", "cd");
        recipe.set('a', SMaterial.IRON_SWORD);
        recipe.set('b', SMaterial.DIAMOND_SWORD);
        recipe.set('c', SMaterial.GOLD_SWORD);
        recipe.set('d', SMaterial.STONE_SWORD);
    }
}