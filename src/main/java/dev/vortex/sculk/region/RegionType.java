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
package dev.vortex.sculk.region;

import lombok.Getter;
import org.bukkit.ChatColor;

@Getter
public enum RegionType
{
    VILLAGE("Village"),
    MOUNTAIN("Mountain"),
    FOREST("Forest"),
    FARM("Farm"),
    RUINS("Ruins"),
    COLOSSEUM("Colosseum"),
    GRAVEYARD("Graveyard", ChatColor.RED),
    COAL_MINE("Coal Mine"),
    COAL_MINE_CAVES("Coal Mine"),
    WILDERNESS("Wilderness", ChatColor.DARK_GREEN),
    HIGH_LEVEL("High Level", ChatColor.RED),
    AUCTION_HOUSE("Auction House", ChatColor.GOLD),
    BAZAAR_ALLEY("Bazaar Alley", ChatColor.YELLOW),
    BANK("Bank", ChatColor.GOLD),
    BLACKSMITH("Blacksmith"),
    LIBRARY("Library"),
    THE_BARN("The Barn"),
    MUSHROOM_DESERT("Mushroom Desert"),
    GOLD_MINE("Gold Mine", ChatColor.GOLD),
    DEEP_CAVERN("Deep Caverns"),
    GUNPOWDER_MINES("Gunpowder Mines"),
    LAPIS_QUARRY("Lapis Quarry"),
    PIGMENS_DEN("Pigmen's Den"),
    SLIMEHILL("Slimehill"),
    BIRCH_PARK("Birch Park", ChatColor.GREEN),
    SPRUCE_WOODS("Spruce Woods", ChatColor.GREEN),
    DARK_THICKET("Dark Thicket", ChatColor.GREEN),
    SAVANNA_WOODLAND("Savanna Woodland", ChatColor.GREEN),
    JUNGLE_ISLAND("Jungle Island", ChatColor.GREEN),
    HOWLING_CAVE("Howling Cave"),
    DIAMOND_RESERVE("Diamond Reserve"),
    OBSIDIAN_SANCTUARY("Obsidian Sanctuary"),
    SPIDERS_DEN("Spider's Den", ChatColor.RED),
    SPIDERS_DEN_HIVE("Spider's Den", ChatColor.RED),
    BLAZING_FORTRESS("Blazing Fortress", ChatColor.RED),
    THE_END("The End", ChatColor.LIGHT_PURPLE),
    THE_END_NEST("The End", ChatColor.LIGHT_PURPLE),
    DRAGONS_NEST("Dragon's Nest", ChatColor.DARK_PURPLE)
    ;

    private final String name;
    private final ChatColor color;

    RegionType(String name, ChatColor color)
    {
        this.name = name;
        this.color = color;
    }

    RegionType(String name)
    {
        this(name, ChatColor.AQUA);
    }

    RegionType()
    {
        this(null, ChatColor.GRAY);
    }

    public static RegionType getByID(int id)
    {
        return RegionType.values()[id];
    }

    public static RegionType getType(String string)
    {
        try
        {
            return valueOf(string);
        }
        catch (IllegalArgumentException ignored) {}
        return null;
    }
}
