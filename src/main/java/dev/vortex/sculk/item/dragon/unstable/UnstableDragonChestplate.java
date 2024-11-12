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
package dev.vortex.sculk.item.dragon.unstable;

import dev.vortex.sculk.item.GenericItemType;
import dev.vortex.sculk.item.MaterialFunction;
import dev.vortex.sculk.item.Rarity;
import dev.vortex.sculk.item.SpecificItemType;
import dev.vortex.sculk.item.armor.LeatherArmorStatistics;

public class UnstableDragonChestplate implements MaterialFunction, LeatherArmorStatistics
{
    @Override
    public double getBaseCritChance()
    {
        return 0.05;
    }

    @Override
    public double getBaseCritDamage()
    {
        return 0.15;
    }

    @Override
    public double getBaseHealth()
    {
        return 120;
    }

    @Override
    public double getBaseDefense()
    {
        return 160;
    }

    @Override
    public int getColor()
    {
        return 0xB212E3;
    }

    @Override
    public String getDisplayName()
    {
        return "Unstable Dragon Chestplate";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.LEGENDARY;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ARMOR;
    }

    @Override
    public SpecificItemType getSpecificType()
    {
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public String getLore()
    {
        return null;
    }
}