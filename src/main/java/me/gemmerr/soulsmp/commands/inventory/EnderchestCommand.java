package me.gemmerr.soulsmp.commands.inventory;

import me.gemmerr.soulsmp.utils.ErrorMessages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class EnderchestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player player) {
            if(strings.length == 0) {
                player.openInventory(player.getEnderChest());
            }
            else {
                ErrorMessages.sendUsage("/enderchest", player);
            }
        }
        else {
            ErrorMessages.noPlayer(commandSender);
        }
        return false;
    }
}
