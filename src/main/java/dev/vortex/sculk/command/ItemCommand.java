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
import dev.vortex.sculk.item.SMaterial;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

@CommandParameters(description = "Gives an item from Spec.", aliases = "sitem,specitem", permission = "spt.item")
public class ItemCommand extends SCommand
{
    @Override
    public void run(CommandSource sender, String[] args)
    {
        if (args.length < 1 || args.length > 2) {
            throw new CommandArgumentException();
        }
        if (sender instanceof ConsoleCommandSender) {
            throw new CommandFailException("Console senders cannot use this command!");
        }
        Player player = sender.getPlayer();
        SMaterial material = SMaterial.getMaterial(args[0]);
        if (material == null) {
            throw new CommandFailException("Invalid material.");
        }
        PlayerInventory inv = player.getInventory();
        if (inv.firstEmpty() == -1) {
            throw new CommandFailException("No inventory space.");
        }
        byte variant = 0;
        if (args.length == 2) {
            variant = Byte.parseByte(args[1]);
        }
        inv.setItem(inv.firstEmpty(), SItem.of(material, variant).getStack());
        send("You have received a(n) " + material.getDisplayName(variant));
    }
}
