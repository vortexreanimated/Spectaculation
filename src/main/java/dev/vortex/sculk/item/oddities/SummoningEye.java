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
import dev.vortex.sculk.item.Rarity;
import dev.vortex.sculk.item.SkullStatistics;
import org.bukkit.ChatColor;

public class SummoningEye implements SkullStatistics, MaterialFunction
{
    @Override
    public String getDisplayName()
    {
        return "Summoning Eye";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.EPIC;
    }

    @Override
    public String getLore()
    {
        return "Use this at the " + ChatColor.DARK_PURPLE + "Ender Altar"
                + ChatColor.GRAY + " in the " + ChatColor.DARK_PURPLE
                + "Dragon's Nest" + ChatColor.GRAY + " to summon Ender Dragons!";
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ITEM;
    }

    @Override
    public boolean isStackable()
    {
        return false;
    }

    @Override
    public String getURL()
    {
        return "12c318157f5c9daf8a7677a3669f9798940aff014a674ee0af2a574cbb21b8c3";
    }
}
