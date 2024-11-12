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

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

@CommandParameters(description = "Play a Bukkit enum sound.", usage = "/playenumsound <sound>")
public class PlayEnumSoundCommand extends SCommand
{
    @Override
    public void run(CommandSource sender, String[] args)
    {
        if (args.length < 1 || args.length > 4) throw new CommandArgumentException();
        if (sender instanceof ConsoleCommandSender) throw new CommandFailException("Console senders cannot use this command!");
        Player player = sender.getPlayer();
        Sound sound = Sound.valueOf(args[0].toUpperCase());
        float volume = 1.0f, pitch = 1.0f;
        int times = 1;
        if (args.length >= 2)
            volume = Float.parseFloat(args[1]);
        if (args.length >= 3)
            pitch = Float.parseFloat(args[2]);
        if (args.length == 4)
            times = Integer.parseInt(args[3]);
        for (int i = 0; i < times; i++)
            player.playSound(player.getLocation(), sound, volume, pitch);
        player.sendMessage(ChatColor.GRAY + "Played " + sound.name() + ".");
    }
}