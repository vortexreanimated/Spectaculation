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
package dev.vortex.sculk.item.dragon.superior;

import dev.vortex.sculk.item.GenericItemType;
import dev.vortex.sculk.item.MaterialFunction;
import dev.vortex.sculk.item.Rarity;
import dev.vortex.sculk.item.SpecificItemType;
import dev.vortex.sculk.item.armor.LeatherArmorStatistics;

public class SuperiorDragonChestplate implements MaterialFunction, LeatherArmorStatistics
{
    @Override
    public double getBaseStrength()
    {
        return 10;
    }

    @Override
    public double getBaseCritChance()
    {
        return 0.02;
    }

    @Override
    public double getBaseCritDamage()
    {
        return 0.08;
    }

    @Override
    public double getBaseIntelligence()
    {
        return 25;
    }

    @Override
    public double getBaseSpeed()
    {
        return 0.03;
    }

    @Override
    public double getBaseHealth()
    {
        return 150;
    }

    @Override
    public double getBaseDefense()
    {
        return 190;
    }

    @Override
    public int getColor()
    {
        return 0xF2DF11;
    }

    @Override
    public String getDisplayName()
    {
        return "Superior Dragon Chestplate";
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