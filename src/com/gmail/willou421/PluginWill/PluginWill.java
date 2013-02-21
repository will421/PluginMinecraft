package com.gmail.willou421.PluginWill;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginWill extends JavaPlugin {

	private PluginWillConf conf = new PluginWillConf("pluginWill.xml");
	
	public PluginWillConf getConf() {
		return conf;
	}

	public void setConf(PluginWillConf conf) {
		this.conf = conf;
	}

	
	@Override
	public void onEnable() {
		// TODO Auto-generated method stub
		

		
		getCommand("inventaire").setExecutor(new InventaireCommandExecutor(this));
		getCommand("firework").setExecutor(new FireworkCommandExecutor(this));
		getCommand("multexp").setExecutor(new MultExpCommandExecutor(this));
		
        PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new ExpListener(this), this);
//        pm.registerEvents(new ExamplePlayerListener(this), this);
//        pm.registerEvents(new ExampleBlockListener(this), this);
//        pm.registerEvents(new ExampleEntityListener(this), this);  
	}
	

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		super.onDisable();
		conf.EditXMLFile();
	}
	
	
	
	
	
}
