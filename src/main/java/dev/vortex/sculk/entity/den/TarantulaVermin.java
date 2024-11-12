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

import dev.vortex.sculk.entity.EntityDrop;
import dev.vortex.sculk.entity.EntityDropType;
import dev.vortex.sculk.item.SMaterial;

import java.util.Collections;
import java.util.List;

public class TarantulaVermin extends BaseSpider
{
    @Override
    public String getEntityName()
    {
        return "Tarantula Vermin";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 54000;
    }

    @Override
    public double getDamageDealt()
    {
        return 900.0;
    }

    @Override
    public double getXPDropped()
    {
        return 150.0;
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Collections.singletonList(new EntityDrop(SMaterial.TARANTULA_WEB, EntityDropType.GUARANTEED, 1.0));
    }
}