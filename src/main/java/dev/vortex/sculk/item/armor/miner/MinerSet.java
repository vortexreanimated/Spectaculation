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
package dev.vortex.sculk.item.armor.miner;

import dev.vortex.sculk.item.MaterialStatistics;
import dev.vortex.sculk.item.SItem;
import dev.vortex.sculk.item.armor.TickingSet;
import dev.vortex.sculk.listener.PlayerListener;
import dev.vortex.sculk.region.Region;
import dev.vortex.sculk.user.*;
import dev.vortex.sculk.util.Groups;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MinerSet implements TickingSet
{
    @Override
    public String getName()
    {
        return "Regeneration";
    }

    @Override
    public String getDescription()
    {
        return "Regenerates 5% of your max Health every second if you have been out of combat for the last 8 seconds.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet()
    {
        return MinerHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate()
    {
        return MinerChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings()
    {
        return MinerLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots()
    {
        return MinerBoots.class;
    }

    @Override
    public void tick(Player owner, SItem helmet, SItem chestplate, SItem leggings, SItem boots, List<AtomicInteger> counters)
    {
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(owner.getUniqueId());
        DoublePlayerStatistic defense = statistics.getDefense();
        PlayerListener.CombatAction action = PlayerListener.getLastCombatAction(owner);
        counters.getFirst().incrementAndGet();
        if ((action == null || (action.getTimeStamp() + 8000 <= System.currentTimeMillis() && helmet != null && chestplate != null && leggings != null && boots != null)) && counters.getFirst().get() >= 2)
        {
            owner.setHealth(Math.min(owner.getMaxHealth(), owner.getHealth() + (owner.getMaxHealth() * 0.05)));
            counters.getFirst().set(0);
        }
        Region region = Region.getRegionOfEntity(owner);
        if (region == null) {
            return;
        }
        if (!Groups.DEEP_CAVERNS_REGIONS.contains(region.getType())) {
            return;
        }
        if (helmet != null) {
            defense.add(PlayerStatistic.MINER_BUFF, 45.0);
        }
        if (chestplate != null) {
            defense.add(PlayerStatistic.MINER_BUFF, 95.0);
        }
        if (leggings != null) {
            defense.add(PlayerStatistic.MINER_BUFF, 70.0);
        }
        if (boots != null) {
            defense.add(PlayerStatistic.MINER_BUFF, 45.0);
        }
    }
}
