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

import dev.vortex.sculk.entity.EntityFunction;
import dev.vortex.sculk.entity.EntityStatistics;
import dev.vortex.sculk.entity.JockeyStatistics;
import dev.vortex.sculk.entity.SEntityType;

public class SpiderJockey extends BaseSpider implements JockeyStatistics
{
    @Override
    public SEntityType getPassenger()
    {
        return SEntityType.JOCKEY_SKELETON;
    }

    @Override
    public String getEntityName()
    {
        return "Spider";
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
        return 8.0;
    }

    public static class JockeySkeleton implements EntityStatistics, EntityFunction
    {
        @Override
        public String getEntityName()
        {
            return "Jockey Skeleton";
        }

        @Override
        public double getEntityMaxHealth()
        {
            return 250.0;
        }

        @Override
        public double getDamageDealt()
        {
            return 38.0;
        }

        @Override
        public double getXPDropped()
        {
            return 6.0;
        }
    }
}
