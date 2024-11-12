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
package dev.vortex.sculk.potion;

import lombok.Getter;

public enum PotionColor
{
    BLUE((short) 0),
    PURPLE((short) 1),
    LIGHT_BLUE((short) 2),
    ORANGE((short) 3),
    DARK_GREEN((short) 4),
    RED((short) 5),
    DARK_BLUE((short) 6),
    GRAY((short) 8),
    DARK_RED((short) 9),
    DARK_GRAY((short) 10),
    GREEN((short) 11),
    BLOOD_RED((short) 12),
    TWILIGHT_BLUE((short) 13),
    LIGHT_GRAY((short) 14);

    public static final short SPLASH = 16384;

    @Getter
    private final short data;

    PotionColor(short data)
    {
        this.data = data;
    }

    public short getSplashData()
    {
        return (short) (data + SPLASH);
    }
}
