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

import dev.vortex.sculk.item.*;

public class UnstableDragonHelmet implements MaterialFunction, SkullStatistics, ToolStatistics
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
        return 70;
    }

    @Override
    public double getBaseDefense()
    {
        return 110;
    }

    @Override
    public double getBaseIntelligence()
    {
        return 25;
    }

    @Override
    public String getURL()
    {
        return "2922b5f8d554ca923f96832a5a4e9169bc2cdb360a2b06ebec09b6a6af4618e3";
    }

    @Override
    public String getDisplayName()
    {
        return "Unstable Dragon Helmet";
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
        return SpecificItemType.HELMET;
    }

    @Override
    public String getLore()
    {
        return null;
    }
}