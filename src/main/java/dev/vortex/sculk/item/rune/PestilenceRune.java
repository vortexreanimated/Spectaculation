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
package dev.vortex.sculk.item.rune;

import dev.vortex.sculk.item.GenericItemType;
import dev.vortex.sculk.item.Rarity;
import dev.vortex.sculk.item.Rune;
import dev.vortex.sculk.item.SpecificItemType;
import org.bukkit.ChatColor;

public class PestilenceRune implements Rune
{
    @Override
    public String getDisplayName()
    {
        return ChatColor.DARK_GREEN + "◆ Pestilence Rune";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.RARE;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ITEM;
    }

    @Override
    public SpecificItemType getSpecificType()
    {
        return SpecificItemType.COSMETIC;
    }

    @Override
    public String getURL()
    {
        return "a8c4811395fbf7f620f05cc3175cef1515aaf775ba04a01045027f0693a90147";
    }
}