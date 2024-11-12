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
package dev.vortex.sculk.entity.end;

import dev.vortex.sculk.entity.*;
import dev.vortex.sculk.item.SItem;
import dev.vortex.sculk.item.SMaterial;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class Watcher implements EntityFunction, EntityStatistics
{
    @Override
    public String getEntityName()
    {
        return "Watcher";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 9500.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 475.0;
    }

    @Override
    public double getXPDropped()
    {
        return 40.0;
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Arrays.asList(
                new EntityDrop(new ItemStack(Material.ENDER_PEARL, SUtil.random(2, 4)), EntityDropType.GUARANTEED, 1.0),
                new EntityDrop(new ItemStack(Material.ARROW, SUtil.random(2, 4)), EntityDropType.GUARANTEED, 1.0),
                new EntityDrop(SMaterial.ENCHANTED_BONE, EntityDropType.RARE, 0.05),
                new EntityDrop(SMaterial.END_STONE_BOW, EntityDropType.EXTRAORDINARILY_RARE, 0.01)
        );
    }

    @Override
    public SEntityEquipment getEntityEquipment()
    {
        return new SEntityEquipment(SItem.of(SMaterial.END_STONE_BOW).getStack(),
                SItem.of(SMaterial.SUMMONING_EYE).getStack(),
                SUtil.applyColorToLeatherArmor(new ItemStack(Material.LEATHER_CHESTPLATE), Color.fromRGB(0x000000)),
                SUtil.applyColorToLeatherArmor(new ItemStack(Material.LEATHER_LEGGINGS), Color.fromRGB(0x000000)),
                SUtil.applyColorToLeatherArmor(new ItemStack(Material.LEATHER_BOOTS), Color.fromRGB(0x000000)));
    }
}
