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

import lombok.Getter;
import org.bukkit.ChatColor;

public enum Rarity
{
    COMMON(ChatColor.WHITE),
    UNCOMMON(ChatColor.GREEN),
    RARE(ChatColor.BLUE),
    EPIC(ChatColor.DARK_PURPLE),
    LEGENDARY(ChatColor.GOLD),
    MYTHIC(ChatColor.LIGHT_PURPLE),
    SUPREME(ChatColor.DARK_RED),
    SPECIAL(ChatColor.RED),
    VERY_SPECIAL(ChatColor.RED),
    EXCLUSIVE(ChatColor.GRAY);

    @Getter
    private final ChatColor color;

    Rarity(ChatColor color)
    {
        this.color = color;
    }

    public Rarity upgrade()
    {
        return values()[Math.min(this.ordinal() + 1, values().length - 1)];
    }

    public Rarity downgrade()
    {
        if (this.ordinal() - 1 < 0) {
            return this;
        }
        return values()[this.ordinal() - 1];
    }

    public boolean isAtLeast(Rarity rarity)
    {
        return ordinal() >= rarity.ordinal();
    }

    public String getDisplay()
    {
        return "" + color + ChatColor.BOLD + name().replaceAll("_", " ");
    }

    public String getBoldedColor()
    {
        return "" + color + ChatColor.BOLD;
    }

    public static Rarity getRarity(String string)
    {
        try
        {
            return Rarity.valueOf(string.toUpperCase());
        }
        catch (IllegalArgumentException ex)
        {
            return null;
        }
    }
}
