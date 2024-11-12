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
package dev.vortex.sculk.entity;

import dev.vortex.sculk.Spectaculation;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;

import java.util.*;

public final class StaticDragonManager
{
    public static boolean ACTIVE = false;
    public static Map<UUID, List<Location>> EYES = new HashMap<>();
    public static SEntity DRAGON = null;

    public static void endFight()
    {
        if (DRAGON == null) return;
        ACTIVE = false;
        for (List<Location> locations : StaticDragonManager.EYES.values())
        {
            for (Location location : locations)
            {
                Block b = location.getBlock();
                BlockState s = b.getState();
                s.setRawData((byte) 0);
                s.update();
                b.removeMetadata("placer", Spectaculation.getPlugin());
            }
        }
        EYES.clear();
        DRAGON = null;
    }
}