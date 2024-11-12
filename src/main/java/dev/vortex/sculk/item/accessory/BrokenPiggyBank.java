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

public class BrokenPiggyBank implements AccessoryStatistics, MaterialFunction
{
    @Override
    public String getURL()
    {
        return "b590207aeea2d8fc80194f2a109f5b1999c91ebd377dff01b9e7ebe091a3a419";
    }

    @Override
    public String getDisplayName()
    {
        return "Broken Piggy Bank";
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
    public String getLore()
    {
        return "It broke!";
    }
}
