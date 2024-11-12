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
package dev.vortex.sculk.auction;

import dev.vortex.sculk.item.SItem;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

public class AuctionEscrow implements ConfigurationSerializable
{
    private SItem item;
    private long starter;
    private long duration;

    public AuctionEscrow(SItem item, long starter, long duration)
    {
        this.item = item;
        this.starter = starter;
        this.duration = duration;
    }

    public AuctionEscrow()
    {
        this(null, 50L, 21600000L);
    }

    @Override
    public Map<String, Object> serialize()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("item", item);
        map.put("starter", starter);
        map.put("duration", duration);
        return map;
    }

    public static AuctionEscrow deserialize(Map<String, Object> map)
    {
        return new AuctionEscrow((SItem) map.get("item"), map.get("starter") instanceof Long ? (Long) map.get("starter") : ((Integer) map.get("starter")).longValue(),
                map.get("duration") instanceof Long ? (Long) map.get("duration") : ((Integer) map.get("duration")).longValue());
    }

    public SItem getItem()
    {
        return item;
    }

    public void setItem(SItem item)
    {
        this.item = item;
    }

    public long getStarter()
    {
        return starter;
    }

    public void setStarter(long starter)
    {
        this.starter = starter;
    }

    public long getDuration()
    {
        return duration;
    }

    public void setDuration(long duration)
    {
        this.duration = duration;
    }

    public long getCreationFee(boolean bin)
    {
        return Math.round(starter * (bin ? 0.01 : 0.05));
    }
}