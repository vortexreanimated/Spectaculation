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

import dev.vortex.sculk.Spectaculation;
import dev.vortex.sculk.entity.EntityStatistics;
import dev.vortex.sculk.entity.SEntity;
import dev.vortex.sculk.entity.caverns.CreeperFunction;
import dev.vortex.sculk.event.CreeperIgniteEvent;
import net.minecraft.server.v1_8_R3.EntityCreeper;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.lang.reflect.Field;

public class SneakyCreeper extends EntityCreeper implements EntityStatistics, SNMSEntity, CreeperFunction
{
    public SneakyCreeper(World world)
    {
        super(world);
    }

    public SneakyCreeper()
    {
        this(((CraftWorld) Bukkit.getWorlds().getFirst()).getHandle());
    }

    @Override
    public String getEntityName()
    {
        return "Sneaky Creeper";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 120.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 80.0;
    }

    @Override
    public boolean isVisible()
    {
        return false;
    }

    @Override
    public void t_()
    {
        try
        {
            Field f = EntityCreeper.class.getDeclaredField("fuseTicks");
            f.setAccessible(true);
            int fuseTicks = (int) f.get(this);
            if (cm() > 0 && fuseTicks == 0)
            {
                CreeperIgniteEvent ignite = new CreeperIgniteEvent((Creeper) this.getBukkitEntity());
                Spectaculation.getPlugin().getServer().getPluginManager().callEvent(ignite);
                if (ignite.isCancelled())
                    return;
            }
        }
        catch (IllegalAccessException | NoSuchFieldException ignored) {}
        super.t_();
    }

    @Override
    public void onCreeperIgnite(CreeperIgniteEvent e, SEntity sEntity)
    {
        sEntity.setVisible(true);
        new BukkitRunnable()
        {
            public void run()
            {
                if (e.getEntity().isDead())
                    return;
                sEntity.setVisible(false);
            }
        }.runTaskLater(Spectaculation.getPlugin(), 35);
    }

    @Override
    public LivingEntity spawn(Location location)
    {
        this.world = ((CraftWorld) location.getWorld()).getHandle();
        this.setPosition(location.getX(), location.getY(), location.getZ());
        this.world.addEntity(this, CreatureSpawnEvent.SpawnReason.CUSTOM);
        return (LivingEntity) this.getBukkitEntity();
    }

    public double getXPDropped()
    {
        return 8.0;
    }
}