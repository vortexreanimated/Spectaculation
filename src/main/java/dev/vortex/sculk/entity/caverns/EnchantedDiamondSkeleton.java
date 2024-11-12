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

import dev.vortex.sculk.enchantment.Enchantment;
import dev.vortex.sculk.enchantment.EnchantmentType;
import dev.vortex.sculk.entity.*;
import dev.vortex.sculk.item.SItem;
import dev.vortex.sculk.item.SMaterial;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class EnchantedDiamondSkeleton implements EntityStatistics, EntityFunction
{
    @Override
    public String getEntityName()
    {
        return "Skeleton";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 300.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 190.0;
    }

    @Override
    public SEntityEquipment getEntityEquipment()
    {
        return new SEntityEquipment(SUtil.enchant(new ItemStack(Material.BOW)),
                SUtil.enchant(new ItemStack(Material.DIAMOND_BLOCK)),
                SUtil.enchant(new ItemStack(Material.DIAMOND_CHESTPLATE)),
                SUtil.enchant(new ItemStack(Material.DIAMOND_LEGGINGS)),
                SUtil.enchant(new ItemStack(Material.DIAMOND_BOOTS)));
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Arrays.asList(new EntityDrop(new ItemStack(Material.BONE, 4), EntityDropType.GUARANTEED, 1.0),
                new EntityDrop(SUtil.enchant(SItem.of(SMaterial.MINER_HELMET),
                        new Enchantment(EnchantmentType.PROTECTION, 5)).getStack(), EntityDropType.RARE, 0.05),
                new EntityDrop(SUtil.enchant(SItem.of(SMaterial.MINER_CHESTPLATE),
                        new Enchantment(EnchantmentType.PROTECTION, 5)).getStack(), EntityDropType.RARE, 0.05),
                new EntityDrop(SUtil.enchant(SItem.of(SMaterial.MINER_LEGGINGS),
                        new Enchantment(EnchantmentType.PROTECTION, 5)).getStack(), EntityDropType.RARE, 0.05),
                new EntityDrop(SUtil.enchant(SItem.of(SMaterial.MINER_BOOTS),
                        new Enchantment(EnchantmentType.PROTECTION, 5)).getStack(), EntityDropType.RARE, 0.05)
        );
    }

    @Override
    public double getXPDropped()
    {
        return 24.0;
    }
}