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
package dev.vortex.sculk.item.dragon.old;

import dev.vortex.sculk.item.*;

public class OldDragonHelmet implements MaterialFunction, SkullStatistics, ToolStatistics
{
    @Override
    public double getBaseHealth()
    {
        return 110;
    }

    @Override
    public double getBaseDefense()
    {
        return 90;
    }

    @Override
    public String getURL()
    {
        return "59e9e5600410c1d0254474a81fecfb3885c1cf6f504190d856f0ec7c9f055c42";
    }

    @Override
    public String getDisplayName()
    {
        return "Old Dragon Helmet";
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
