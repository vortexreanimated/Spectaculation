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
package dev.vortex.sculk.entity.nether;

import dev.vortex.sculk.Spectaculation;
import dev.vortex.sculk.entity.EntityFunction;
import dev.vortex.sculk.entity.SEntity;
import dev.vortex.sculk.entity.SlimeStatistics;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftMagmaCube;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

public class LargeMagmaCube implements SlimeStatistics, EntityFunction
{
    @Override
    public String getEntityName()
    {
        return "Magma Cube";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 300.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 150.0;
    }

    @Override
    public double getXPDropped()
    {
        return 4.0;
    }

    @Override
    public void onTarget(SEntity sEntity, EntityTargetLivingEntityEvent e)
    {
        LivingEntity entity = (LivingEntity) e.getEntity();
        Entity found = e.getTarget();
        new BukkitRunnable()
        {
            public void run()
            {
                if (entity.isDead())
                {
                    cancel();
                    return;
                }
                Entity target = ((CraftMagmaCube) entity).getHandle().getGoalTarget().getBukkitEntity();
                if (!found.equals(target))
                {
                    cancel();
                    return;
                }
                for (int i = 0; i < 3; i++)
                {
                    new BukkitRunnable()
                    {
                        public void run()
                        {
                            if (entity.isDead())
                            {
                                cancel();
                                return;
                            }
                            Fireball fireball = entity.getWorld().spawn(entity.getEyeLocation().add(
                                    entity.getEyeLocation().getDirection().multiply(3.0)), Fireball.class);
                            fireball.setMetadata("magma", new FixedMetadataValue(Spectaculation.getPlugin(), sEntity));
                            fireball.setDirection(target.getLocation().getDirection().multiply(-1.0).normalize());
                        }
                    }.runTaskLater(Spectaculation.getPlugin(), (i + 1) * 10);
                }
            }
        }.runTaskTimer(Spectaculation.getPlugin(), 60, 100);
    }

    @Override
    public int getSize()
    {
        return 6;
    }

    @Override
    public boolean split()
    {
        return false;
    }
}