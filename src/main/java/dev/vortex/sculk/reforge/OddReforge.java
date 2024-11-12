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

public class OddReforge implements Reforge
{
    @Override
    public String getName()
    {
        return "Odd";
    }

    @Override
    public RarityValue<Double> getCritChance()
    {
        return new RarityValue<>(0.12, 0.15, 0.15, 0.2, 0.25, 0.25);
    }

    @Override
    public RarityValue<Double> getCritDamage()
    {
        return new RarityValue<>(0.1, 0.15, 0.15, 0.22, 0.3, 0.3);
    }

    @Override
    public RarityValue<Double> getIntelligence()
    {
        return new RarityValue<>(-5.0, -10.0, -18.0, -32.0, -50.0, -50.0);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes()
    {
        return Collections.singletonList(GenericItemType.WEAPON);
    }
}