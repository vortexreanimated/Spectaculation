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

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;

public class ItemCollectionRewards extends ArrayList<ItemCollectionReward>
{
    @Getter
    private final int requirement;

    public ItemCollectionRewards(int requirement, ItemCollectionReward... rewards)
    {
        super(Arrays.asList(rewards));
        this.requirement = requirement;
    }
}
