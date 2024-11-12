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

import dev.vortex.sculk.slayer.SlayerBossType;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class SlayerConfirmGUI extends GUI
{
    public SlayerConfirmGUI(SlayerBossType type, Runnable onConfirm)
    {
        super("Confirm", 27);
        set(new GUIClickableItem()
        {
            @Override
            public void run(InventoryClickEvent e)
            {
                onConfirm.run();
                e.getWhoClicked().closeInventory();
            }

            @Override
            public ItemStack getItem()
            {
                return SUtil.getStack(ChatColor.GREEN + "Confirm", Material.STAINED_CLAY, (short) 13, 1,
                        ChatColor.GRAY + "Kill " + type.getType().getPluralName() + " to spawn the",
                        ChatColor.GRAY + "boss!",
                        "",
                        ChatColor.YELLOW + "Click to start quest!");
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