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
package dev.vortex.sculk.entity.nms;

import dev.vortex.sculk.entity.EntityFunction;
import dev.vortex.sculk.entity.EntityStatistics;
import net.minecraft.server.v1_8_R3.EntityArmorStand;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class VelocityArmorStand extends EntityArmorStand implements EntityStatistics, EntityFunction, SNMSEntity
{
    public VelocityArmorStand(World world)
    {
        super(world);
        this.setGravity(true);
        this.noclip = true;
    }

    public VelocityArmorStand()
    {
        this(((CraftWorld) Bukkit.getWorlds().getFirst()).getHandle());
    }

    public void g(float f, float f1)
    {
        if (!hasGravity())
            super.g(f, f1);
        else
            move(motX, motY, motZ);
    }

    @Override
    public String getEntityName()
    {
        return null;
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 1.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 0;
    }

    @Override
    public boolean hasNameTag()
    {
        return false;
    }

    public double getXPDropped()
    {
        return 0.0;
    }

    @Override
    public LivingEntity spawn(Location location)
    {
        this.world = ((CraftWorld) location.getWorld()).getHandle();
        this.setPosition(location.getX(), location.getY(), location.getZ());
        this.world.addEntity(this, CreatureSpawnEvent.SpawnReason.CUSTOM);
        return (LivingEntity) this.getBukkitEntity();
    }
}