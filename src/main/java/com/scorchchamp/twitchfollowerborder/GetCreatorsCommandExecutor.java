package com.scorchchamp.twitchfollowerborder;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GetCreatorsCommandExecutor implements CommandExecutor {
	private final TwitchFollowerBorder plugin;

	public GetCreatorsCommandExecutor(TwitchFollowerBorder plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		Runnable runGetCreators = new Runnable() {
			public void run() {
				List<String> creators = plugin.getConfig().getStringList("streamer_names");

				sender.sendMessage("[ScorchBorder] Creators:");
				for (String creator : creators) {
					sender.sendMessage(creator);
				}
			}
		};
		new Thread(runGetCreators).start();
		return true;
	}
}