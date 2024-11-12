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
package dev.vortex.sculk.entity.den;

import dev.vortex.sculk.Spectaculation;
import dev.vortex.sculk.entity.EntityDrop;
import dev.vortex.sculk.entity.EntityDropType;
import dev.vortex.sculk.entity.SEntity;
import dev.vortex.sculk.item.SItem;
import dev.vortex.sculk.item.SMaterial;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collections;
import java.util.List;

public class MutantTarantula extends BaseSpider
{
    @Override
    public String getEntityName()
    {
        return ChatColor.RED + "Mutant Tarantula";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 576000;
    }

    @Override
    public double getDamageDealt()
    {
        return 5000.0;
    }

    @Override
    public double getXPDropped()
    {
        return 500.0;
    }

    @Override
    public void onSpawn(LivingEntity entity, SEntity sEntity)
    {
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                if (entity.isDead())
                {
                    cancel();
                    return;
                }
                for (Entity e : entity.getNearbyEntities(1, 1, 1))
                {
                    if (!(e instanceof Player)) {
                        return;
                    }
                    ((Player) e).damage(getDamageDealt() * 0.5, entity);
                }
            }
        }.runTaskTimer(Spectaculation.getPlugin(), 20, 20);
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Collections.singletonList(new EntityDrop(SUtil.setStackAmount(SItem.of(SMaterial.TARANTULA_WEB).getStack(), 5), EntityDropType.GUARANTEED, 1.0));
    }
}
