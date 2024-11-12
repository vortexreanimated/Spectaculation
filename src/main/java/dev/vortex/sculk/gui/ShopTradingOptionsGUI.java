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
package dev.vortex.sculk.gui;

import dev.vortex.sculk.item.SItem;
import dev.vortex.sculk.user.User;
import dev.vortex.sculk.util.SUtil;
import java.util.List;
import java.util.Map;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopTradingOptionsGUI extends GUI {
	private final SItem item;
	private final GUI ret;

	public ShopTradingOptionsGUI(SItem item, GUI ret) {
		super("Shop Trading Options", 54);
		this.item = item;
		this.ret = ret;
	}

	@Override
	public void onOpen(GUIOpenEvent e) {
		Player player = e.getPlayer();
		fill(BLACK_STAINED_GLASS_PANE);
		set(createTrade(item, 20, 1, player));
		set(createTrade(item, 21, 5, player));
		set(createTrade(item, 22, 10, player));
		set(createTrade(item, 23, 32, player));
		set(createTrade(item, 24, 64, player));
		set(GUIClickableItem.createGUIOpenerItem(ret, player, ChatColor.GREEN + "Go Back", 48, Material.ARROW,
				(short) 0, ChatColor.GRAY + "To " + ret.getTitle()));
		set(GUIClickableItem.getCloseItem(49));
	}

	private static GUIClickableItem createTrade(SItem item, int slot, int amount, Player player) {
		User user = User.getUser(player.getUniqueId());
		SItem display = item.clone();
		display.getStack().setAmount(amount);
		ItemMeta meta = display.getStack().getItemMeta();
		if (amount != 1) {
			meta.setDisplayName(meta.getDisplayName() + ChatColor.DARK_GRAY + " x" + amount);
		}
		List<String> lore = meta.getLore();
		lore.add(" ");
		lore.add(ChatColor.GRAY + "Cost");
		long price = item.getType().getStatistics().getPrice() * amount;
		lore.add(ChatColor.GOLD + SUtil.commaify(price) + " Coin" + (price != 1 ? "s" : ""));
		lore.add(" ");
		lore.add(ChatColor.YELLOW + "Click to purchase!");
		meta.setLore(lore);
		display.getStack().setItemMeta(meta);
		return new GUIClickableItem() {
			@Override
			public void run(InventoryClickEvent e) {
				if (price > user.getCoins()) {
					player.sendMessage(ChatColor.RED + "You don't have enough coins!");
					return;
				}
				Map<Integer, ItemStack> m = player.getInventory()
						.addItem(SUtil.setSItemAmount(item.clone(), amount).getStack());
				if (m.size() != 0) {
					player.sendMessage(ChatColor.RED + "Free up inventory space to purchase this!");
					return;
				}
				player.playSound(player.getLocation(), Sound.NOTE_PLING, 1f, 2f);
				user.subCoins(price);
			}

			@Override
			public int getSlot() {
				return slot;
			}

			@Override
			public ItemStack getItem() {
				return display.getStack();
			}
		};
	}
}
