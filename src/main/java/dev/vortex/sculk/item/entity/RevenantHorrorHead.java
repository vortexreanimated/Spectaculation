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
package dev.vortex.sculk.item.entity;

import dev.vortex.sculk.item.GenericItemType;
import dev.vortex.sculk.item.MaterialFunction;
import dev.vortex.sculk.item.Rarity;
import dev.vortex.sculk.item.SkullStatistics;

public class RevenantHorrorHead implements SkullStatistics, MaterialFunction
{
    @Override
    public String getURL()
    {
        return "d8bee23b5c726ae8e3d021e8b4f7525619ab102a4e04be983b61414349aaac67";
    }

    @Override
    public String getDisplayName()
    {
        return "Revenant Horror Head";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.EXCLUSIVE;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ARMOR;
    }
}
