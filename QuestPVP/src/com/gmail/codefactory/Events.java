package com.gmail.codefactory;

import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public final class Events implements Listener{
		
	public Events(Main plugin) {
		//Methode zum registrieren der Events
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
	
	@EventHandler
    public void onLogin(PlayerLoginEvent event) {
       System.out.println("Spieler "+event.getPlayer().getName()+" ist dem Server beigetreten!");
      
    }
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event){
		 if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
		        if(event.getClickedBlock().getTypeId() == 63 || event.getClickedBlock().getTypeId() == 68) {

		            Sign sign = (Sign) event.getClickedBlock().getState();
		            String locName = sign.getLine(0);
		            Location tpLocation = TpLocContainer.getTeleportLoc(locName);
		            if(tpLocation != null){
		            	event.getPlayer().teleport(tpLocation);
		            }else{
		            	event.getPlayer().sendMessage("Ungültiger Teleport!");
		            }
		            //sign.setLine(3, "FubbatPower");
		            //sign.update();

		            // Do other stuff if you need to
		        }
	}

}
}
