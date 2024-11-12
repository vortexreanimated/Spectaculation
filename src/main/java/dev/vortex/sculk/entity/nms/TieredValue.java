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
package dev.vortex.sculk.entity.nms;

public class TieredValue<T>
{
    private final T i;
    private final T ii;
    private final T iii;
    private final T iv;

    public TieredValue(T i, T ii, T iii, T iv)
    {
        this.i = i;
        this.ii = ii;
        this.iii = iii;
        this.iv = iv;
    }

    public T getByNumber(int n)
    {
        switch (n)
        {
            case 2: return ii;
            case 3: return iii;
            case 4: return iv;
            default: return i;
        }
    }

    public T getTierI()
    {
        return i;
    }

    public T getTierII()
    {
        return ii;
    }

    public T getTierIII()
    {
        return iii;
    }

    public T getTierIV()
    {
        return iv;
    }
}