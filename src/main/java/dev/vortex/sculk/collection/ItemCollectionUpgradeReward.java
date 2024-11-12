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
package dev.vortex.sculk.collection;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ItemCollectionUpgradeReward extends ItemCollectionReward
{
    private final String name;
    private final ChatColor color;

    public ItemCollectionUpgradeReward(String name, ChatColor color)
    {
        super(Type.UPGRADE);
        this.name = name;
        this.color = color;
    }

    public String toRewardString()
    {
        return color + name + " Upgrade";
    }

    @Override
    public void onAchieve(Player player) {} // no immediate rewards
}