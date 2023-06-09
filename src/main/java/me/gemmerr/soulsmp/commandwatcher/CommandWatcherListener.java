package me.gemmerr.soulsmp.commandwatcher;

import me.gemmerr.soulsmp.utils.MessageBuilder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.ArrayList;

public class CommandWatcherListener implements Listener {
    public static ArrayList<Player> modPlayers = new ArrayList<Player>();
    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent e){
        Player player = e.getPlayer();
        String command = e.getMessage();
        //für jeden Spieler auf dem Server der die Permission soulsmp.commandwatcher hat und in der ArrayList modPlayer ist (nach dem ausführen von /commandwatcher) wird der Command in den Chat geschrieben:
        Bukkit.getOnlinePlayers().forEach(player1 -> {
            if(player1.hasPermission("soulsmp.commandwatcher") && modPlayers.contains(player1)) {
                MessageBuilder.adminPrefixMessage("<grey>" + player.getName() + "<dark_grey> » </dark_grey>" + command, player1);
            }
        });
    }
}
