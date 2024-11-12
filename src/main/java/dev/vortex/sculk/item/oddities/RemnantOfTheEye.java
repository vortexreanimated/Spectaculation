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

public class RemnantOfTheEye implements SkullStatistics, MaterialFunction
{
    @Override
    public String getDisplayName()
    {
        return "Remnant of the Eye";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.EPIC;
    }

    @Override
    public String getLore()
    {
        return "Keeps you alive when you are on death's door, granting a" +
                "short period of invincibility. Consumed on use. " +
                ChatColor.RED + "NOTE: ONLY WORKS ON THE END ISLAND";
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
        return "7d389c55ecf7db572d6961ce3d57b572e761397b67a2d6d94c72fc91dddd74";
    }
}