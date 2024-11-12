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
import dev.vortex.sculk.item.SMaterial;
import dev.vortex.sculk.user.User;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class QuiverGUI extends GUI
{
    public QuiverGUI()
    {
        super("Quiver", 36);
        fill(BLACK_STAINED_GLASS_PANE, 27, 35);
        set(GUIClickableItem.getCloseItem(31));
    }

    @Override
    public void onOpen(GUIOpenEvent e)
    {
        set(GUIClickableItem.createGUIOpenerItem(GUIType.SKYBLOCK_MENU, e.getPlayer(), ChatColor.GREEN + "Go Back", 30, Material.ARROW));
        User user = User.getUser(e.getPlayer().getUniqueId());
        Inventory inventory = e.getInventory();
        for (Map.Entry<SMaterial, Integer> entry : user.getQuiver().entrySet())
            inventory.addItem(SUtil.setStackAmount(SItem.of(entry.getKey()).getStack(), entry.getValue()));
    }

    @Override
    public void onClose(InventoryCloseEvent e)
    {
        User user = User.getUser(e.getPlayer().getUniqueId());
        Inventory inventory = e.getInventory();
        user.clearQuiver();
        for (int i = 0; i < 27; i++)
        {
            ItemStack stack = inventory.getItem(i);
            SItem sItem = SItem.find(stack);
            if (sItem == null)
            {
                sItem = SItem.of(stack);
                if (sItem == null)
                    continue;
            }
            user.addToQuiver(sItem.getType(), stack.getAmount());
        }
        user.save();
    }
}