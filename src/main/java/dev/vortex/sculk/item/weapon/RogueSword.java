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
package dev.vortex.sculk.item.weapon;

import dev.vortex.sculk.item.*;
import dev.vortex.sculk.user.PlayerUtils;
import org.bukkit.entity.Player;

public class RogueSword implements ToolStatistics, MaterialFunction, Ability
{
    @Override
    public String getAbilityName()
    {
        return "Speed Boost";
    }

    @Override
    public String getAbilityDescription()
    {
        return "Increases your Speed by +20 for 30 seconds.";
    }

    @Override
    public void onAbilityUse(Player player, SItem sItem)
    {
        PlayerUtils.boostPlayer(PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId()), new PlayerBoostStatistics()
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
                return 0.2;
            }
        }, 20 * 30);
    }

    @Override
    public int getAbilityCooldownTicks()
    {
        return 0;
    }

    @Override
    public int getManaCost()
    {
        return 60;
    }

    @Override
    public String getDisplayName()
    {
        return "Rogue Sword";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType()
    {
        return SpecificItemType.SWORD;
    }

    @Override
    public int getBaseDamage()
    {
        return 20;
    }
}