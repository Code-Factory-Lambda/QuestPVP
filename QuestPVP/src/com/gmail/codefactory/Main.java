package com.gmail.codefactory;

import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    @SuppressWarnings("unchecked")
	public void onEnable(){ 
        System.out.println("Unser Subba Dubba Quest PVP ist gestartet!!");
           
        //TeleportLocation Container anlegen
        TpLocContainer.init(getServer().getWorld("world"));
        List<String> teleports = (List<String>) getConfig().getList("Teleports");
        Iterator<String> iter = teleports.iterator();
        
        StringTokenizer st;
        String name;
        double x,y,z;
        while(iter.hasNext()){
        	st = new StringTokenizer(iter.next(), ";");
        	name = st.nextToken();
        	System.out.println("TpName: "+name);
        	x = Double.parseDouble(st.nextToken());
        	y = Double.parseDouble(st.nextToken());
        	z = Double.parseDouble(st.nextToken());
        	TpLocContainer.addLoc(name, x, y, z);
        }
        
        
        
      //Methode zum registrieren der Events
        new Events(this);
    }
     
    public void onDisable(){ 
       System.out.println("QuestPVP: Peace Out!");
    }

}
