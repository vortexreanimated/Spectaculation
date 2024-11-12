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
package dev.vortex.sculk.entity.nether;

import dev.vortex.sculk.entity.EntityDrop;
import dev.vortex.sculk.entity.EntityDropType;
import dev.vortex.sculk.entity.EntityFunction;
import dev.vortex.sculk.entity.SkeletonStatistics;
import dev.vortex.sculk.item.SMaterial;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class WitherSkeleton implements SkeletonStatistics, EntityFunction
{
    @Override
    public String getEntityName()
    {
        return "Wither Skeleton";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 250.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 152.0;
    }

    @Override
    public boolean isWither()
    {
        return true;
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Arrays.asList(new EntityDrop(new ItemStack(Material.BONE, 3), EntityDropType.GUARANTEED, 1.0),
                new EntityDrop(SMaterial.COAL, EntityDropType.COMMON, 0.5),
                new EntityDrop(SMaterial.ENCHANTED_COAL, EntityDropType.OCCASIONAL, 0.025),
                new EntityDrop(SMaterial.ENCHANTED_CHARCOAL, EntityDropType.RARE, 0.01));
    }

    @Override
    public double getXPDropped()
    {
        return 13.0;
    }
}