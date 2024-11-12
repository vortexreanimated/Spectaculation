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
import dev.vortex.sculk.reforge.Reforge;
import dev.vortex.sculk.reforge.ReforgeType;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

@CommandParameters(description = "Reforge an item from Spec.", aliases = "sref", permission = "spt.item")
public class SpecReforgeCommand extends SCommand
{
    @Override
    public void run(CommandSource sender, String[] args)
    {
        if (args.length != 1) {
            throw new CommandArgumentException();
        }
        if (sender instanceof ConsoleCommandSender) {
            throw new CommandFailException("Console senders cannot use this command!");
        }
        Player player = sender.getPlayer();
        ItemStack stack = player.getInventory().getItemInHand();
        if (stack == null) {
            throw new CommandFailException("You don't have anything in your hand!");
        }
        SItem sItem = SItem.find(stack);
        if (sItem == null) {
            throw new CommandFailException("That item is not from Spec!");
        }
        Reforge reforge = ReforgeType.getReforgeType(args[0]).getReforge();
        sItem.setReforge(reforge);
        send("Your " + sItem.getType().getDisplayName(sItem.getVariant()) + " now has " + reforge.getName() + " on it.");
    }
}
