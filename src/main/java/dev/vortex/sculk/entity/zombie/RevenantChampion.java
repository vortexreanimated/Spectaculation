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
import dev.vortex.sculk.item.SItem;
import dev.vortex.sculk.item.SMaterial;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Collections;
import java.util.List;

public class RevenantChampion extends BaseZombie
{
    @Override
    public String getEntityName()
    {
        return "Revenant Champion";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 90000;
    }

    @Override
    public double getDamageDealt()
    {
        return 2200.0;
    }

    @Override
    public double getXPDropped()
    {
        return 600.0;
    }

    @Override
    public SEntityEquipment getEntityEquipment()
    {
        return new SEntityEquipment(SUtil.enchant(new ItemStack(Material.DIAMOND_SWORD)), null,
                SUtil.enchant(new ItemStack(Material.DIAMOND_CHESTPLATE)), SUtil.enchant(new ItemStack(Material.CHAINMAIL_LEGGINGS)),
                        new ItemStack(Material.IRON_BOOTS));
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Collections.singletonList(new EntityDrop(SUtil.setStackAmount(SItem.of(SMaterial.REVENANT_FLESH).getStack(), 2), EntityDropType.GUARANTEED, 1.0));
    }
}
