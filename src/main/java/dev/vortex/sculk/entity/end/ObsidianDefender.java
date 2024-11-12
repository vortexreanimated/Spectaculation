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
import net.minecraft.server.v1_8_R3.GenericAttributes;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftSkeleton;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Arrays;
import java.util.List;

public class ObsidianDefender implements EntityFunction, EntityStatistics
{
    @Override
    public String getEntityName()
    {
        return "Obsidian Defender";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 10000.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 200.0;
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Arrays.asList(
                new EntityDrop(new ItemStack(Material.OBSIDIAN, SUtil.random(6, 7)), EntityDropType.GUARANTEED, 1.0),
                new EntityDrop(SItem.of(SMaterial.ENCHANTED_OBSIDIAN).getStack(), EntityDropType.RARE, 0.05),
                new EntityDrop(SItem.of(SMaterial.OBSIDIAN_CHESTPLATE).getStack(), EntityDropType.EXTRAORDINARILY_RARE, 0.001)
        );
    }

    @Override
    public SEntityEquipment getEntityEquipment()
    {
        return new SEntityEquipment(new ItemStack(Material.AIR),
                new ItemStack(Material.OBSIDIAN),
                SItem.of(SMaterial.OBSIDIAN_CHESTPLATE).getStack(),
                null, null);
    }

    @Override
    public void onSpawn(LivingEntity entity, SEntity sEntity)
    {
        ((CraftLivingEntity) entity).getHandle().getAttributeInstance(GenericAttributes.c).setValue(1.0D);
        ((CraftSkeleton) entity).getHandle().setSkeletonType(1);
        entity.getEquipment().setItemInHand(null);
    }

    @Override
    public double getMovementSpeed()
    {
        return 0.6;
    }

    @Override
    public void onAttack(EntityDamageByEntityEvent e)
    {
        if (!(e.getEntity() instanceof LivingEntity)) return;
        if (e.getEntity() instanceof Player)
        {
            PlayerInventory inventory = ((Player) e.getEntity()).getInventory();
            SItem sItem = SItem.find(inventory.getChestplate());
            if (sItem != null)
            {
                if (sItem.getType() == SMaterial.OBSIDIAN_CHESTPLATE)
                    return;
            }
        }
        ((LivingEntity) e.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 80, 1));
    }

    @Override
    public double getXPDropped()
    {
        return 43.2;
    }
}