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

import dev.vortex.sculk.listener.PListener;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GUIListener extends PListener
{
    private static final Map<UUID, GUIQueryItem> QUERY_MAP = new HashMap<>();

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e)
    {
        GUI gui = GUI.GUI_MAP.get(e.getWhoClicked().getUniqueId());
        if (gui == null) return;
        if (e.getClickedInventory() == e.getView().getTopInventory())
        {
            int slot = e.getSlot();
            GUIItem item = gui.get(slot);
            if (item != null)
            {
                if (!item.canPickup())
                    e.setCancelled(true);
                if (item instanceof GUIClickableItem clickable)
                {
                    clickable.run(e);
                }
                if (item instanceof GUIQueryItem query)
                {
                    Player player = (Player) e.getWhoClicked();
                    player.closeInventory();
                    player.sendMessage(ChatColor.GREEN + "Enter your query:");
                    QUERY_MAP.put(player.getUniqueId(), query);
                }
            }
        }
        else
            gui.onBottomClick(e);
        gui.update(e.getView().getTopInventory());
    }

    @EventHandler
    public void onGUIOpen(GUIOpenEvent e)
    {
        e.getOpened().onOpen(e);
    }

    @EventHandler
    public void onBlockInteract(PlayerInteractEvent e)
    {
        if (e.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        Block block = e.getClickedBlock();
        for (GUIType type : GUIType.values())
        {
            GUI gui = type.getGUI();
            if (gui instanceof BlockBasedGUI uI)
            {
                if (uI.getBlock() == block.getType())
                {
                    e.setCancelled(true);
                    gui.open(e.getPlayer());
                    return;
                }
            }
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e)
    {
        Player player = e.getPlayer();
        if (!QUERY_MAP.containsKey(player.getUniqueId())) return;
        e.setCancelled(true);
        GUIQueryItem item = QUERY_MAP.get(player.getUniqueId());
        player.sendMessage(ChatColor.GOLD + "Querying for: " + e.getMessage());
        GUI next = item.onQueryFinish(e.getMessage());
        if (next != null)
            next.open(player);
        QUERY_MAP.remove(player.getUniqueId());
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e)
    {
        if (!(e.getPlayer() instanceof Player)) return;
        Player player = (Player) e.getPlayer();
        GUI gui = GUI.GUI_MAP.get(player.getUniqueId());
        if (gui == null) return;
        gui.onClose(e);
        GUI.GUI_MAP.remove(player.getUniqueId());
    }
}