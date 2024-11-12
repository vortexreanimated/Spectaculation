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

import dev.vortex.sculk.entity.EntityDrop;
import dev.vortex.sculk.entity.EntityDropType;
import dev.vortex.sculk.item.SMaterial;

import java.util.Arrays;
import java.util.List;

public class PackSpirit extends BaseWolf
{
    @Override
    public String getEntityName()
    {
        return "Pack Spirit";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 6000.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 270.0;
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Arrays.asList(new EntityDrop(SMaterial.BONE, EntityDropType.COMMON, 0.5),
                new EntityDrop(SMaterial.OAK_WOOD, EntityDropType.COMMON, 0.1),
                new EntityDrop(SMaterial.BIRCH_WOOD, EntityDropType.COMMON, 0.1));
    }

    public double getXPDropped()
    {
        return 15.0;
    }

    @Override
    public boolean isAngry()
    {
        return true;
    }
}