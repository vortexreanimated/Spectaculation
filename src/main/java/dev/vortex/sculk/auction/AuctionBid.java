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

import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class AuctionBid implements ConfigurationSerializable
{
    private UUID bidder;
    private long amount;
    private long timestamp;

    public AuctionBid(UUID bidder, long amount, long timestamp)
    {
        this.bidder = bidder;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    @Override
    public Map<String, Object> serialize()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("bidder", bidder.toString());
        map.put("amount", amount);
        map.put("timestamp", timestamp);
        return map;
    }

    public static AuctionBid deserialize(Map<String, Object> map)
    {
        return new AuctionBid(UUID.fromString((String) map.get("bidder")),
                map.get("amount") instanceof Long ? (Long) map.get("amount") : ((Integer) map.get("amount")).longValue(),
                map.get("timestamp") instanceof Long ? (Long) map.get("timestamp") : ((Integer) map.get("timestamp")).longValue());
    }

    public UUID getBidder()
    {
        return bidder;
    }

    public void setBidder(UUID bidder)
    {
        this.bidder = bidder;
    }

    public long getAmount()
    {
        return amount;
    }

    public void setAmount(long amount)
    {
        this.amount = amount;
    }

    public long getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(long timestamp)
    {
        this.timestamp = timestamp;
    }

    public long timeSinceBid()
    {
        return System.currentTimeMillis() - timestamp;
    }
}