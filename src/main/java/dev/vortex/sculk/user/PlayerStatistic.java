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
package dev.vortex.sculk.user;

public interface PlayerStatistic<T>
{
    int HELMET = 0, CHESTPLATE = 1, LEGGINGS = 2, BOOTS = 3, HAND = 4, SET = 5, BOOST = 6, PET = 7, MINER_BUFF = 8, OBSIDIAN_CHESTPLATE = 9,
            FARMING = 10, MINING = 11, COMBAT = 12, FORAGING = 13, ADD_FOR_INVENTORY = 14, ADD_FOR_POTION_EFFECTS = 51;

    T addAll();
    void add(int slot, T t);
    void sub(int slot, T t);
    void zero(int slot);
    boolean contains(int slot);
    T safeGet(int index);
    void set(int slot, T t);
    int next();
    T getFor(int slot);
}
