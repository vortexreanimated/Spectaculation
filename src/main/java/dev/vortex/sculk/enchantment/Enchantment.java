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
package dev.vortex.sculk.enchantment;

import dev.vortex.sculk.util.SUtil;
import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Enchantment implements ConfigurationSerializable
{
    private final EnchantmentType type;
    private final int level;

    public Enchantment(EnchantmentType type, int level)
    {
        this.type = type;
        this.level = level;
    }

    @Override
    public String toString()
    {
        return type.getName() + " " + (level <= 3000 ? SUtil.toRomanNumeral(level) : level);
    }

    public String getDisplayName()
    {
        return (!type.isUltimate() ? ChatColor.BLUE : "" + ChatColor.LIGHT_PURPLE + ChatColor.BOLD) + toString();
    }

    public String toIdentifiableString()
    {
        return type.getNamespace() + "." + level;
    }

    public String getDescription()
    {
        if (type == EnchantmentType.SHARPNESS) {
            return type.getDescription(5 * level);
        }
        if (type == EnchantmentType.FIRE_ASPECT) {
            return type.getDescription(2 + level);
        }
        if (type == EnchantmentType.GROWTH) {
            return type.getDescription(15 * level);
        }
        if (type == EnchantmentType.AIMING) {
            return type.getDescription(2 * level);
        }
        if (type == EnchantmentType.POWER || type == EnchantmentType.SMITE || type == EnchantmentType.BANE_OF_ARTHROPODS) {
            return type.getDescription(8 * level);
        }
        if (type == EnchantmentType.ULTIMATE_WISE || type == EnchantmentType.CRITICAL) {
            return type.getDescription(10 * level);
        }
        if (type == EnchantmentType.HARVESTING) {
            return type.getDescription(SUtil.commaify(12.5 * level));
        }
        return type.getDescription();
    }

    public static Enchantment getByIdentifiable(String identifiable)
    {
        String[] spl = identifiable.split("\\.");
        return new Enchantment(EnchantmentType.getByNamespace(spl[0]), Integer.parseInt(spl[1]));
    }

    public boolean equalsType(Enchantment enchantment)
    {
        return enchantment.type.equals(type);
    }

    @Override
    public boolean equals(Object o)
    {
        if (!(o instanceof Enchantment)) {
            return false;
        }
        Enchantment enchantment = (Enchantment) o;
        return enchantment.level == level && enchantment.type.equals(type);
    }

    @Override
    public Map<String, Object> serialize()
    {
        Map<String, Object> map = new HashMap<>();
        map.put("type", type.getNamespace());
        map.put("level", level);
        return null;
    }
}
