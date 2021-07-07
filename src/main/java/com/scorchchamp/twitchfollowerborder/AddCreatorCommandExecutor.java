package com.scorchchamp.twitchfollowerborder;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AddCreatorCommandExecutor implements CommandExecutor {
	private final TwitchFollowerBorder plugin;

	public AddCreatorCommandExecutor(TwitchFollowerBorder plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		Runnable runAddCreator = new Runnable() {
			public void run() {
				List<String> creators = plugin.getConfig().getStringList("streamer_names");
				creators.add(args[0]);

				plugin.getConfig().set("streamer_names", creators);
				plugin.saveConfig();

				sender.sendMessage("[ScorchBorder] Added to the creator-list: " + args[0]);
			}
		};
		new Thread(runAddCreator).start();
		return true;
	}
}