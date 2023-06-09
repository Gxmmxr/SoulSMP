package me.gemmerr.soulsmp.commands.teleport.spawn;

import me.gemmerr.soulsmp.SoulSMP;
import me.gemmerr.soulsmp.utils.ErrorMessages;
import me.gemmerr.soulsmp.utils.MessageBuilder;
import org.apache.logging.log4j.message.Message;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {
    FileConfiguration config = SoulSMP.getPlugin().getConfig();
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player player) {
            int x = config.getInt("Spawn.x");
            int y = config.getInt("Spawn.y");
            int z = config.getInt("Spawn.z");
            Location spawn = new Location(player.getWorld(), x+0.5, y, z+0.5);
            if(strings.length == 0) {
                player.teleport(spawn);
                MessageBuilder.prefixMessage("<grey>du wurdest zum <#9545a3>Spawn</#9545a3> teleportiert!", player);
            }
            else if(strings.length == 1) {
                if(Bukkit.getPlayer(strings[1].toString()) != null && player.hasPermission("soulsmp.setspawn")){
                    Player target = Bukkit.getPlayer(strings[1].toString());
                    target.teleport(spawn);
                    MessageBuilder.adminPrefixMessage("<grey>du hast <#9545a3>"+target+"</#9545a3> zum spawn teleportiert", player);
                    MessageBuilder.prefixMessage("<grey>du wurdest zum <#9545a3>Spawn</#9545a3> teleportiert", target);
                }
            }
            else {
                ErrorMessages.sendUsage("/spawn", player);
            }
        }
        else {
            ErrorMessages.noPlayer(commandSender);
        }
        return false;
    }
}
