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
package dev.vortex.sculk.item.oddities;

import dev.vortex.sculk.gui.GUIType;
import dev.vortex.sculk.item.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class SkyBlockMenu implements MaterialStatistics, MaterialFunction
{
    @Override
    public String getDisplayName()
    {
        return ChatColor.GREEN + "SkyBlock Menu " + ChatColor.GRAY + "(Right Click)";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.EXCLUSIVE;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ITEM;
    }

    @Override
    public String getLore()
    {
        return "View all of your SkyBlock progress, including your Skills, Collections, Recipes, and more!";
    }

    @Override
    public boolean displayRarity()
    {
        return false;
    }

    @Override
    public void onInteraction(PlayerInteractEvent e)
    {
        GUIType.SKYBLOCK_MENU.getGUI().open(e.getPlayer());
    }

    @Override
    public void onInventoryClick(SItem instance, InventoryClickEvent e)
    {
        e.setCancelled(true);
        GUIType.SKYBLOCK_MENU.getGUI().open((Player) e.getWhoClicked());
    }
}