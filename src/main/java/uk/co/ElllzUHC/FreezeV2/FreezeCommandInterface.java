package uk.co.ElllzUHC.FreezeV2;

import org.bukkit.command.CommandSender;

/**
 * Created by Elliot on 30/08/2014.
 */
public interface FreezeCommandInterface {


    public String getUsage();

    public void execute(String[] args, CommandSender sender);

    public String getDescription();

    public String getPermission();

}
