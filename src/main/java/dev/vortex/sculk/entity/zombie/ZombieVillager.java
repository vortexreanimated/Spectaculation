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
package dev.vortex.sculk.entity.zombie;

import dev.vortex.sculk.entity.EntityDrop;
import dev.vortex.sculk.entity.EntityDropType;
import dev.vortex.sculk.entity.SEntityEquipment;
import dev.vortex.sculk.item.SMaterial;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class ZombieVillager extends BaseZombie
{
    @Override
    public String getEntityName()
    {
        return "Zombie Villager";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 120.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 24.0;
    }

    @Override
    public SEntityEquipment getEntityEquipment()
    {
        return new SEntityEquipment(null,
                new ItemStack(Material.LEATHER_HELMET),
                new ItemStack(Material.LEATHER_CHESTPLATE),
                new ItemStack(Material.LEATHER_LEGGINGS),
                new ItemStack(Material.LEATHER_BOOTS));
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Arrays.asList(new EntityDrop(SMaterial.ROTTEN_FLESH, EntityDropType.GUARANTEED, 1.0),
                new EntityDrop(SMaterial.POISONOUS_POTATO, EntityDropType.OCCASIONAL, 0.05));
    }

    @Override
    public double getMovementSpeed()
    {
        return 0.55;
    }

    public double getXPDropped()
    {
        return 7.0;
    }

    @Override
    public boolean isBaby()
    {
        return false;
    }

    @Override
    public boolean isVillager()
    {
        return true;
    }
}