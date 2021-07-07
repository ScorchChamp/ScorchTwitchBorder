package com.scorchchamp.twitchfollowerborder;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public final class TwitchFollowerBorder extends JavaPlugin {
	@Override
	public void onEnable() {
		final TwitchFollowerBorder plugin = this;
		getLogger().info("ScorchBorder has been enabled!");
		this.saveDefaultConfig();
		this.getCommand("updateBorder").setExecutor(new UpdateBorderCommandExecutor(this));
		this.getCommand("addCreator").setExecutor(new AddCreatorCommandExecutor(this));
		this.getCommand("removeCreator").setExecutor(new RemoveCreatorCommandExecutor(this));
		this.getCommand("getCreators").setExecutor(new GetCreatorsCommandExecutor(this));

		BukkitScheduler scheduler = getServer().getScheduler();
		final int update_delay = Integer.parseInt(plugin.getConfig().getString("twitch-update-delay-ticks"));
		scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
			public void run() {
				ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
				Bukkit.dispatchCommand(console, "updateborder");
				for (World w : Bukkit.getServer().getWorlds()) {
					WorldBorder overworldBorder = w.getWorldBorder();
					int border_size = Integer.parseInt(plugin.getConfig().getString("current-border-size"));
					overworldBorder.setSize(border_size, update_delay / 20);
				}
			}
		}, 0L, update_delay);
	}

	@Override
	public void onDisable() {
		getLogger().info("ScorchBorder has been disabled!");
	}
}