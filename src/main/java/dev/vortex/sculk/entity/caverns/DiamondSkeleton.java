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
package dev.vortex.sculk.entity.caverns;

import dev.vortex.sculk.entity.*;
import dev.vortex.sculk.item.SMaterial;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class DiamondSkeleton implements EntityStatistics, EntityFunction
{
    @Override
    public String getEntityName()
    {
        return "Skeleton";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 250.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 150.0;
    }

    @Override
    public double getXPDropped()
    {
        return 20.0;
    }

    @Override
    public SEntityEquipment getEntityEquipment()
    {
        return new SEntityEquipment(new ItemStack(Material.BOW),
                new ItemStack(Material.DIAMOND_HELMET),
                new ItemStack(Material.DIAMOND_CHESTPLATE),
                new ItemStack(Material.DIAMOND_LEGGINGS),
                new ItemStack(Material.DIAMOND_BOOTS));
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Arrays.asList(new EntityDrop(new ItemStack(Material.BONE, 4), EntityDropType.GUARANTEED, 1.0),
                new EntityDrop(SMaterial.MINER_HELMET, EntityDropType.RARE, 0.05),
                new EntityDrop(SMaterial.MINER_CHESTPLATE, EntityDropType.RARE, 0.05),
                new EntityDrop(SMaterial.MINER_LEGGINGS, EntityDropType.RARE, 0.05),
                new EntityDrop(SMaterial.MINER_BOOTS, EntityDropType.RARE, 0.05));
    }
}
