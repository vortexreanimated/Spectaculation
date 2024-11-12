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
package dev.vortex.sculk.sidebar;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.List;

public class Sidebar
{
    private static final ScoreboardManager manager = Bukkit.getScoreboardManager();

    private final String name;
    private final String identifier;

    private final Scoreboard board;
    private final Objective obj;
    private final List<Score> scores;

    public Sidebar(String name, String identifier)
    {
        this.name = name;
        this.identifier = identifier;
        this.board = manager.getNewScoreboard();
        this.obj = board.registerNewObjective(identifier, "");
        this.scores = new ArrayList<>();
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(name);
    }

    public void add(String s)
    {
        Score score = obj.getScore(s);
        scores.addFirst(score);
    }

    public void apply(Player player)
    {
        for (int i = 0; i < scores.size(); i++) {
            scores.get(i).setScore(i);
        }
        player.setScoreboard(board);
    }
}
