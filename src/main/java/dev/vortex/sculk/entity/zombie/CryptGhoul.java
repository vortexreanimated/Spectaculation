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
import dev.vortex.sculk.util.SUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.List;

public class CryptGhoul extends BaseZombie
{
    @Override
    public String getEntityName()
    {
        return "Crypt Ghoul";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 2000.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 350.0;
    }

    @Override
    public SEntityEquipment getEntityEquipment()
    {
        return new SEntityEquipment(new ItemStack(Material.IRON_SWORD),
                null,
                new ItemStack(Material.CHAINMAIL_CHESTPLATE),
                new ItemStack(Material.CHAINMAIL_LEGGINGS),
                new ItemStack(Material.CHAINMAIL_BOOTS));
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Collections.singletonList(new EntityDrop(new ItemStack(Material.ROTTEN_FLESH, SUtil.random(1, 3)), EntityDropType.GUARANTEED, 1.0));
    }

    @Override
    public double getMovementSpeed()
    {
        return 0.35;
    }

    public double getXPDropped()
    {
        return 30.0;
    }

    @Override
    public boolean isBaby()
    {
        return false;
    }

    @Override
    public boolean isVillager()
    {
        return false;
    }
}