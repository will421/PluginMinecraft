package com.gmail.willou421.PluginWill;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockPlaceEvent;
 
/* Example Template
 * By Adamki11s
 * Plugin Tutorial
 */
 
public class ExampleBlockListener implements Listener {
 
        public PluginWill plugin;
       
        public ExampleBlockListener(PluginWill instance) {
                plugin = instance;
        }
 
        @EventHandler
        public void onBlockPlace(BlockPlaceEvent event){
                Player player = event.getPlayer();
                Block block = event.getBlock();
                Material mat = block.getType();
 
                player.sendMessage("You placed a block with ID : " + mat);//Display a message to the player telling them what type of block they placed.
        }
}