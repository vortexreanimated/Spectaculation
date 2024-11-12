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

public interface EntityStatistics
{
    String getEntityName();
    double getEntityMaxHealth();
    double getDamageDealt();
    double getXPDropped();
    default SEntityEquipment getEntityEquipment()
    {
        return null;
    }
    default double getMovementSpeed()
    {
        return -1.0;
    }
    default boolean dealsTrueDamage()
    {
        return false;
    }
    default boolean hasNameTag()
    {
        return true;
    }
    default boolean removeWhenFarAway()
    {
        return false;
    }
    default boolean isVisible()
    {
        return true;
    }
}