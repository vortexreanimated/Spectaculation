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
package dev.vortex.sculk.item.weapon;

import dev.vortex.sculk.item.*;
import dev.vortex.sculk.user.User;
import dev.vortex.sculk.util.SUtil;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class EmeraldBlade implements ToolStatistics, MaterialFunction, Ownable {
	@Override
	public String getDisplayName() {
		return "Emerald Blade";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.EPIC;
	}

	@Override
	public GenericItemType getType() {
		return GenericItemType.WEAPON;
	}

	@Override
	public SpecificItemType getSpecificType() {
		return SpecificItemType.SWORD;
	}

	@Override
	public int getBaseDamage() {
		return 130;
	}

	@Override
	public List<String> getListLore() {
		return Arrays.asList("A powerful blade made from pure",
				ChatColor.DARK_GREEN + "Emeralds" + ChatColor.GRAY + ". This blade becomes",
				"stronger as you carry more", ChatColor.GOLD + "coins" + ChatColor.GRAY + " in your purse.");
	}

	@Override
	public List<String> getDataLore(String key, Object value) {
		if (!"owner".equals(key)) {
			return null;
		}
		Player player = Bukkit.getPlayer(UUID.fromString(String.valueOf(value)));
		if (player == null) {
			return null;
		}
		User user = User.getUser(player.getUniqueId());
		return Collections.singletonList(ChatColor.GRAY + "Current Damage Bonus: " + ChatColor.GREEN
				+ SUtil.roundTo(2.5 * SUtil.quadrt(user.getCoins()), 1));
	}

	@Override
	public NBTTagCompound getData() {
		return new NBTTagCompound();
	}
}
