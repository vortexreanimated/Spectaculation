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
package dev.vortex.sculk.item.dragon.superior;

import dev.vortex.sculk.item.GenericItemType;
import dev.vortex.sculk.item.MaterialStatistics;
import dev.vortex.sculk.item.PlayerBoostStatistics;
import dev.vortex.sculk.item.Rarity;
import dev.vortex.sculk.item.armor.ArmorSet;
import org.bukkit.entity.Player;

public class SuperiorDragonSet implements ArmorSet
{
    @Override
    public String getName()
    {
        return "Superior Blood";
    }

    @Override
    public String getDescription()
    {
        return "All your stats are increased by 5% and Aspect of the Dragons ability deals 50% more Ability Damage.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet()
    {
        return SuperiorDragonHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate()
    {
        return SuperiorDragonChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings()
    {
        return SuperiorDragonLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots()
    {
        return SuperiorDragonBoots.class;
    }

    @Override
    public PlayerBoostStatistics whileHasFullSet(Player player)
    {
        return new PlayerBoostStatistics()
        {
            @Override
            public double getBaseSpeed()
            {
                return 0.006;
            }

            @Override
            public double getBaseHealth()
            {
                return 23;
            }

            @Override
            public double getBaseStrength()
            {
                return 2;
            }

            @Override
            public double getBaseCritDamage()
            {
                return 0.02;
            }

            @Override
            public double getBaseCritChance()
            {
                return 0.004;
            }

            @Override
            public double getBaseIntelligence()
            {
                return 5;
            }

            @Override
            public double getBaseDefense()
            {
                return 30;
            }

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
            public String getLore()
            {
                return null;
            }

            @Override
            public GenericItemType getType()
            {
                return null;
            }
        };
    }
}
