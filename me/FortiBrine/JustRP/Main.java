package me.FortiBrine.JustRP;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import me.FortiBrine.JustRP.commands.Commands;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
		File config = new File(getDataFolder()+File.separator+"config.yml");
		if (!config.exists()) {
			getConfig().options().copyDefaults(true);
			saveDefaultConfig();
		}
		
		getCommand("me").setExecutor(new Commands(this));
		getCommand("do").setExecutor(new Commands(this));
		getCommand("n").setExecutor(new Commands(this));
	}
}
