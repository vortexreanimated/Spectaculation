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
package dev.vortex.sculk.item.armor;

import dev.vortex.sculk.Spectaculation;
import dev.vortex.sculk.item.*;
import dev.vortex.sculk.user.PlayerStatistic;
import dev.vortex.sculk.user.PlayerStatistics;
import dev.vortex.sculk.user.PlayerUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;

public class ObsidianChestplate implements LeatherArmorStatistics, TickingMaterial
{
    @Override
    public int getColor()
    {
        return 0x000000;
    }

    @Override
    public String getDisplayName()
    {
        return "Obsidian Chestplate";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.EPIC;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ARMOR;
    }

    @Override
    public SpecificItemType getSpecificType()
    {
        return SpecificItemType.CHESTPLATE;
    }

    @Override
    public double getBaseDefense()
    {
        return 250;
    }

    @Override
    public void tick(SItem item, Player owner)
    {
       PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(owner.getUniqueId());
       statistics.getSpeed().zero(PlayerStatistic.OBSIDIAN_CHESTPLATE);
       int obsidian = 0;
       for (Map.Entry<Integer, ? extends ItemStack> entry : owner.getInventory().all(Material.OBSIDIAN).entrySet())
           obsidian += entry.getValue().getAmount();
       statistics.getSpeed().add(PlayerStatistic.OBSIDIAN_CHESTPLATE, ((obsidian / 20.0) / 100.0));
       new BukkitRunnable()
       {
           public void run()
           {
               SItem chestplate = SItem.find(owner.getInventory().getChestplate());
               if (chestplate != null && chestplate.getType() == SMaterial.OBSIDIAN_CHESTPLATE)
                   return;
               statistics.getSpeed().zero(PlayerStatistic.OBSIDIAN_CHESTPLATE);
           }
       }.runTaskLater(Spectaculation.getPlugin(), 13);
    }

    @Override
    public long getInterval()
    {
        return 10;
    }
}