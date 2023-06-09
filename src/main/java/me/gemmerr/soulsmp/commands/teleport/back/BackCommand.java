package me.gemmerr.soulsmp.commands.teleport.back;

import me.gemmerr.soulsmp.utils.MessageBuilder;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BackCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player player) {
            Location location = BackListener.deathLocation.get(player);
            if(location != null) {
                player.teleport(location);
                BackListener.deathLocation.remove(player);
                MessageBuilder.prefixMessage("du wurdest zu deiner letzten Todesstelle teleportiert.", player);
            }
            else {
                MessageBuilder.errorPrefixMessage("<red>du hast keine letzte Todesstelle!", player);
            }
        }
        return false;
    }
}
