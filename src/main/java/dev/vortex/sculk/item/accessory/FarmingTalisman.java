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
package dev.vortex.sculk.item.accessory;

import dev.vortex.sculk.item.GenericItemType;
import dev.vortex.sculk.item.PlayerBoostStatistics;
import dev.vortex.sculk.item.Rarity;
import dev.vortex.sculk.item.SItem;
import dev.vortex.sculk.region.Region;
import dev.vortex.sculk.region.RegionType;
import dev.vortex.sculk.user.PlayerUtils;
import org.bukkit.entity.Player;

public class FarmingTalisman implements AccessoryStatistics, AccessoryFunction
{
    @Override
    public String getDisplayName()
    {
        return "Farming Talisman";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.COMMON;
    }

    @Override
    public String getURL()
    {
        return "9af328c87b068509aca9834eface197705fe5d4f0871731b7b21cd99b9fddc";
    }

    @Override
    public void update(SItem instance, Player player, int accessorySlot)
    {
        Region region = Region.getQuickRegionOfEntity(player);
        if (region == null) return;
        if (region.getType() != RegionType.THE_BARN && region.getType() != RegionType.MUSHROOM_DESERT) return;
        PlayerUtils.addBoostStatistics(PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId()), accessorySlot, new PlayerBoostStatistics()
        {
            @Override
            public String getDisplayName()
            {
                return null;
            }
            @Override
            public Rarity getRarity()
            {
                return null;
            }
            @Override
            public GenericItemType getType()
            {
                return null;
            }
            @Override
            public double getBaseSpeed()
            {
                return 0.1;
            }
        });
    }
}