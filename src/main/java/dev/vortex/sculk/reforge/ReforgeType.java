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
package dev.vortex.sculk.reforge;

import lombok.Getter;

public enum ReforgeType
{
    OVERPOWERED(OverpoweredReforge.class, false),
    SUPERGENIUS(SupergeniusReforge.class, false),
    SPICY(SpicyReforge.class),
    FIERCE(FierceReforge.class),
    HEROIC(HeroicReforge.class),
    ODD(OddReforge.class),
    RAPID(RapidReforge.class);

    private final Class<? extends Reforge> clazz;
    @Getter
    private final boolean accessible;

    ReforgeType(Class<? extends Reforge> clazz, boolean accessible)
    {
        this.clazz = clazz;
        this.accessible = accessible;
    }

    ReforgeType(Class<? extends Reforge> clazz)
    {
        this(clazz, true);
    }

    public Reforge getReforge()
    {
        try
        {
            return clazz.newInstance();
        }
        catch (InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static ReforgeType getReforgeType(String name)
    {
        return valueOf(name.toUpperCase());
    }

    public static ReforgeType getByClass(Class<? extends Reforge> clazz)
    {
        for (ReforgeType type : values())
        {
            if (type.clazz == clazz)
                return type;
        }
        return null;
    }
}