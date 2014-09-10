package uk.co.ElllzUHC.FreezeV2.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import uk.co.ElllzUHC.FreezeV2.FreezeCommandInterface;
import uk.co.ElllzUHC.FreezeV2.FreezePlugin;

/**
 * Created by Elliot on 04/09/2014.
 */
public class ReloadFreeze implements FreezeCommandInterface {

    private FreezePlugin plugin;

    public ReloadFreeze(FreezePlugin plugin){
        this.plugin = plugin;
    }

    public String getUsage(){
        return "/frreload";
    }

    public void execute(String[] args, CommandSender sender){
        plugin.reloadConfig();
        sender.sendMessage(ChatColor.RED + "Reloading configs!");
    }

    public String getDescription(){
        return "Reloads the plugin configuration!";
    }

    public String getPermission(){
        return "Freeze.reload";
    }
}
