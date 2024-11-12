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
package dev.vortex.sculk.entity;

import dev.vortex.sculk.item.ItemOrigin;
import dev.vortex.sculk.item.SItem;
import dev.vortex.sculk.item.SMaterial;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@Getter
public class EntityDrop
{
    private final ItemStack stack;
    private final EntityDropType type;
    private final double dropChance;
    private final Player owner;

    public EntityDrop(ItemStack stack, EntityDropType type, double dropChance, Player owner)
    {
        this.stack = stack;
        this.type = type;
        this.dropChance = dropChance;
        this.owner = owner;
    }

    public EntityDrop(SMaterial material, byte variant, EntityDropType type, double dropChance, Player owner)
    {
        this.stack = SItem.of(material, variant).getStack();
        this.type = type;
        this.dropChance = dropChance;
        this.owner = owner;
    }

    public EntityDrop(SMaterial material, EntityDropType type, double dropChance, Player owner)
    {
        this(material, (byte) material.getData(), type, dropChance, owner);
    }

    public EntityDrop(SMaterial material, byte variant, EntityDropType type, double dropChance)
    {
        this(material, variant, type, dropChance, null);
    }

    public EntityDrop(ItemStack stack, EntityDropType type, double dropChance)
    {
        this(stack, type, dropChance, null);
    }

    public EntityDrop(SMaterial material, EntityDropType type, double dropChance)
    {
        this(material, type, dropChance, null);
    }

    public ItemStack getStack()
    {
        return stack;
    }

    public EntityDropType getType()
    {
        return type;
    }

    public double getDropChance()
    {
        return dropChance;
    }
}
