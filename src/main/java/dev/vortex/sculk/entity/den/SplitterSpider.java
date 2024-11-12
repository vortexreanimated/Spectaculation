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

import dev.vortex.sculk.entity.SEntity;
import dev.vortex.sculk.entity.SEntityType;
import org.bukkit.entity.Entity;

public class SplitterSpider extends BaseSpider
{
    @Override
    public String getEntityName()
    {
        return "Splitter Spider";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 180.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 30.0;
    }

    @Override
    public double getXPDropped()
    {
        return 9.7;
    }

    @Override
    public void onDeath(SEntity sEntity, Entity killed, Entity damager)
    {
        super.onDeath(sEntity, killed, damager);
        for (int i = 0; i < 2; i++) {
            new SEntity(sEntity.getEntity(), SEntityType.SILVERFISH);
        }
    }
}
