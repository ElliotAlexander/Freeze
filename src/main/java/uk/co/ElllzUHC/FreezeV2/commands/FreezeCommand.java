package uk.co.ElllzUHC.FreezeV2.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import uk.co.ElllzUHC.FreezeV2.FreezeCommandInterface;
import uk.co.ElllzUHC.FreezeV2.FreezePlugin;

/**
 * Created by Elliot on 04/09/2014.
 */
public class FreezeCommand implements FreezeCommandInterface {

    private FreezePlugin plugin;

    public FreezeCommand(FreezePlugin plugin){
        this.plugin = plugin;




    }

    public String getUsage() {
        return ChatColor.AQUA + "/fr";
    }

    public void execute(String[] args, CommandSender sender) {
        if(args.length==0){
            if(plugin.getFreezeState()){
                plugin.setFreezeState(false);
                Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "All players unfrozen by " + sender.getName());
            } else {
                plugin.setFreezeState(true);
                Bukkit.getServer().broadcastMessage(ChatColor.GOLD + "All players frozen by " + sender.getName());
                return;
            }
        }
    }


    public String getDescription() {
        return ChatColor.AQUA + "Freezes all online players!";
    }


    public String getPermission() {
        return "Freeze.main";
    }


    private int taskID;

}
