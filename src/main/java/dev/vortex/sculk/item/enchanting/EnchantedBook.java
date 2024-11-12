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
package dev.vortex.sculk.item.enchanting;

import dev.vortex.sculk.enchantment.Enchantment;
import dev.vortex.sculk.item.*;

public class EnchantedBook implements MaterialStatistics, MaterialFunction, Enchantable
{

    @Override
    public String getDisplayName()
    {
        return "Enchanted Book";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.COMMON;
    }

    @Override
    public String getLore()
    {
        return "Use this on an item in an Anvil to apply it!";
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ITEM;
    }

    @Override
    public void onInstanceUpdate(SItem instance)
    {
        int max = 1;
        for (Enchantment enchantment : instance.getEnchantments())
        {
            if (enchantment.getLevel() > max) {
                max = enchantment.getLevel();
            }
        }
        switch (max)
        {
            case 1:
            case 2:
            case 3:
            case 4:
                instance.setRarity(Rarity.COMMON, false);
                break;
            case 5:
                instance.setRarity(Rarity.UNCOMMON, false);
                break;
            case 6:
                instance.setRarity(Rarity.RARE, false);
                break;
            case 7:
                instance.setRarity(Rarity.EPIC, false);
                break;
            case 8:
                instance.setRarity(Rarity.LEGENDARY, false);
                break;
            case 9:
                instance.setRarity(Rarity.MYTHIC, false);
                break;
            default: // 10 and on
                instance.setRarity(Rarity.SUPREME, false);
                break;
        }
    }
}
