package com.gmail.willou421.PluginWill;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FireworkCommandExecutor implements CommandExecutor {

	
	private PluginWill plugin; // pointer to your main class, unrequired if you don't need methods from the main class
	 
	public FireworkCommandExecutor(PluginWill plugin) {
		this.plugin = plugin;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		//set effect
		if (cmd.getName().equalsIgnoreCase("firework")) {
			if (sender instanceof Player) {
				String truc = "";
				truc = truc + "\n" + ((Player) sender).getItemInHand().getType();
				truc = truc +"\n"+ ((Player) sender).getItemInHand().getTypeId();
				truc = truc +"\n"+ ((Player) sender).getItemInHand().hashCode();
				truc = truc +"\n"+ ((Player) sender).getItemInHand().getItemMeta();
				sender.sendMessage(truc);
			} else {
				sender.sendMessage("Vous devez être un joueur");
			}
			return true;
		}
		return false;
	}

}
