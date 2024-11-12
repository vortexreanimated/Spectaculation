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

import dev.vortex.sculk.Spectaculation;
import dev.vortex.sculk.util.SUtil;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public abstract class SCommand implements CommandExecutor, TabCompleter {
	public static final String COMMAND_SUFFIX = "Command";
	protected static final Spectaculation plugin = Spectaculation.getPlugin();

	private final CommandParameters params;
	private final String name;
	private final String description;
	private final String usage;
	private final List<String> aliases;
	private final String permission;
	private final SECommand command;

	private CommandSource sender;

	protected SCommand() {
		this.params = this.getClass().getAnnotation(CommandParameters.class);
		this.name = this.getClass().getSimpleName().replace(COMMAND_SUFFIX, "").toLowerCase();
		this.description = this.params.description();
		this.usage = this.params.usage();
		this.aliases = Arrays.asList(this.params.aliases().split(","));
		this.permission = this.params.permission();
		this.command = new SECommand(this);
	}

	public abstract void run(CommandSource sender, String[] args);

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return null;
	}

	public void register() {
		plugin.commandMap.register("", this.command);
	}

	private static class SECommand extends Command {
		private final SCommand sc;

		public SECommand(SCommand xc) {
			super(xc.name, xc.description, xc.usage, xc.aliases);
			this.setPermission(xc.permission);
			this.setPermissionMessage(ChatColor.RED + "No permission. You need \"" + xc.permission + "\"");
			this.sc = xc;
		}

		@Override
		public boolean execute(CommandSender sender, String commandLabel, String[] args) {
			sc.sender = new CommandSource(sender);
			try {
				sc.run(sc.sender, args);
				return true;
			} catch (CommandFailException | CommandPermissionException | PlayerNotFoundException ex) {
				sender.sendMessage(ex.getMessage());
				return true;
			} catch (CommandArgumentException ex) {
				return false;
			} catch (Exception ex) {
				sender.sendMessage(ChatColor.RED + "Error: " + ex.getMessage());
				ex.printStackTrace();
				return true;
			}
		}

		@Override
		public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
			List<String> tc = sc.onTabComplete(sender, this, alias, args);
			if (tc != null) {
				return tc;
			}
			return SUtil.getPlayerNameList();
		}
	}

	public void send(String message, CommandSource sender) {
		sender.send(ChatColor.GRAY + message);
	}

	public void send(String message) {
		send(message, sender);
	}

	public void send(String message, Player player) {
		player.sendMessage(ChatColor.GRAY + message);
	}

	public void checkPermission(String permission) {
		if (!sender.getSender().hasPermission(permission)) {
			throw new CommandPermissionException(permission);
		}
	}

	public Player getNonNullPlayer(String name) {
		Player player = Bukkit.getPlayer(name);
		if (player == null) {
			throw new PlayerNotFoundException();
		}
		return player;
	}
}
