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

import net.minecraft.server.v1_8_R3.NBTTagCompound;

public interface ToolStatistics extends PlayerBoostStatistics, Enchantable, Reforgable {
	@Override
	String getDisplayName();

	@Override
	Rarity getRarity();

	@Override
	GenericItemType getType();

	@Override
	default boolean isStackable() {
		return false;
	}

	@Override
	default NBTTagCompound getData() {
		return new NBTTagCompound();
	}
}
