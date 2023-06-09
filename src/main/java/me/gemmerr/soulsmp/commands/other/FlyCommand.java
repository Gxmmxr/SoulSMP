package me.gemmerr.soulsmp.commands.other;

import me.gemmerr.soulsmp.utils.ErrorMessages;
import me.gemmerr.soulsmp.utils.MessageBuilder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(commandSender instanceof Player player) {
            if(player.hasPermission("soulsmp.fly")) {
                if(args.length == 0) {
                    if (player.getAllowFlight()) {
                        player.setAllowFlight(false);
                        MessageBuilder.adminPrefixMessage("<grey>du kannst nicht mehr fliegen!", player);
                    }
                    else if (!player.getAllowFlight()) {
                        player.setAllowFlight(true);
                        MessageBuilder.adminPrefixMessage("<grey>du kannst jetzt fliegen!", player);
                    }
                }else if(Bukkit.getPlayer(args[0]) != null && args.length == 1) {
                    Player argPlayer = Bukkit.getPlayer(args[0]);
                    if (!argPlayer.getAllowFlight()) {
                        argPlayer.setAllowFlight(true);
                        MessageBuilder.prefixMessage("<grey>du kannst jetzt fliegen!", argPlayer);
                        MessageBuilder.adminPrefixMessage("<grey>" + argPlayer.getName() + " kann jetzt fliegen!", player);
                    }
                    else if (argPlayer.getAllowFlight()){
                        argPlayer.setAllowFlight(false);
                        MessageBuilder.prefixMessage("<grey>du kannst nicht mehr fliegen!", argPlayer);
                        MessageBuilder.adminPrefixMessage("<grey>" + argPlayer.getName() + " kann nicht mehr fliegen!", player);
                    }
                }
                else {
                    ErrorMessages.sendUsage("/fly [Player]", player);
                }
            }
            else {
                ErrorMessages.noPermission(player);
            }
        }
        else {
            ErrorMessages.noPlayer(commandSender);
        }
        return false;
    }
}
