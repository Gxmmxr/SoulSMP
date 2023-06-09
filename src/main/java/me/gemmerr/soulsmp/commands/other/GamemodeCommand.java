package me.gemmerr.soulsmp.commands.other;

import me.gemmerr.soulsmp.utils.ErrorMessages;
import me.gemmerr.soulsmp.utils.MessageBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class GamemodeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if(commandSender instanceof Player player) {
            if(player.hasPermission("minecraft.commmand.gamemode")) {
                if (player.hasPermission("minecraft.command.gamemode") && args.length == 1) {
                    switch (args[0].toLowerCase()) {
                        case "1":
                        case "creative":
                            player.setGameMode(GameMode.CREATIVE);
                            MessageBuilder.adminPrefixMessage("<grey>du bist jetzt im Gamemode <#9545a3>Creative<grey>!", player);
                            break;
                        case "0":
                        case "survival":
                            player.setGameMode(GameMode.SURVIVAL);
                            MessageBuilder.adminPrefixMessage("<grey>du bist jetzt im Gamemode <#9545a3>Survival<grey>!", player);
                            break;
                        case "2":
                        case "adventure":
                            player.setGameMode(GameMode.ADVENTURE);
                            MessageBuilder.adminPrefixMessage("<grey>du bist jetzt im Gamemode <#9545a3>Adventure<grey>!", player);
                            break;

                        case "3":
                        case "spectator":
                            player.setGameMode(GameMode.SPECTATOR);
                            MessageBuilder.adminPrefixMessage("<grey>du bist jetzt im Gamemode <#9545a3>Spectator<grey>!", player);
                            break;
                        default:
                            sendUsage(player);
                            break;
                    }
                }
                else if (args.length == 2 && Bukkit.getPlayer(args[1]) != null) {
                    Player argplayer = Bukkit.getPlayer(args[1]);
                    switch (args[0].toLowerCase()) {
                        case "1":
                        case "creative":
                            argplayer.setGameMode(GameMode.CREATIVE);
                            MessageBuilder.adminPrefixMessage("<grey>du hast den Gamemode von <#9545a3>" + argplayer.getName() + "</#9545a3> zu <#9545a3>Creative <grey>geändert!", player);
                            break;
                        case "0":
                        case "survival":
                            argplayer.setGameMode(GameMode.SURVIVAL);
                            MessageBuilder.adminPrefixMessage("<grey>du hast den Gamemode von <#9545a3>" + argplayer.getName() + "</#9545a3> zu <#9545a3>Survival <grey>geändert!", player);
                            break;
                        case "2":
                        case "adventure":
                            argplayer.setGameMode(GameMode.ADVENTURE);
                            MessageBuilder.adminPrefixMessage("<grey>du hast den Gamemode von <#9545a3>" + argplayer.getName() + "</#9545a3> zu <#9545a3>Adventure <grey>geändert!", player);
                            break;
                        case "3":
                        case "spectator":
                            argplayer.setGameMode(GameMode.SPECTATOR);
                            MessageBuilder.adminPrefixMessage("<grey>du hast den Gamemode von <#9545a3>" + argplayer.getName() + "</#9545a3> zu <#9545a3>Spectator <grey>geändert!", player);
                            break;
                        default:
                            sendUsage(player);
                            break;
                    }
                }
                else {
                    sendUsage(player);
                    return false;
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
    public void sendUsage(Player player) {
        ErrorMessages.sendUsage("/gamemode [creative|survival|spectator|adventure]",player);
    }
}
