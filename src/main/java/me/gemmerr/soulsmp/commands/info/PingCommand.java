package me.gemmerr.soulsmp.commands.info;

import me.gemmerr.soulsmp.utils.ErrorMessages;
import me.gemmerr.soulsmp.utils.MessageBuilder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PingCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player player) {
            //ping von sich selber
            if(strings.length == 0) {
                MessageBuilder.prefixMessage("<grey>du hast einen Ping von <#9545a3>"+player.getPing()+"<grey>.", player);
            }
            //ping von jemand anderem
            else if(strings.length == 1) {
                if(player.hasPermission("soulsmp.ping")) {
                    Player target = Bukkit.getPlayer(strings[0]);
                    if (target == null) {
                        MessageBuilder.message("<grey>das ist kein Spieler", player);
                        return false;
                    }
                    else {
                        MessageBuilder.prefixMessage("<#9545a3>"+target.getName() + "</#9545a3> <grey>hat einen Ping von <#9545a3>" + player.getPing() + "<grey>.", player);
                    }
                }
                else {
                    ErrorMessages.noPermission(player);
                }
            }
        }
        return false;
    }
}
