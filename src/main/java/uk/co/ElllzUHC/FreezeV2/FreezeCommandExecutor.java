package uk.co.ElllzUHC.FreezeV2;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import uk.co.ElllzUHC.FreezeV2.commands.FrExemptCommand;
import uk.co.ElllzUHC.FreezeV2.commands.FreezeCommand;
import uk.co.ElllzUHC.FreezeV2.commands.ReloadFreeze;

import java.util.HashMap;

/**
 * Created by Elliot on 04/09/2014.
 */
public class FreezeCommandExecutor implements CommandExecutor {

    private HashMap<String, FreezeCommandInterface> commands;

    public FreezeCommandExecutor(FreezePlugin plugin){

        commands = new HashMap<String, FreezeCommandInterface>();

        commands.put("FR", new FreezeCommand(plugin));
        commands.put("FREXEMPT", new FrExemptCommand(plugin));
        commands.put("FRRELOAD", new ReloadFreeze(plugin));
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if(!(commands.containsKey(label.toUpperCase()))){
            sender.sendMessage(ChatColor.RED + "Command not found!");
            return true;
        }

        FreezeCommandInterface commandInterface = commands.get(label.toUpperCase());

        if(label.toString().equalsIgnoreCase("frhelp")){
            sender.sendMessage(ChatColor.GOLD + "-=- Freeze commands -=-");
            for(FreezeCommandInterface command : commands.values()){
                sender.sendMessage(ChatColor.GREEN + command.getUsage() + " ||  " + command.getDescription());
            }
            return true;
        }



        if(!(sender.hasPermission(commandInterface.getPermission()))){
            sender.sendMessage(ChatColor.RED + "No permission");
            return true;
        } else {
            commandInterface.execute(args, sender);
        }
        return true;
    }
}
