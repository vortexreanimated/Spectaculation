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

import dev.vortex.sculk.user.User;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class BankerGUI extends GUI
{
    public BankerGUI()
    {
        super("Personal Bank Account", 36);
    }

    @Override
    public void onOpen(GUIOpenEvent e)
    {
        Player player = e.getPlayer();
        User user = User.getUser(e.getPlayer().getUniqueId());
        fill(BLACK_STAINED_GLASS_PANE);
        set(GUIClickableItem.getCloseItem(31));
        set(new GUIClickableItem()
        {
            @Override
            public ItemStack getItem()
            {
                return SUtil.getStack(ChatColor.GREEN + "Deposit Coins", Material.CHEST, (short) 0, 1,
                        ChatColor.GRAY + "Current balance: " + ChatColor.GOLD + SUtil.commaify(user.getBankCoins()),
                        " ",
                        ChatColor.GRAY + "Store coins in the bank to",
                        ChatColor.GRAY + "keep them safe while you go",
                        ChatColor.GRAY + "on adventures!",
                        " ",
                        ChatColor.GRAY + "You will earn " + ChatColor.AQUA + "2%" + ChatColor.GRAY + " interest every",
                        ChatColor.GRAY + "season for your first " + ChatColor.GOLD + "10 million",
                        ChatColor.GRAY + "banked coins.",
                        " ",
                        ChatColor.GRAY + "Until interest: " + ChatColor.RED + "Unavailable",
                        " ",
                        ChatColor.YELLOW + "Click to make a deposit!");
            }

            @Override
            public void run(InventoryClickEvent e)
            {
                GUIType.BANKER_DEPOSIT.getGUI().open(player);
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
            public ItemStack getItem()
            {
                return SUtil.getStack(ChatColor.GREEN + "Withdraw Coins", Material.DROPPER, (short) 0, 1,
                        ChatColor.GRAY + "Current balance: " + ChatColor.GOLD + SUtil.commaify(user.getBankCoins()),
                        " ",
                        ChatColor.GRAY + "Take your coins out of the",
                        ChatColor.GRAY + "bank in order to spend",
                        ChatColor.GRAY + "them.",
                        " ",
                        ChatColor.YELLOW + "Click to withdraw coins!");
            }

            @Override
            public void run(InventoryClickEvent e)
            {
                GUIType.BANKER_WITHDRAWAL.getGUI().open(player);
            }

            @Override
            public int getSlot()
            {
                return 13;
            }
        });
        set(15, SUtil.getStack(ChatColor.GREEN + "Recent transactions", Material.MAP, (short) 0, 1,
                " ",
                ChatColor.RED + "" + ChatColor.BOLD + "COMING SOON"));
        set(32, SUtil.getStack(ChatColor.GREEN + "Information", Material.REDSTONE_TORCH_ON, (short) 0, 1,
                ChatColor.GRAY + "Keep your coins safe in the bank!",
                ChatColor.GRAY + "You lose half the coins in your",
                ChatColor.GRAY + "purse when dying in combat.",
                " ",
                ChatColor.GRAY + "Balance limit: " + ChatColor.GOLD + "50 Million",
                " ",
                ChatColor.GRAY + "The banker rewards you every 31",
                ChatColor.GRAY + "hours with " + ChatColor.AQUA + "interest" + ChatColor.GRAY + " for the",
                ChatColor.GRAY + "coins in your bank balance.",
                " ",
                ChatColor.GRAY + "Interest " + ChatColor.RED + ChatColor.BOLD + "COMING SOON"));
    }
}