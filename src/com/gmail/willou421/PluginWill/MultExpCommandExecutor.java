package com.gmail.willou421.PluginWill;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MultExpCommandExecutor implements CommandExecutor {

	private PluginWill plugin; // pointer to your main class, unrequired if you don't need methods from the main class
	 
	public MultExpCommandExecutor(PluginWill plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// TODO Auto-generated method stub
		//set effect
		if (cmd.getName().equalsIgnoreCase("multexp")) {
			if(args.length<1){	
				sender.sendMessage("Multiplicateur actuel : "+plugin.getConf().getMexc().getCoeff() );
			}
			else {
				int newCoeff = Integer.parseInt(args[0]);
				plugin.getConf().getMexc().setCoeff(newCoeff);
				sender.sendMessage("Multiplicaeur d'xp mis a "+newCoeff);
			}
			return true;
		}
		return false;
	}

}
