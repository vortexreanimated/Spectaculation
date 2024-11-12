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

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;

public class IntegerPlayerStatistic implements PlayerStatistic<Integer>
{
    @Getter
    private final int defaultValue;
    private final ArrayList<Integer> values;

    public IntegerPlayerStatistic(int defaultValue)
    {
        this.defaultValue = defaultValue;
        this.values = new ArrayList<>(6);
        this.values.addAll(Arrays.asList(0, 0, 0, 0, 0, 0));
    }

    public IntegerPlayerStatistic()
    {
        this(0);
    }

    public Integer addAll()
    {
        int result = defaultValue;
        for (Integer value : new ArrayList<>(values))
            result += value;
        return result;
    }

    public void add(int slot, Integer i)
    {
        set(slot, safeGet(slot) + i);
    }

    public void sub(int slot, Integer i)
    {
        set(slot, safeGet(slot) - i);
    }

    public void zero(int slot)
    {
        set(slot, 0);
    }

    public boolean contains(int slot)
    {
        return slot >= 0 && slot < values.size();
    }

    public Integer safeGet(int index)
    {
        if (index < 0 || index > values.size() - 1) set(index, 0);
        return values.get(index);
    }

    public void set(int slot, Integer i)
    {
        values.ensureCapacity(slot + 1);
        while (values.size() < slot + 1)
            values.add(0);
        values.set(slot, i);
    }

    public int next()
    {
        return values.size();
    }

    public Integer getFor(int slot)
    {
        return safeGet(slot);
    }

    public ArrayList<Integer> forInventory()
    {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 6; i < values.size(); i++)
            list.add(safeGet(i));
        return list;
    }
}