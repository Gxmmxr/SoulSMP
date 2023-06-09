package me.gemmerr.soulsmp.commandwatcher;

import me.gemmerr.soulsmp.utils.ErrorMessages;
import me.gemmerr.soulsmp.utils.MessageBuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CommandWatcherToggle implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player player) {
            if(strings.length == 0) {
                ArrayList<Player> players = CommandWatcherListener.modPlayers;
                //Spieler sieht alle Commands:
                if (players.contains(player)) {
                    players.remove(player);
                    MessageBuilder.adminPrefixMessage("<grey>du siehst nun nicht mehr alle Commands!", player);
                }
                //Spieler sieht nicht mehr alle Commands
                else {
                    players.add(player);
                    MessageBuilder.adminPrefixMessage("<grey>du siehst nun die Commands aller Spieler!", player);
                }
            }
            else {
                ErrorMessages.sendUsage("/commandwatcher", player);
            }
        }
        else {
            ErrorMessages.noPlayer(commandSender);
        }
        return false;
    }
}
