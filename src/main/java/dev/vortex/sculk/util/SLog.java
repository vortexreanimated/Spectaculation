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
package dev.vortex.sculk.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SLog
{
    private static final Logger LOGGER = Logger.getLogger("Minecraft");
    private static final String PREFIX = "[Spectaculation]";

    private static void log(Object o, Level l)
    {
        LOGGER.log(l, PREFIX + " " + o);
    }

    public static void info(Object o)
    {
        log(o, Level.INFO);
    }

    public static void warn(Object o)
    {
        log(o, Level.WARNING);
    }

    public static void severe(Object o)
    {
        log(o, Level.SEVERE);
    }

    private SLog() {
    }
}
