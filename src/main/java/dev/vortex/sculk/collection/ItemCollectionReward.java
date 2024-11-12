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

import org.bukkit.entity.Player;

public abstract class ItemCollectionReward
{
    private final Type type;

    protected ItemCollectionReward(Type type)
    {
        this.type = type;
    }

    public abstract void onAchieve(Player player);
    public abstract String toRewardString();

    protected enum Type
    {
        RECIPE,
        UPGRADE,
        EXPERIENCE
    }
}
