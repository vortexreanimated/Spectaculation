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
package dev.vortex.sculk.entity.wolf;

import dev.vortex.sculk.entity.EntityDrop;
import dev.vortex.sculk.entity.EntityDropType;
import dev.vortex.sculk.item.SItem;
import dev.vortex.sculk.item.SMaterial;
import dev.vortex.sculk.util.SUtil;

import java.util.Collections;
import java.util.List;

public class SvenAlpha extends BaseWolf
{
    @Override
    public String getEntityName()
    {
        return "Sven Alpha";
    }

    @Override
    public double getEntityMaxHealth()
    {
        return 480000.0;
    }

    @Override
    public double getDamageDealt()
    {
        return 1300.0;
    }

    @Override
    public List<EntityDrop> drops()
    {
        return Collections.singletonList(new EntityDrop(SUtil.setStackAmount(SItem.of(SMaterial.WOLF_TOOTH).getStack(), 5), EntityDropType.GUARANTEED, 1.0));
    }

    @Override
    public double getXPDropped()
    {
        return 500.0;
    }

    @Override
    public boolean isAngry()
    {
        return true;
    }
}
