package me.gemmerr.soulsmp.commands.inventory;

import me.gemmerr.soulsmp.utils.ErrorMessages;
import me.gemmerr.soulsmp.utils.MessageBuilder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class InvseeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player player) {
            if(strings.length == 1) {
                Player target = Bukkit.getPlayer(strings[0]);
                if(target == null) {
                    MessageBuilder.errorPrefixMessage("<red>das ist kein Spieler!", player);
                    return false;
                }
                else {
                    player.openInventory(target.getInventory());
                }
            }
            else {
                ErrorMessages.sendUsage("/invsee [player]",player);
            }
        }
        else {
            ErrorMessages.noPlayer(commandSender);
        }
        return false;
    }
}
