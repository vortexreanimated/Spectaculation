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

import dev.vortex.sculk.item.GenericItemType;
import dev.vortex.sculk.item.MaterialFunction;
import dev.vortex.sculk.item.Rarity;
import dev.vortex.sculk.item.SpecificItemType;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public class CrackedPiggyBank implements AccessoryStatistics, MaterialFunction
{
    @Override
    public String getURL()
    {
        return "14a7aac08593a1a0bc6666fe0aeedfb195d413fc9cf87c73f4a8c04da6418857";
    }

    @Override
    public String getDisplayName()
    {
        return "Cracked Piggy Bank";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.UNCOMMON;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ACCESSORY;
    }

    @Override
    public SpecificItemType getSpecificType()
    {
        return SpecificItemType.ACCESSORY;
    }

    @Override
    public List<String> getListLore()
    {
        return Arrays.asList("Saves " + ChatColor.RED + "75%" + ChatColor.GRAY + " of your coins on death.",
                "Only when in player inventory.", ChatColor.RED + "Very fragile!",
                "", ChatColor.DARK_GRAY + "Triggers when losing 20k+ coins.");
    }
}