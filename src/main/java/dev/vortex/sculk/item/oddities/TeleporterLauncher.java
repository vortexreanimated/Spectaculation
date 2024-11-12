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
package dev.vortex.sculk.item.oddities;

import dev.vortex.sculk.item.*;
import net.minecraft.server.v1_8_R3.NBTTagCompound;

public class TeleporterLauncher implements MaterialStatistics, MaterialFunction, ItemData {
	@Override
	public String getDisplayName() {
		return "Teleporter Launcher";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.EXCLUSIVE;
	}

	@Override
	public GenericItemType getType() {
		return GenericItemType.BLOCK;
	}

	@Override
	public boolean isEnchanted() {
		return true;
	}

	@Override
	public NBTTagCompound getData() {
		NBTTagCompound compound = new NBTTagCompound();
		compound.setFloat("velX", 1f);
		compound.setFloat("velY", 1f);
		compound.setFloat("velZ", 1f);
		compound.setDouble("x", 0.0);
		compound.setDouble("y", 0.0);
		compound.setDouble("z", 0.0);
		compound.setString("world", "world");
		compound.setFloat("yaw", 0.0f);
		compound.setFloat("pitch", 0.0f);
		compound.setLong("delay", 60);
		return compound;
	}
}
