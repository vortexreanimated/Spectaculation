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
package dev.vortex.sculk.item.mining;

import dev.vortex.sculk.item.ExperienceRewardStatistics;
import dev.vortex.sculk.item.GenericItemType;
import dev.vortex.sculk.item.MaterialFunction;
import dev.vortex.sculk.item.Rarity;
import dev.vortex.sculk.skill.MiningSkill;
import dev.vortex.sculk.skill.Skill;

public class Gravel implements ExperienceRewardStatistics, MaterialFunction {
	@Override
	public double getRewardXP() {
		return 4.0;
	}

	@Override
	public Skill getRewardedSkill() {
		return MiningSkill.INSTANCE;
	}

	@Override
	public String getDisplayName() {
		return "Sand";
	}

	@Override
	public Rarity getRarity() {
		return Rarity.COMMON;
	}

	@Override
	public GenericItemType getType() {
		return GenericItemType.ITEM;
	}
}
