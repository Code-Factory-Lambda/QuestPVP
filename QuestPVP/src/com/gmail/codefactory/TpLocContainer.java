package com.gmail.codefactory;

import java.util.ArrayList;

import org.bukkit.Location;
import org.bukkit.World;

public class TpLocContainer {
	private static World world;
	private static ArrayList<TeleportLoc> container;

	public static void addLoc(String name, double x, double y, double z){
		container.add(new TeleportLoc(name, world, x,y,z));
	}
	public static void init(World w){
		container = new ArrayList<>();
		world = w;
	}
	public static Location getTeleportLoc(String name){
		for(TeleportLoc tl : container){
			if(name.equalsIgnoreCase(tl.getName())){
				return tl.getLocation();
			}
		}
		return null;
	}
}
