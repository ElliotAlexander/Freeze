package uk.co.ElllzUHC.FreezeV2.Listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import uk.co.ElllzUHC.FreezeV2.FreezePlugin;

/**
 * Created by Elliot on 06/09/2014.
 */
public class FoodChangeListener implements Listener {

    private FreezePlugin  plugin;

    public FoodChangeListener(FreezePlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onFoodChange(FoodLevelChangeEvent event){
        if(plugin.getFreezeState()){
            if(event.getEntity() instanceof Player && plugin.checkExemptedPlayer(((Player) event.getEntity()).getPlayer().getUniqueId())){
                event.setCancelled(true);
                event.setFoodLevel(20);
            }
        }
    }
}
