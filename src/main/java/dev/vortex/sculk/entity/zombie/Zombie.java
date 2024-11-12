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
package dev.vortex.sculk.entity.zombie;

import dev.vortex.sculk.entity.EntityDrop;
import dev.vortex.sculk.entity.EntityDropType;
import dev.vortex.sculk.item.SMaterial;

import java.util.Arrays;
import java.util.List;

public class Zombie extends BaseZombie
{
    @Override
    public String getEntityName()
    {
        return "Zombie";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 100.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 20.0;
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Arrays.asList(new EntityDrop(SMaterial.ROTTEN_FLESH, EntityDropType.GUARANTEED, 1.0),
                new EntityDrop(SMaterial.POISONOUS_POTATO, EntityDropType.OCCASIONAL, 0.05),
                new EntityDrop(SMaterial.POTATO_ITEM, EntityDropType.OCCASIONAL, 0.05),
                new EntityDrop(SMaterial.CARROT_ITEM, EntityDropType.OCCASIONAL, 0.05));
    }

    @Override
    public boolean isBaby()
    {
        return false;
    }

    @Override
    public boolean isVillager()
    {
        return false;
    }

    @Override
    public double getXPDropped()
    {
        return 6.0;
    }
}