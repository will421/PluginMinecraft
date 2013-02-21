package com.gmail.willou421.PluginWill;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerExpChangeEvent;

public class ExpListener implements Listener {

	private PluginWill plugin;
	
	public ExpListener(PluginWill p) {
		plugin =p;
	}
	
    @EventHandler
    public void onDropExp(PlayerExpChangeEvent event) {
        int xpdepart = event.getAmount() ;
        int coeff = plugin.getConf().getMexc().getCoeff() ;
        int xpfinal = xpdepart*coeff ;
        //event.getPlayer().sendMessage("xpdepart = "+xpdepart+" coeff = "+coeff+ " xpfinal = "+xpfinal);
        event.setAmount(xpfinal);
    }
	
}
