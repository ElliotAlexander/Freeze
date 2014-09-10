package uk.co.ElllzUHC.FreezeV2.Listeners;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import uk.co.ElllzUHC.FreezeV2.FreezePlugin;

/**
 * Created by Elliot on 04/09/2014.
 */
public class PlayerMoveListener implements Listener {

    private FreezePlugin  plugin;

    public PlayerMoveListener(FreezePlugin plugin){
        this.plugin = plugin;
    }


    @EventHandler
    public void onMove(PlayerMoveEvent event){
        if(plugin.getFreezeState()){
            if(plugin.checkExemptedPlayer(event.getPlayer().getUniqueId())){
                Location newLoc = new Location(event.getTo().getWorld(), event.getFrom().getX(), event.getTo().getY(), event.getFrom().getZ());
                newLoc.setYaw(event.getTo().getYaw());
                newLoc.setPitch(event.getTo().getPitch());
                event.setTo(newLoc);

            }
        }
    }
}
