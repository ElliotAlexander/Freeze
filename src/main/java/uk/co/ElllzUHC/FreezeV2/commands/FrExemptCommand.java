package uk.co.ElllzUHC.FreezeV2.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import uk.co.ElllzUHC.FreezeV2.FreezeCommandInterface;
import uk.co.ElllzUHC.FreezeV2.FreezePlugin;

/**
 * Created by Elliot on 04/09/2014.
 */
public class FrExemptCommand implements FreezeCommandInterface{

    private FreezePlugin plugin;

    public FrExemptCommand(FreezePlugin plugin){
        this.plugin = plugin;
    }

    @Override
    public String getUsage() {
        return "/frexempt <Add/List/Remove> [Player]";
    }

    @Override
    public void execute(String[] args, CommandSender sender) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Invalid args!");
            return;
        }

        Player p;


        // Logic to determine if the sender is freezing himself or another player,  and to check that the sender is not console
        if (args.length  > 1) {
            try {
                p = Bukkit.getPlayer(args[1]);
                if(!p.isOnline()){
                    sender.sendMessage(ChatColor.RED + "That player is not online!");
                    return;
                }
            } catch (Exception e) {
                sender.sendMessage(ChatColor.RED + "That player is not found!");
                return;
            }
        } else if (sender instanceof Player) {
            p = (Player) sender;
        } else {
            sender.sendMessage(ChatColor.RED + "You cannot exempt the console!");
            return;
        }

        if (args[0].equalsIgnoreCase("remove")) {
            plugin.removeExemptedPlayer(p);
            p.sendMessage(ChatColor.RED + "You have been frozen!");
            return;
        }

        if (args[0].equalsIgnoreCase("add")) {
            plugin.addExemptedPlayer(p);
            p.sendMessage(ChatColor.GREEN + "You have been exempted from the freeze!");
            return;
        }

        if (args[0].equalsIgnoreCase("list")) {
            String s = ChatColor.AQUA + "Exempted players: ";
            for (String exemptedPlayerName : plugin.listExemptedPlayers()) {
                s = s + exemptedPlayerName + ", ";
            }
            sender.sendMessage(s);
            return;
        }

        else {
            sender.sendMessage(ChatColor.RED + "Unknown command!");
            return;
        }

    }

    @Override
    public String getDescription() {
        return "Controls the players exempted from the effects of the freeze.";
    }

    @Override
    public String getPermission() {
        return "freeze.exempt";
    }
}
