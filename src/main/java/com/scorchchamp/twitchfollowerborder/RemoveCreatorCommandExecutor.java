package com.scorchchamp.twitchfollowerborder;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RemoveCreatorCommandExecutor implements CommandExecutor {
	private final TwitchFollowerBorder plugin;

	public RemoveCreatorCommandExecutor(TwitchFollowerBorder plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		Runnable runRemoveCreator = new Runnable() {
			public void run() {
				List<String> creators = plugin.getConfig().getStringList("streamer_names");
				creators.remove(args[0]);
				plugin.getConfig().set("streamer_names", creators);
				plugin.saveConfig();
				sender.sendMessage("[ScorchBorder] Removed from the creator-list: " + args[0]);
			}
		};
		new Thread(runRemoveCreator).start();
		return true;
	}
}