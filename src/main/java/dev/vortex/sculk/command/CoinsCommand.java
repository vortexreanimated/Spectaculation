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

import dev.vortex.sculk.user.User;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.command.ConsoleCommandSender;

@CommandParameters(description = "Modify your coin amount.", permission = "spt.balance")
public class CoinsCommand extends SCommand
{
    @Override
    public void run(CommandSource sender, String[] args)
    {
        if (args.length != 0 && args.length != 2) throw new CommandArgumentException();
        if (sender instanceof ConsoleCommandSender) throw new CommandFailException("Console senders cannot use this command!");
        User user = sender.getUser();
        if (args.length == 0)
        {
            user.setPermanentCoins(!user.isPermanentCoins());
            send("Your coins are no" + (user.isPermanentCoins() ? "w" : " longer") + " permanent.");
            return;
        }
        long coins = Long.parseLong(args[1]);
        switch (args[0].toLowerCase())
        {
            case "add":
            {
                user.addCoins(coins);
                send("You have added " + SUtil.commaify(coins) + " to your purse.");
                return;
            }
            case "subtract":
            case "sub":
            {
                user.subCoins(coins);
                send("You have subtracted " + SUtil.commaify(coins) + " from your purse.");
                return;
            }
            case "set":
            {
                user.setCoins(coins);
                send("You have set your purse coins to " + SUtil.commaify(coins) + ".");
                return;
            }
        }
        throw new CommandArgumentException();
    }
}
