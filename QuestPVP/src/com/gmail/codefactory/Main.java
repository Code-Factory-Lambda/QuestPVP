package com.gmail.codefactory;

import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    @SuppressWarnings("unchecked")
	public void onEnable(){ 
        System.out.println("Unser Subba Dubba Quest PVP ist gestartet!!");
           
      setUpTpLoc();
        
      //Methode zum registrieren der Events
        new Events(this);
    }
     

	public void onDisable(){ 
       System.out.println("QuestPVP: Peace Out!");
    }
    
    
    
    //Kommandos
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    	if (cmd.getName().equalsIgnoreCase("explodieren")){
    	if (!(sender instanceof Player)) {
               sender.sendMessage(ChatColor.RED + "Du musst ein Spieler sein!");
               return true;
            }
            Player player = (Player) sender;
            player.getWorld().createExplosion(player.getLocation(), 0);
        	return true;
    	}
		
		if (cmd.getName().equalsIgnoreCase("neuerTeleport")){
	    	if (!(sender instanceof Player)) {
	               sender.sendMessage(ChatColor.RED + "Du musst ein Spieler sein!");
	               return true;
	            }
	            Player player = (Player) sender;
	            
	            List<String> teleports = (List<String>) getConfig().getList("Teleports");
	            Location loc = player.getLocation();
	            teleports.add(args[0]+";"+Double.toString(loc.getX())+";"+Double.toString(loc.getY())+";"+Double.toString(loc.getZ()));
	            getConfig().set("Teleports", teleports);
	            this.saveConfig();
	            this.reloadConfig();
	            setUpTpLoc();
	            player.sendMessage(ChatColor.GREEN+"Neuer Schild-Teleporterpunkt "+args[0]+"erfolgreich erstellt!");
	            
	    	}
			return true;
	    }
    
    private void setUpTpLoc() {
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
		
	}
    }

