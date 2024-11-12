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

import dev.vortex.sculk.collection.ItemCollection;
import dev.vortex.sculk.user.User;
import dev.vortex.sculk.util.SUtil;
import org.bukkit.command.ConsoleCommandSender;

@CommandParameters(description = "Modify your collections.", permission = "spt.collection")
public class CollectionsCommand extends SCommand {
	@Override
	public void run(CommandSource sender, String[] args) {
		if (args.length != 3) {
			throw new CommandArgumentException();
		}
		if (sender instanceof ConsoleCommandSender) {
			throw new CommandFailException("Console senders cannot use this command!");
		}
		ItemCollection collection = ItemCollection.getByIdentifier(args[0]);
		if (collection == null) {
			throw new CommandFailException("Could not find the specified collection!");
		}
		User user = sender.getUser();
		int amount = Integer.parseInt(args[2]);
		switch (args[1].toLowerCase()) {
			case "add" : {
				user.addToCollection(collection, amount);
				send("You have added " + SUtil.commaify(amount) + " to your " + collection.getName() + " collection.");
				return;
			}
			case "subtract" :
			case "sub" : {
				user.setCollection(collection, user.getCollection(collection) - amount);
				send("You have subtracted " + SUtil.commaify(amount) + " from your " + collection.getName()
						+ " collection.");
				return;
			}
			case "set" : {
				user.setCollection(collection, amount);
				send("You have set your " + collection.getName() + " collection to " + SUtil.commaify(amount) + ".");
				return;
			}
		}
		throw new CommandArgumentException();
	}
}
