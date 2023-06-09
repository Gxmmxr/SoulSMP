package me.gemmerr.soulsmp.commands.other;

import me.gemmerr.soulsmp.utils.ErrorMessages;
import me.gemmerr.soulsmp.utils.MessageBuilder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class HealCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(commandSender instanceof Player player) {
            if(player.hasPermission("soulsmp.heal")) {
                if(args.length == 0) {
                    player.setHealth(20);
                    player.setSaturation(20);
                    player.setFoodLevel(20);
                    MessageBuilder.adminPrefixMessage("<grey>du hast dich geheilt!", player);
                }
                else if(Bukkit.getPlayer(args[0]) != null && args.length == 1) {
                    Player argPlayer = Bukkit.getPlayer(args[0]);
                    argPlayer.setHealth(20);
                    argPlayer.setSaturation(20);
                    argPlayer.setFoodLevel(20);
                    MessageBuilder.prefixMessage("<grey>du wurdest geheilt!", argPlayer);
                    MessageBuilder.adminPrefixMessage("<grey>" + argPlayer.getName() + " ist nun geheilt!", player);
                }
                else {
                    ErrorMessages.sendUsage("/heal [Player]", player);
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
