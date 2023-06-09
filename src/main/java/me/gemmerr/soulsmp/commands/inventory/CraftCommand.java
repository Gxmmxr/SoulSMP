package me.gemmerr.soulsmp.commands.inventory;

import me.gemmerr.soulsmp.utils.ErrorMessages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.Inventory;
import org.jetbrains.annotations.NotNull;

public class CraftCommand implements CommandExecutor{
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player player) {
            if(strings.length == 0) {
                player.openWorkbench(player.getLocation(), true);
            }
            else {
                ErrorMessages.sendUsage("/craft", player);
            }
        }
        else {
            ErrorMessages.noPlayer(commandSender);
        }
        return false;
    }
}
