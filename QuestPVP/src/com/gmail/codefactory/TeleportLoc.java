package com.gmail.codefactory;

import org.bukkit.Location;
import org.bukkit.World;

public class TeleportLoc {
	private String name;
	private Location loc;

	public TeleportLoc(String name, Location loc){
		this.name = name;
		this.loc = loc;
	}
	
	public TeleportLoc(String name, World w, double x, double y, double z){
		this.name = name;
		this.loc = new Location(w, x,y,z);
	}
	public String getName(){
		return name;
	}
	public Location getLocation(){
		return loc;
	}
}
