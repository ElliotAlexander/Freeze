package uk.co.ElllzUHC.FreezeV2;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;
import uk.co.ElllzUHC.FreezeV2.Listeners.BlockBreakListener;
import uk.co.ElllzUHC.FreezeV2.Listeners.EntityDamageListener;
import uk.co.ElllzUHC.FreezeV2.Listeners.FoodChangeListener;
import uk.co.ElllzUHC.FreezeV2.Listeners.PlayerMoveListener;

import java.util.*;
import java.util.logging.Level;

/**
 * Created by Elliot on 04/09/2014.
 */
public class FreezePlugin extends JavaPlugin {

    private ArrayList<UUID> exemptedPlayers = new ArrayList<UUID>();

    private boolean freezeState;

    private FreezeCommandExecutor executor;




    private int delayBetweenEffects;


    public void onEnable(){

        freezeState = false;

        executor = new FreezeCommandExecutor(this);

        getCommand("FR").setExecutor(executor);
        getCommand("FREXEMPT").setExecutor(executor);
        getCommand("FrReload").setExecutor(executor);

        getServer().getPluginManager().registerEvents(new PlayerMoveListener(this), this);
        getServer().getPluginManager().registerEvents(new BlockBreakListener(this),this);
        getServer().getPluginManager().registerEvents(new FoodChangeListener(this), this);
        getServer().getPluginManager().registerEvents(new EntityDamageListener(this), this);

    }


    public void setFreezeState(boolean b){
        freezeState = b;
    }

    public boolean getFreezeState(){
        return freezeState;
    }

    public void addExemptedbPlayer(Player p){
        exemptedPlayers.add(p.getUniqueId());
    }

    public void removeExemptedPlayer(Player p){
        try {
            exemptedPlayers.remove(p.getUniqueId());
        } catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }

    public String[] listExemptedPlayers(){

        ArrayList<String> returnPlayers = new ArrayList<String>();
        for(UUID uuid : exemptedPlayers){
            returnPlayers.add(Bukkit.getServer().getPlayer(uuid).getName());
        }
        return returnPlayers.toArray(new String[exemptedPlayers.size()]);
    }

    public boolean checkExemptedPlayer(UUID uuid){
        if(exemptedPlayers.contains(uuid)){
            return false;
        }
        return true;
    }



}
