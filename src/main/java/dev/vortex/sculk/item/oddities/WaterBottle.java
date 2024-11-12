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
package dev.vortex.sculk.item.oddities;

import dev.vortex.sculk.item.*;
import dev.vortex.sculk.potion.PotionEffect;
import dev.vortex.sculk.potion.PotionEffectType;
import dev.vortex.sculk.util.SUtil;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class WaterBottle implements MaterialStatistics, MaterialFunction, ItemData
{
    @Override
    public NBTTagCompound getData()
    {
        NBTTagCompound compound = new NBTTagCompound();
        compound.setBoolean("splash", false);
        return compound;
    }

    @Override
    public String getDisplayName()
    {
        return "Water Bottle";
    }

    @Override
    public Rarity getRarity()
    {
        return Rarity.COMMON;
    }

    @Override
    public GenericItemType getType()
    {
        return GenericItemType.ITEM;
    }

    @Override
    public List<String> getDataLore(String key, Object value)
    {
        if (!key.equals("effects")) return null;
        NBTTagCompound compound = (NBTTagCompound) value;
        List<String> lore = new ArrayList<>();
        for (String k : compound.c())
        {
            lore.add(" ");
            NBTTagCompound effectData = compound.getCompound(k);
            PotionEffectType type = PotionEffectType.getByNamespace(k);
            int level = effectData.getInt("level");
            long duration = effectData.getLong("duration");
            PotionEffect effect = new PotionEffect(type, level, duration);
            lore.add(type.getName() + " " + SUtil.toRomanNumeral(effect.getLevel()) +
                    (!effect.getType().isInstant() ? ChatColor.WHITE + " (" + effect.getDurationDisplay() + ")" : ""));
            for (String line : SUtil.splitByWordAndLength(effect.getDescription(), 30, "\\s"))
                lore.add(ChatColor.GRAY + line);
        }
        return lore;
    }

    @Override
    public void onInstanceUpdate(SItem instance)
    {
        int max = 0;
        for (PotionEffect effect : instance.getPotionEffects())
        {
            if (effect.getLevel() > max)
                max = effect.getLevel();
        }
        instance.setRarity(SUtil.findPotionRarity(max), false);
        if (instance.getPotionEffects().size() == 1)
            instance.setDisplayName(ChatColor.stripColor(instance.getPotionEffects().getFirst().getType().getName() + " " +
                    SUtil.toRomanNumeral(instance.getPotionEffects().getFirst().getLevel())) + (instance.isSplashPotion() ? " Splash" : "") + " Potion");
        if (instance.getPotionEffects().size() > 1)
            instance.setDisplayName((instance.isSplashPotion() ? "Splash " : "") + "Potion");
        if (instance.getPotionEffects().size() == 0)
            instance.setDisplayName("Water Bottle");
    }
}