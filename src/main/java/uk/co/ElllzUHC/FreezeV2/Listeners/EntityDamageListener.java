package uk.co.ElllzUHC.FreezeV2.Listeners;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import uk.co.ElllzUHC.FreezeV2.FreezePlugin;

/**
 * Created by Elliot on 04/09/2014.
 */
public class EntityDamageListener implements Listener {

    private FreezePlugin plugin;

    public EntityDamageListener(FreezePlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event){
        if(plugin.getFreezeState()){
            if(event.getEntity() instanceof Player){
                if(plugin.checkExemptedPlayer(((Player) event.getEntity()).getPlayer().getUniqueId())){
                    event.setCancelled(true);

                }
            }
        }
    }

    @EventHandler
    public void onEntityDamage(EntityDamageByEntityEvent event){
        if(plugin.getFreezeState()){
            if(event.getEntity() instanceof Player){
                if(plugin.checkExemptedPlayer(((Player) event.getEntity()).getPlayer().getUniqueId())){
                    event.setCancelled(true);

                    // Kills  the offending entity, removes some of the need for butchering.
                    Entity entity = event.getDamager();
                    entity.remove();

                }
            }
        }
    }
}
