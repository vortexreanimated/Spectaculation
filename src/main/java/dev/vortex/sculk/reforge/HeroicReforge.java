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
package dev.vortex.sculk.reforge;

import dev.vortex.sculk.item.GenericItemType;
import dev.vortex.sculk.item.RarityValue;

import java.util.Collections;
import java.util.List;

public class HeroicReforge implements Reforge
{
    @Override
    public String getName()
    {
        return "Heroic";
    }

    @Override
    public RarityValue<Double> getStrength()
    {
        return new RarityValue<>(15.0, 20.0, 25.0, 32.0, 40.0, 50.0);
    }

    @Override
    public RarityValue<Double> getIntelligence()
    {
        return new RarityValue<>(40.0, 50.0, 65.0, 80.0, 100.0, 125.0);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes()
    {
        return Collections.singletonList(GenericItemType.WEAPON);
    }
}
