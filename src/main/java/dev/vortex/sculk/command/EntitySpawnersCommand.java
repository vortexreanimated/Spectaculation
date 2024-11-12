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

import dev.vortex.sculk.entity.EntitySpawner;
import dev.vortex.sculk.entity.SEntityType;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.List;

@CommandParameters(description = "Manage entity spawners.", usage = "/<command> [create <type> | delete <index>]", aliases = "entityspawner,es,spawner,spawners", permission = "spt.entity")
public class EntitySpawnersCommand extends SCommand
{
    @Override
    public void run(CommandSource sender, String[] args)
    {
        if (sender instanceof ConsoleCommandSender) throw new CommandFailException("Console senders cannot use this command!");
        Player player = sender.getPlayer();
        if (args.length == 0)
        {
            StringBuilder builder = new StringBuilder("Spawners:");
            List<EntitySpawner> spawners = EntitySpawner.getSpawners();
            for (int i = 0; i < spawners.size(); i++)
            {
                EntitySpawner spawner = spawners.get(i);
                builder.append("\n ").append(i + 1).append(": ").append(SUtil.prettify(spawner.getLocation()))
                        .append(" (").append(spawner.getType().name()).append(")");
            }
            send(builder.toString());
            return;
        }
        if (args.length != 2) throw new CommandArgumentException();
        switch (args[0].toLowerCase())
        {
            case "create":
            {
                SEntityType type = SEntityType.getEntityType(args[1]);
                if (type == null)
                    throw new CommandFailException("That is not a valid entity type!");
                EntitySpawner spawner = new EntitySpawner(type, player.getLocation());
                send("New entity spawner has been created at " + SUtil.prettify(spawner.getLocation()) + " with the type " + spawner.getType().getGenericInstance());
                break;
            }
            case "delete":
            {
                int index = Integer.parseInt(args[1]) - 1;
                List<EntitySpawner> spawners = EntitySpawner.getSpawners();
                if (index < 0 || index > spawners.size() - 1)
                    throw new CommandFailException("There is no spawner at that location!");
                spawners.remove(index).delete();
                send("Entity spawner deleted.");
                break;
            }
        }
    }
}
