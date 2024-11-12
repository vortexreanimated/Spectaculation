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

public class CombatSkill extends Skill
{
    public static final CombatSkill INSTANCE = new CombatSkill();

    @Override
    public String getName()
    {
        return "Combat";
    }

    @Override
    public String getAlternativeName()
    {
        return "Warrior";
    }

    @Override
    public List<String> getDescription()
    {
        return Arrays.asList("Fight mobs and players to earn", "Combat XP!");
    }

    @Override
    public List<String> getLevelUpInformation(int level, int lastLevel, boolean showOld)
    {
        return Arrays.asList(ChatColor.WHITE + " Deal " + (showOld ? ChatColor.DARK_GRAY + "" + lastLevel * 4 + "➜" : "")
                + ChatColor.GREEN + level * 4 + "% " + ChatColor.WHITE
                + "more damage to mobs.",
                ChatColor.DARK_GRAY + "+" + ChatColor.GREEN + "0.5% " + ChatColor.BLUE + "☣ Crit Chance");
    }

    @Override
    public boolean hasSixtyLevels()
    {
        return false;
    }

    @Override
    public void onSkillUpdate(User user, double previousXP)
    {
        super.onSkillUpdate(user, previousXP);
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(user.getUuid());
        statistics.zeroAll(PlayerStatistic.COMBAT);
        statistics.getCritChance().set(PlayerStatistic.COMBAT, 0.005 * getLevel(user.getCombatXP(), false));
    }
}
