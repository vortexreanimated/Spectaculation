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

import net.minecraft.server.v1_8_R3.World;
import org.apache.commons.lang3.Range;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;

public class StrongDragon extends Dragon
{
    public StrongDragon(World world)
    {
        super(world, Dragon.DEFAULT_SPEED_MODIFIER, Range.between(0.5, 0.8), Dragon.DEFAULT_ATTACK_COOLDOWN);
    }

    public StrongDragon()
    {
        this(((CraftWorld) Bukkit.getWorlds().getFirst()).getHandle());
    }

    @Override
    public String getEntityName()
    {
        return "Strong Dragon";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 9000000.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 1700.0;
    }
}
