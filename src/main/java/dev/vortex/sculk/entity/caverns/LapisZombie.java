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
import dev.vortex.sculk.item.SItem;
import dev.vortex.sculk.item.SMaterial;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class LapisZombie implements EntityFunction, EntityStatistics
{
    @Override
    public String getEntityName()
    {
        return "Lapis Zombie";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 200.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 50.0;
    }

    @Override
    public SEntityEquipment getEntityEquipment()
    {
        return new SEntityEquipment(null, new ItemStack(Material.STAINED_GLASS, 1, (short) 11),
                SItem.of(SMaterial.LAPIS_ARMOR_CHESTPLATE).getStack(),
                SItem.of(SMaterial.LAPIS_ARMOR_LEGGINGS).getStack(),
                SItem.of(SMaterial.LAPIS_ARMOR_BOOTS).getStack());
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Arrays.asList(new EntityDrop(SMaterial.ROTTEN_FLESH, EntityDropType.GUARANTEED, 1.0),
                new EntityDrop(SMaterial.LAPIS_ARMOR_HELMET, EntityDropType.RARE, 0.05),
                new EntityDrop(SMaterial.LAPIS_ARMOR_CHESTPLATE, EntityDropType.RARE, 0.05),
                new EntityDrop(SMaterial.LAPIS_ARMOR_LEGGINGS, EntityDropType.RARE, 0.05),
                new EntityDrop(SMaterial.LAPIS_ARMOR_BOOTS, EntityDropType.RARE, 0.05));
    }

    @Override
    public double getXPDropped()
    {
        return 12.0;
    }
}
