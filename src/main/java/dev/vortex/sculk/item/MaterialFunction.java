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

import com.google.common.util.concurrent.AtomicDouble;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public interface MaterialFunction {
	default void onInteraction(PlayerInteractEvent e) {
	}

	default void onInventoryClick(SItem instance, InventoryClickEvent e) {
	}

	default void onDamage(Entity damaged, Player damager, AtomicDouble damage, SItem item) {
	}

	default void onKill(Entity damaged, Player damager, SItem item) {
	}

	default void whileHolding(Player holding) {
	}

	default void onInstanceUpdate(SItem instance) {
	}
}
