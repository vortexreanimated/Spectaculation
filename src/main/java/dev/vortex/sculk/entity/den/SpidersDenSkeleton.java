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
package dev.vortex.sculk.entity.den;

import dev.vortex.sculk.entity.EntityDrop;
import dev.vortex.sculk.entity.EntityDropType;
import dev.vortex.sculk.entity.EntityFunction;
import dev.vortex.sculk.entity.EntityStatistics;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.List;

public class SpidersDenSkeleton implements EntityStatistics, EntityFunction
{
    @Override
    public String getEntityName()
    {
        return "Skeleton";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 100.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 33.0;
    }

    @Override
    public double getXPDropped()
    {
        return 6.0;
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Collections.singletonList(new EntityDrop(new ItemStack(Material.BONE, SUtil.random(5, 7)), EntityDropType.GUARANTEED, 1.0));
    }
}