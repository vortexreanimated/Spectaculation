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
package dev.vortex.sculk;

import java.util.Arrays;
import java.util.List;

public final class SkyBlockCalendar {
	public static final List<String> MONTH_NAMES = Arrays.asList("Early Spring", "Spring", "Late Spring",
			"Early Summer", "Summer", "Late Summer", "Early Autumn", "Autumn", "Late Autumn", "Early Winter", "Winter",
			"Late Winter");

	public static long ELAPSED;
	public static final int YEAR = 8928000;
	public static final int MONTH = 744000;
	public static final int DAY = 24000;
	// public static final long HOUR = 50000L;

	private SkyBlockCalendar() {
	}

	public static int getYear() {
		return (int) (ELAPSED / YEAR);
	}

	public static int getMonth() {
		return ((int) (ELAPSED / MONTH) % 12) + 1;
	}

	public static int getDay() {
		return ((int) (ELAPSED / DAY) % 31) + 1;
	}

	public static String getMonthName(int month) {
		if (month < 1 || month > 12) {
			return "Unknown Month";
		}
		return MONTH_NAMES.get(month - 1);
	}

	public static String getMonthName() {
		return getMonthName(getMonth());
	}

	public static void saveElapsed() {
		Spectaculation plugin = Spectaculation.getPlugin();
		plugin.config.set("timeElapsed", ELAPSED);
		plugin.config.save();
	}
}
