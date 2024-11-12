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
package dev.vortex.sculk.item.storage;

import dev.vortex.sculk.item.Rarity;
import dev.vortex.sculk.item.SkullStatistics;

public class JumboBackpack extends Storage implements SkullStatistics
{
    @Override
    public int getSlots()
    {
        return 54;
    }

    @Override
    public String getDisplayName()
    {
        return "Jumbo Backpack";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.LEGENDARY;
    }

    @Override
    public String getURL()
    {
        return "1f8405116c1daa7ce2f012591458d50246d0a467bcb95a5a2c033aefd6008b63";
    }
}
