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

import dev.vortex.sculk.auction.AuctionItem;
import dev.vortex.sculk.gui.AuctionViewGUI;
import dev.vortex.sculk.user.User;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;

import java.util.List;
import java.util.UUID;

@CommandParameters(description = "Modify your coin amount.", usage = "/<command> <auction uuid/player name>", aliases = "auction,ah")
public class AuctionHouseCommand extends SCommand
{
    @Override
    public void run(CommandSource sender, String[] args)
    {
        if (args.length != 1) throw new CommandArgumentException();
        if (sender instanceof ConsoleCommandSender) throw new CommandFailException("Console senders cannot use this command!");
        try
        {
            UUID uuid = UUID.fromString(args[0]);
            AuctionItem item = AuctionItem.getAuction(uuid);
            if (item == null)
                throw new IllegalArgumentException();
            new AuctionViewGUI(item).open(sender.getPlayer());
        }
        catch (IllegalArgumentException ex)
        {
            List<AuctionItem> items = AuctionItem.getOwnedAuctions(args[0]);
            if (items == null)
                throw new CommandFailException("This player has no auctions!");
            send(ChatColor.RED + "This feature is not complete yet!");
        }
    }
}
