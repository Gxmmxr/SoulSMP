package me.gemmerr.soulsmp.commands.info;

import me.gemmerr.soulsmp.utils.ErrorMessages;
import me.gemmerr.soulsmp.utils.MessageBuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DiscordCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (commandSender instanceof Player player) {
            if(strings.length == 0) {
                MessageBuilder.prefixLinkBroadcastMessage("<grey>unser Discord » ", "<grey><blue>Discord</blue> <italic>(click)", "discord.gg/soul-smp-minecraft-850364001195261993", "<grey>discord.gg/SoulSMP", player);
                return false;
            }
            else {
                ErrorMessages.sendUsage("/discord", player);
            }
        }
        else {
            ErrorMessages.noPlayer(commandSender);
        }
        return false;
    }
}
