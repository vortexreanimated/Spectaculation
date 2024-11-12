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

import net.minecraft.server.v1_8_R3.ItemStack;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

@CommandParameters(description = "Gets the NBT of your current item.", permission = "spt.item")
public class NBTCommand extends SCommand
{
    @Override
    public void run(CommandSource sender, String[] args)
    {
        if (args.length != 0) {
            throw new CommandArgumentException();
        }
        if (sender instanceof ConsoleCommandSender) {
            throw new CommandFailException("Console senders cannot use this command!");
        }
        Player player = sender.getPlayer();
        PlayerInventory inv = player.getInventory();
        ItemStack stack = CraftItemStack.asNMSCopy(inv.getItemInHand());
        if (inv.getItemInHand() == null) {
            throw new CommandFailException("Get an item in your hand!");
        }
        NBTTagCompound compound = stack.getTag();
        if (compound == null) {
            throw new CommandFailException("This item does not have any NBT data!");
        }
        send(ChatColor.GREEN + "NBT >");
        for (String key : compound.c())
            send(ChatColor.YELLOW + key + ChatColor.GREEN + ": " + ChatColor.RESET + compound.get(key).toString().replaceAll("§", "&"));
    }
}
