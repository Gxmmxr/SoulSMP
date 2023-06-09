package me.gemmerr.soulsmp.commands.teleport.spawn;

import me.gemmerr.soulsmp.SoulSMP;
import me.gemmerr.soulsmp.utils.ErrorMessages;
import me.gemmerr.soulsmp.utils.MessageBuilder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetSpawnCommand implements CommandExecutor {
    FileConfiguration config = SoulSMP.getPlugin().getConfig();
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player player) {
            if(commandSender.hasPermission("soulsmp.setspawn")) {
               if(strings.length == 0) {
                   int x = player.getLocation().getBlockX();
                   int y = player.getLocation().getBlockY();
                   int z = player.getLocation().getBlockZ();
                   config.set("Spawn.x", x);
                   config.set("Spawn.y", y);
                   config.set("Spawn.z", z);
                   SoulSMP.getPlugin().saveConfig();
                   player.getWorld().setSpawnLocation(x, y, z);
                   MessageBuilder.adminPrefixMessage("<grey>du hast den Spawn an deine Position gesetzt!", player);
               }
               else {
                   ErrorMessages.sendUsage("/setspawn", player);
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
