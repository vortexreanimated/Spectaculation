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

public class DoublePlayerStatistic implements PlayerStatistic<Double>
{
    @Getter
    private final double defaultValue;
    private final ArrayList<Double> values;

    public DoublePlayerStatistic(double defaultValue)
    {
        this.defaultValue = defaultValue;
        this.values = new ArrayList<>(6);
        this.values.addAll(Arrays.asList(0.0, 0.0, 0.0, 0.0, 0.0, 0.0));
    }

    public DoublePlayerStatistic()
    {
        this(0.0);
    }

    public Double addAll()
    {
        double result = defaultValue;
        for (Double value : values)
            result += value;
        return result;
    }

    public void add(int slot, Double d)
    {
        set(slot, safeGet(slot) + d);
    }

    public void sub(int slot, Double d)
    {
        set(slot, safeGet(slot) - d);
    }

    public void zero(int slot)
    {
        set(slot, 0.0);
    }

    public boolean contains(int slot)
    {
        return slot >= 0 && slot < values.size();
    }

    public Double safeGet(int index)
    {
        if (index < 0 || index > values.size() - 1) set(index, 0.0);
        return values.get(index);
    }

    public void set(int slot, Double d)
    {
        values.ensureCapacity(slot + 1);
        while (values.size() < slot + 1)
            values.add(0.0);
        values.set(slot, d);
    }

    public int next()
    {
        return values.size();
    }

    public Double getFor(int slot)
    {
        return safeGet(slot);
    }

    public ArrayList<Double> forInventory()
    {
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 6; i < values.size(); i++)
            list.add(safeGet(i));
        return list;
    }
}