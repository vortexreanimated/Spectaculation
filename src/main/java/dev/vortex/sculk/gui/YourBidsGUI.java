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

import dev.vortex.sculk.auction.AuctionItem;
import dev.vortex.sculk.user.User;
import dev.vortex.sculk.util.SUtil;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class YourBidsGUI extends GUI {
	private static final int[] INTERIOR = new int[]{10, 11, 12, 13, 14, 15, 16, 19, 20, 21, 22, 23, 24, 25, 28, 29, 30,
			31, 32, 33, 34, 37, 38, 39, 40, 41, 42, 43};

	private List<AuctionItem> items;

	public YourBidsGUI() {
		super("Your Bids", 27);
		border(BLACK_STAINED_GLASS_PANE);
	}

	@Override
	public void early(Player player) {
		User user = User.getUser(player.getUniqueId());
		this.items = user.getBids();
		this.size = Math.max(54, (((Double) Math.ceil(items.size() / 7.0)).intValue() * 9) + 18);
	}

	@Override
	public void onOpen(GUIOpenEvent e) {
		Player player = e.getPlayer();
		if (items == null) {
			return;
		}
		int ended = 0;
		for (AuctionItem item : items) {
			if (item.isExpired()) {
				ended++;
			}
		}
		if (ended != 0) {
			int finalEnded = ended;
			set(new GUIClickableItem() {
				@Override
				public void run(InventoryClickEvent e) {
					for (AuctionItem item : items) {
						if (item.isExpired()) {
							item.claim(player);
						}
					}
					player.closeInventory();
				}

				@Override
				public int getSlot() {
					return 21;
				}

				@Override
				public ItemStack getItem() {
					List<String> lore = new ArrayList<>();
					lore.add(ChatColor.DARK_GRAY + "Ended Auctions");
					lore.add(" ");
					lore.add(ChatColor.GRAY + "You got " + ChatColor.GREEN + finalEnded + " item"
							+ (finalEnded != 1 ? "s" : "") + ChatColor.GRAY + " to");
					lore.add(ChatColor.GRAY + "claim items/reclaim bids.");
					lore.add(" ");
					lore.add(ChatColor.YELLOW + "Click to claim!");
					return SUtil.getStack(ChatColor.GREEN + "Claim All", Material.CAULDRON_ITEM, (short) 0, 1, lore);
				}
			});
		}
		set(GUIClickableItem.createGUIOpenerItem(GUIType.AUCTION_HOUSE, player, ChatColor.GREEN + "Go Back", 22,
				Material.ARROW, ChatColor.GRAY + "To Auction House"));
		for (int i = 0; i < items.size(); i++) {
			AuctionItem item = items.get(i);
			int slot = INTERIOR[i];
			set(new GUIClickableItem() {
				@Override
				public void run(InventoryClickEvent e) {
					new AuctionViewGUI(item, YourBidsGUI.this).open(player);
				}

				@Override
				public int getSlot() {
					return slot;
				}

				@Override
				public ItemStack getItem() {
					return item.getDisplayItem(true, true);
				}
			});
		}
	}

	private enum Sort {
		RECENTLY_UPDATED("Recently Updated"), HIGHEST_BID("Highest Bid"), MOST_BIDS("Most Bids");

		private final String display;

		Sort(String display) {
			this.display = display;
		}

		public String getDisplay() {
			return display;
		}

		public Sort previous() {
			int prev = ordinal() - 1;
			if (prev < 0) {
				return values()[values().length - 1];
			}
			return values()[prev];
		}

		public Sort next() {
			int nex = ordinal() + 1;
			if (nex > values().length - 1) {
				return values()[0];
			}
			return values()[nex];
		}
	}
}
