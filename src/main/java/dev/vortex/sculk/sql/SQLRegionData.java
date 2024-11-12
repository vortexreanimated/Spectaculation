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
package dev.vortex.sculk.sql;

import dev.vortex.sculk.region.Region;
import dev.vortex.sculk.region.RegionType;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class SQLRegionData
{
    public boolean exists(String regionName)
    {
        return false;
    }

    public Region get(String name)
    {
        return null;
    }

    public List<Region> getAllOfType(RegionType type)
    {
        return new ArrayList<>();
    }


    public List<Region> getAll()
    {
        return new ArrayList<>();
    }

    public Region create(String name, Location firstLocation, Location secondLocation, RegionType type)
    {
        return null;
    }

    public void save(Region region)
    {

    }

    public void delete(Region region)
    {

    }

    public int getRegionCount()
    {
        return 0;
    }
}
