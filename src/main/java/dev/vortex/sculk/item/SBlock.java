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
package dev.vortex.sculk.item;

import dev.vortex.sculk.Spectaculation;
import dev.vortex.sculk.util.SUtil;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;

@Getter
public class SBlock {
	protected static final Spectaculation plugin = Spectaculation.getPlugin();

	private final Location location;
	@Setter
	private SMaterial type;
	private NBTTagCompound data;

	public SBlock(Location location, SMaterial type, NBTTagCompound data) {
		this.location = location;
		this.type = type;
		this.data = data;
	}

	public float getDataFloat(String key) {
		return data.getFloat(key);
	}

	public long getDataLong(String key) {
		return data.getLong(key);
	}

	public double getDataDouble(String key) {
		return data.getDouble(key);
	}

	public String getDataString(String key) {
		return data.getString(key);
	}

	public static SBlock getBlock(Location location) {
		ConfigurationSection cs = plugin.blocks.getConfigurationSection(toLocationString(location));
		if (cs == null) {
			return null;
		}
		NBTTagCompound compound = new NBTTagCompound();
		for (String key : cs.getKeys(false)) {
			if ("type".equals(key)) {
				continue;
			}
			compound.set(key, SUtil.getBaseFromObject(cs, key));
		}
		return new SBlock(location, SMaterial.getMaterial(cs.getString("type")), compound);
	}

	public void save() {
		plugin.blocks.set(toLocationString() + ".type", type.name());
		for (String key : data.c()) {
			Object o = SUtil.getObjectFromCompound(data, key);
			if (o instanceof NBTTagCompound) {
				continue;
			}
			plugin.blocks.set(toLocationString() + "." + key, o);
		}
		plugin.blocks.save();
	}

	public void delete() {
		plugin.blocks.set(toLocationString(), null);
		plugin.blocks.save();
	}

	private String toLocationString() {
		return toLocationString(location);
	}

	private static String toLocationString(Location location) {
		return location.getBlockX() + "," + location.getBlockY() + "," + location.getBlockZ() + ","
				+ location.getWorld().getName();
	}
}
