package com.gmail.willou421.PluginWill;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class InventaireCommandExecutor implements CommandExecutor {

	private PluginWill plugin; // pointer to your main class, unrequired if you don't need methods from the main class
	 
	public InventaireCommandExecutor(PluginWill plugin) {
		this.plugin = plugin;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		if (cmd.getName().equalsIgnoreCase("inventaire")) {
			if (args.length<1) {
				return false;
			} else {
				Player cible = (Bukkit.getServer().getPlayer(args[0]));
				if (cible==null) {
					sender.sendMessage("Ce joueur est inconnu");
				} else {
					
					PlayerInventory pi = cible.getInventory();
					sender.sendMessage(contenuInventaireToString(pi));
			
				}	
			}			
			return true;
		}
		return false;
	}
	 
	private String contenuInventaireToString(PlayerInventory pi) {
		
		String message = "";
		int s = pi.getSize();
		for (int i =0; i<s;i++) {
			if (!(pi.getItem(i)==null)) {
				int quantite = pi.getItem(i).getAmount();
				String item = pi.getItem(i).getType().name();
				message = message + " " + quantite + "x" + item;
			}
		}
		if (message == "") {return "Inventaire Vide";} else { return message; }
	}
	

}
