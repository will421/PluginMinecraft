package com.gmail.willou421.PluginWill;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
 
/* Example Template
 * By Adamki11s
 * Plugin Tutorial
 */
 
public class ExampleEntityListener implements Listener {
       
        public PluginWill plugin;
       
        public ExampleEntityListener(PluginWill instance) {
                plugin = instance;
        }
 
        @EventHandler
        public void onEntityDamage(EntityDamageEvent event){
               
                if(event.getEntity() instanceof Player){
                //If the entity being damaged is a player then...
 
                        event.setCancelled(true);
                //Cancel the damage event, this will give the player unlimited health
                }
        }
        
        
        
}