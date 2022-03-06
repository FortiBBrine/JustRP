package me.FortiBrine.JustRP.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.FortiBrine.JustRP.Main;

public class Commands implements CommandExecutor {
	
	private Main plugin;
	public Commands(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length < 1) return false;
		if (!(sender instanceof Player)) return false;
		Player p = (Player) sender;
		Location loc = p.getLocation();
		
		String msg = "";
		for (String s : args) msg += s + " ";
		msg = msg.trim();
		
		String answer = plugin.getConfig().getString(cmd.getName()+".answer");
		answer = answer.replace("&", "§");
		answer = answer.replace("%name", p.getDisplayName());
		answer = answer.replace("%player", p.getName());
		answer = answer.replace("%message", msg);
		
		int distance = plugin.getConfig().getInt(cmd.getName()+".distance");
		
		for (Player player : Bukkit.getOnlinePlayers()) {
			Location location = player.getLocation();
			
			if (loc.distance(location) <= distance) {
				p.sendMessage(answer);
			}
		}
		
		return true;
		
	}
}
