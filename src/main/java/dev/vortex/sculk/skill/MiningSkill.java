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
import java.util.Arrays;
import java.util.List;
import org.bukkit.ChatColor;

public class MiningSkill extends Skill {
	public static final MiningSkill INSTANCE = new MiningSkill();

	@Override
	public String getName() {
		return "Mining";
	}

	@Override
	public String getAlternativeName() {
		return "Spelunker";
	}

	@Override
	public List<String> getDescription() {
		return Arrays.asList("Spelunk islands for ores and", "valuable materials to earn", "Mining XP!");
	}

	public double getDoubleDropChance(int level) {
		return (level * 4.0) / 100.0;
	}

	public double getTripleDropChance(int level) {
		return ((level - 25.0) * 4.0) / 100.0;
	}

	public double getDefense(int level) {
		return level < 15.0 ? level : level + (level - 14.0);
	}

	@Override
	public List<String> getLevelUpInformation(int level, int lastLevel, boolean showOld) {
		String dropChance = (showOld ? ChatColor.DARK_GRAY + "" + lastLevel * 4 + "➜" : "") + ChatColor.GREEN
				+ level * 4;
		if (level > 25) {
			dropChance = (showOld ? ChatColor.DARK_GRAY + "" + (lastLevel - 25) * 4 + "➜" : "") + ChatColor.GREEN
					+ (level - 25) * 4;
		}
		return Arrays.asList(ChatColor.WHITE + " Grants " + dropChance + "%" + ChatColor.WHITE + " chance",
				ChatColor.WHITE + " to drop " + (level > 25 ? "3" : "2") + "x ores.", ChatColor.DARK_GRAY + "+"
						+ ChatColor.GREEN + (level >= 15 ? "2" : "1") + " " + ChatColor.GREEN + "❈ Defense");
	}

	@Override
	public boolean hasSixtyLevels() {
		return true;
	}

	@Override
	public void onSkillUpdate(User user, double previousXP) {
		super.onSkillUpdate(user, previousXP);
		PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(user.getUuid());
		statistics.zeroAll(PlayerStatistic.MINING);
		statistics.getDefense().set(PlayerStatistic.MINING,
				getDefense(getLevel(user.getSkillXP(this), hasSixtyLevels())));
	}
}
