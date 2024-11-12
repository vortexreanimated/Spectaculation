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
package dev.vortex.sculk.skill;

import dev.vortex.sculk.user.PlayerStatistic;
import dev.vortex.sculk.user.PlayerStatistics;
import dev.vortex.sculk.user.PlayerUtils;
import dev.vortex.sculk.user.User;
import org.bukkit.ChatColor;

import java.util.Arrays;
import java.util.List;

public class FarmingSkill extends Skill
{
    public static final FarmingSkill INSTANCE = new FarmingSkill();

    @Override
    public String getName()
    {
        return "Farming";
    }

    @Override
    public String getAlternativeName()
    {
        return "Farmhand";
    }

    @Override
    public List<String> getDescription()
    {
        return Arrays.asList("Harvest crops and shear sheep to", "earn Farming XP!");
    }

    public double getDoubleDropChance(int level)
    {
        return (level * 4.0) / 100.0;
    }

    public double getHealth(int level)
    {
        int health = level * 2;
        if (level >= 15) {
            health += level - 14;
        }
        if (level >= 20) {
            health += level - 19;
        }
        if (level >= 26) {
            health += level - 25;
        }
        return health;
    }

    @Override
    public List<String> getLevelUpInformation(int level, int lastLevel, boolean showOld)
    {
        String dropChance = (showOld ? ChatColor.DARK_GRAY + "" + lastLevel * 4 + "➜" : "") + ChatColor.GREEN + level * 4;
        int healthPlus = 2;
        if (level >= 15) {
            healthPlus = 3;
        }
        if (level >= 20) {
            healthPlus = 4;
        }
        if (level >= 26) {
            healthPlus = 5;
        }
        return Arrays.asList(ChatColor.WHITE + " Grants " + dropChance + "%" + ChatColor.WHITE + " chance",
                ChatColor.WHITE + " to drop 2x crops.", ChatColor.DARK_GRAY + "+"
                        + ChatColor.GREEN + healthPlus + " " + ChatColor.RED + "❤ Health");
    }

    @Override
    public boolean hasSixtyLevels()
    {
        return true;
    }

    @Override
    public void onSkillUpdate(User user, double previousXP)
    {
        super.onSkillUpdate(user, previousXP);
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(user.getUuid());
        statistics.zeroAll(PlayerStatistic.FARMING);
        statistics.getMaxHealth().set(PlayerStatistic.FARMING, getHealth(getLevel(user.getSkillXP(this), hasSixtyLevels())));
    }
}
