package com.gmail.codefactory;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
    public void onEnable(){ 
        System.out.println("Unser Subba Dubba Quest PVP ist gestartet!!");
        
      //Methode zum registrieren der Events
        new Events(this);
    }
     
    public void onDisable(){ 
       System.out.println("QuestPVP: Peace Out!");
    }


}
