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

import dev.vortex.sculk.auction.AuctionEscrow;
import dev.vortex.sculk.auction.AuctionItem;
import dev.vortex.sculk.user.User;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class AuctionConfirmGUI extends GUI
{
    public AuctionConfirmGUI()
    {
        super("Confirm", 27);
    }

    @Override
    public void onOpen(GUIOpenEvent e)
    {
        Player player = e.getPlayer();
        User user = User.getUser(e.getPlayer().getUniqueId());
        AuctionEscrow escrow = user.getAuctionEscrow();
        if (escrow == null) {
            return;
        }
        set(new GUIClickableItem()
        {
            @Override
            public void run(InventoryClickEvent e)
            {
                AuctionItem item = AuctionItem.createAuction(escrow.getItem(), escrow.getStarter(), System.currentTimeMillis() + escrow.getDuration(), user.getUuid(), user.isAuctionCreationBIN());
                user.subCoins(escrow.getCreationFee(user.isAuctionCreationBIN()));
                user.setAuctionEscrow(new AuctionEscrow());
                new AuctionViewGUI(item).open(player);
            }

            @Override
            public ItemStack getItem()
            {
                int count = escrow.getItem().getStack().getAmount();
                return SUtil.getStack(ChatColor.GREEN + "Confirm", Material.STAINED_CLAY, (short) 13, 1,
                        ChatColor.GRAY + "Auctioning: " + (count != 1 ? count + "x " : "") + escrow.getItem().getFullName(),
                        ChatColor.GRAY + "Cost: " + ChatColor.GOLD + escrow.getCreationFee(user.isAuctionCreationBIN()) + " coins");
            }

            @Override
            public int getSlot()
            {
                return 11;
            }
        });
        set(new GUIClickableItem()
        {
            @Override
            public void run(InventoryClickEvent e)
            {
                e.getWhoClicked().closeInventory();
            }

            @Override
            public ItemStack getItem()
            {
                return SUtil.getStack(ChatColor.RED + "Cancel", Material.STAINED_CLAY, (short) 14, 1);
            }

            @Override
            public int getSlot()
            {
                return 15;
            }
        });
    }
}
