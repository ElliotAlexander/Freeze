package uk.co.ElllzUHC.FreezeV2.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import uk.co.ElllzUHC.FreezeV2.FreezePlugin;

/**
 * Created by Elliot on 06/09/2014.
 */
public class BlockBreakListener implements Listener {

    private FreezePlugin plugin;

    public BlockBreakListener(FreezePlugin plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        if(plugin.getFreezeState()){
            if(plugin.checkExemptedPlayer(event.getPlayer().getUniqueId())){
                event.setCancelled(true);
                event.getPlayer().sendMessage(ChatColor.RED + "You cannot break blocks when frozen!");
            }
        }
    }

}
