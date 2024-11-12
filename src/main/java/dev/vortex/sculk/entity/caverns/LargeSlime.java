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

import dev.vortex.sculk.Spectaculation;
import dev.vortex.sculk.entity.EntityFunction;
import dev.vortex.sculk.entity.SlimeStatistics;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class LargeSlime implements SlimeStatistics, EntityFunction
{
    @Override
    public String getEntityName()
    {
        return "Slime";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 250.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 150.0;
    }

    @Override
    public int getSize()
    {
        return 10;
    }

    @Override
    public void onAttack(EntityDamageByEntityEvent e)
    {
        new BukkitRunnable()
        {
            public void run()
            {
                e.getEntity().setVelocity(e.getEntity().getVelocity().clone().setY(1.5));
            }
        }.runTaskLater(Spectaculation.getPlugin(), 1);
    }

    @Override
    public double getXPDropped()
    {
        return 20.0;
    }
}