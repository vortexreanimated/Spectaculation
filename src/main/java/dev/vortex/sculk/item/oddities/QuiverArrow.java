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
package dev.vortex.sculk.item.oddities;

import dev.vortex.sculk.item.GenericItemType;
import dev.vortex.sculk.item.MaterialFunction;
import dev.vortex.sculk.item.MaterialStatistics;
import dev.vortex.sculk.item.Rarity;
import org.bukkit.ChatColor;

public class QuiverArrow implements MaterialStatistics, MaterialFunction
{
    @Override
    public String getDisplayName()
    {
        return ChatColor.DARK_GRAY + "Quiver Arrow";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ITEM;
    }

    @Override
    public String getLore()
    {
        return "This item is in your inventory because you are holding your bow currently. Switch your held item to see the item that was here before.";
    }

    @Override
    public boolean displayRarity()
    {
        return false;
    }
}