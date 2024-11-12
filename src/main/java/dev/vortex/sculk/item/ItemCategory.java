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

import dev.vortex.sculk.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

public enum ItemCategory
{
    WEAPONS("Weapons", ChatColor.GOLD, (short) 1),
    ARMOR("Armor", ChatColor.AQUA, (short) 11),
    ACCESSORIES("Accessories", ChatColor.DARK_GREEN, (short) 13),
    CONSUMABLES("Consumables", ChatColor.RED, (short) 14),
    BLOCKS("Blocks", ChatColor.YELLOW, (short) 12),
    TOOLS_MISC("Tools & Misc", ChatColor.LIGHT_PURPLE, (short) 10);

    private final String name;
    private final ChatColor text;
    private final short item;

    ItemCategory(String name, ChatColor text, short item)
    {
        this.name = name;
        this.text = text;
        this.item = item;
    }

    public String getName()
    {
        return name;
    }

    public String getColoredName()
    {
        return text + name;
    }

    public ItemStack getStainedGlassPane()
    {
        return SUtil.createColoredStainedGlassPane(item, " ");
    }
}
