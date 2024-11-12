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

public class BiteRune implements Rune
{
    @Override
    public String getDisplayName()
    {
        return ChatColor.GREEN + "◆ Bite Rune";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.EPIC;
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
        return "43a1ad4fcc42fb63c681328e42d63c83ca193b333af2a426728a25a8cc600692";
    }
}