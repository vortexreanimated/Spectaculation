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
package dev.vortex.sculk.item.enchanted;

import dev.vortex.sculk.item.*;

public class EnchantedOakWood implements EnchantedMaterialStatistics, MaterialFunction
{
    @Override
    public String getDisplayName()
    {
        return "Enchanted Oak Wood";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.UNCOMMON;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ITEM;
    }

    @Override
    public boolean isEnchanted()
    {
        return true;
    }

    @Override
    public SMaterial getCraftingMaterial()
    {
        return SMaterial.OAK_WOOD;
    }

    @Override
    public MaterialQuantifiable getResult()
    {
        return new MaterialQuantifiable(SMaterial.ENCHANTED_OAK_WOOD);
    }
}
