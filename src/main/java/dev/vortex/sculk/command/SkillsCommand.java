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
package dev.vortex.sculk.command;

import dev.vortex.sculk.skill.Skill;
import org.bukkit.command.ConsoleCommandSender;

@CommandParameters(description = "Shows your skills.", aliases = "skill", permission = "spt.skills")
public class SkillsCommand extends SCommand {
	@Override
	public void run(CommandSource sender, String[] args) {
		if (args.length != 0) {
			throw new CommandArgumentException();
		}
		if (sender instanceof ConsoleCommandSender) {
			throw new CommandFailException("Console senders cannot use this command!");
		}
		send("Skills:");
		for (Skill skill : Skill.getSkills())
			send(" - " + skill.getName() + ": LVL "
					+ Skill.getLevel(sender.getUser().getSkillXP(skill), skill.hasSixtyLevels()) + ", "
					+ sender.getUser().getSkillXP(skill) + " XP");
	}
}
