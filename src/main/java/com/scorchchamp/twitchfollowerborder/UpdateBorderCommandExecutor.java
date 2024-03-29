package com.scorchchamp.twitchfollowerborder;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UpdateBorderCommandExecutor implements CommandExecutor {
	private final TwitchFollowerBorder plugin;

	public UpdateBorderCommandExecutor(TwitchFollowerBorder plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		Runnable runUpdateBorder = new Runnable() {
			public void run() {
				if (sender instanceof Player)
					sender.sendMessage("[ScorchBorder] Fetching data...");
				int total_followers = -1;
				List<String> streamers = plugin.getConfig().getStringList("streamer_names");
				for (String s : streamers) {
					int s_followers = Integer.parseInt(getStreamerFollows(s));
					total_followers += s_followers;
					if (sender instanceof Player)
						sender.sendMessage("[ScorchBorder] " + s + " has " + s_followers + " followers");
				}
				if (total_followers >= 0) {
					int last_border_size = Integer.parseInt(plugin.getConfig().getString("current-border-size"));
					int new_border_size = total_followers
							/ Integer.parseInt(plugin.getConfig().getString("followers-per-block"));
					if (sender instanceof Player)
						sender.sendMessage("[ScorchBorder] BorderSize: " + new_border_size);
					if (last_border_size != new_border_size) {
						plugin.getConfig().set("current-border-size", new_border_size);
						plugin.saveConfig();
						for (Player p : Bukkit.getServer().getOnlinePlayers()) {
							if (p.hasPermission("twitchfollowerborder.updateBorder"))
								p.sendMessage("[ScorchBorder] New follower count! Added blocks: "
										+ (new_border_size - last_border_size));
						}
					}
				} else {
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission("twitchfollowerborder.updateBorder"))
							p.sendMessage("[ScorchBorder] Something went wrong! Please report this!");
					}
				}

			}
		};
		new Thread(runUpdateBorder).start();
		return true;
	}

	public boolean runGetFollowers(CommandSender sender, String[] args) {
		String response;
		if (args.length > 0) {
			response = getStreamerFollows(args[0]);
		} else {
			response = "Please provide a name";
			return false;
		}
		sender.sendMessage(response);
		return true;
	}

	public String getStreamerFollows(String name) {
		String streamer_id = getStreamerID(name);
		String streamer_follows = null;
		if (streamer_id != "0") {
			String result = this
					.getTwitchAPIResult("https://api.twitch.tv/helix/users/follows?first=1&to_id=".concat(streamer_id));
			try {
				streamer_follows = result.split(":")[1].split(",")[0];
			} catch (ArrayIndexOutOfBoundsException e) {
				e.printStackTrace();
				return "-1";
			}
		} else {
			return "-1";
		}
		return streamer_follows;

	}

	public String getStreamerID(String name) {
		String result = "";
		result = this.getTwitchAPIResult("https://api.twitch.tv/helix/users?login=".concat(name));

		String streamer_id;
		try {
			streamer_id = result.split("id\":")[1].split("\"")[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			return "0";
		}
		return streamer_id;
	}

	public String getTwitchAPIResult(String url_string) {
		URL url = null;
		try {
			url = new URL(url_string);
		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		}
		StringBuilder result = new StringBuilder();
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestProperty("Authorization", plugin.getConfig().getString("Authorization"));
			http.setRequestProperty("Client-Id", plugin.getConfig().getString("Client-Id"));
			InputStream in = new BufferedInputStream(http.getInputStream());

			BufferedReader reader = new BufferedReader(new InputStreamReader(in));

			String line;
			while ((line = reader.readLine()) != null) {
				result.append(line);
			}
			http.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return "-1";
		} catch (IOException e) {
			e.printStackTrace();
			return "-1";
		}
		return result.toString();
	}
}