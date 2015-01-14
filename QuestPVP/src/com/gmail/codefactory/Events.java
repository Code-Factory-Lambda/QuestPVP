package com.gmail.codefactory;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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

}
