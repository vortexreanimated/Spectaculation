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
package dev.vortex.sculk.entity.wolf;

import dev.vortex.sculk.entity.SEntity;
import dev.vortex.sculk.entity.nms.SvenPackmaster;
import lombok.Getter;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Wolf;

public class SvenPup extends BaseWolf
{
    private final double health;
    private final double damage;
    private final CraftPlayer target;
    @Getter
    private final SvenPackmaster parent;

    public SvenPup(Double health, Double damage, CraftPlayer target, SvenPackmaster parent)
    {
        this.health = health;
        this.damage = damage;
        this.target = target;
        this.parent = parent;
    }

    @Override
    public String getEntityName()
    {
        return "Sven Pup";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return health;
    }

    @Override
    public double getDamageDealt()
    {
        return damage;
    }

    @Override
    public double getXPDropped()
    {
        return 0.0;
    }

    @Override
    public boolean isAngry()
    {
        return true;
    }

    @Override
    public boolean isBaby()
    {
        return true;
    }

    @Override
    public void onSpawn(LivingEntity entity, SEntity sEntity)
    {
        ((Wolf) entity).setTarget(target);
    }

    @Override
    public void onDeath(SEntity sEntity, Entity killed, Entity damager)
    {
        parent.getPups().remove(sEntity);
    }
}
