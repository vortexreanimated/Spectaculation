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
package dev.vortex.sculk.item.dragon.wise;

import dev.vortex.sculk.item.MaterialStatistics;
import dev.vortex.sculk.item.armor.ArmorSet;

public class WiseDragonSet implements ArmorSet
{
    @Override
    public String getName()
    {
        return "Wise Blood";
    }

    @Override
    public String getDescription()
    {
        return "All abilities cost 50% less Mana.";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet()
    {
        return WiseDragonHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate()
    {
        return WiseDragonChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings()
    {
        return WiseDragonLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots()
    {
        return WiseDragonBoots.class;
    }
}