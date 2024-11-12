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

import dev.vortex.sculk.item.SItem;
import net.minecraft.server.v1_8_R3.ItemStack;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

@CommandParameters(description = "Sets data for a Spec item.", permission = "spt.item")
public class DataCommand extends SCommand
{
    @Override
    public void run(CommandSource sender, String[] args)
    {
        if (args.length < 3) {
            throw new CommandArgumentException();
        }
        if (sender instanceof ConsoleCommandSender) {
            throw new CommandFailException("Console senders cannot use this command!");
        }
        Player player = sender.getPlayer();
        PlayerInventory inv = player.getInventory();
        if (inv.getItemInHand() == null) {
            throw new CommandFailException("Get an item in your hand!");
        }
        SItem sItem = SItem.find(inv.getItemInHand());
        String key = args[0];
        if (!sItem.hasDataFor(key)) {
            throw new CommandFailException("This item does not have data for '" + key + "'");
        }
        String joined = StringUtils.join(args, " ", 1, args.length - 1);
        switch (args[args.length - 1].toLowerCase())
        {
            case "string":
            {
                sItem.setDataString(key, joined);
                break;
            }
            case "integer":
            case "int":
            {
                sItem.setDataInt(key, Integer.parseInt(joined));
                break;
            }
            case "long":
            {
                sItem.setDataLong(key, Long.parseLong(joined));
                break;
            }
            case "boolean":
            case "bool":
            {
                sItem.setDataBoolean(key, Boolean.parseBoolean(joined));
                break;
            }
            case "double":
            case "d":
            {
                sItem.setDataDouble(key, Double.parseDouble(joined));
                break;
            }
            case "float":
            case "f":
            {
                sItem.setDataFloat(key, Float.parseFloat(joined));
                break;
            }
        }
        sItem.update();
        send("'" + key + "' for this item has been set to '" + joined + "' as type '" + args[args.length - 1].toLowerCase() + "'");
    }
}
