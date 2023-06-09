package me.gemmerr.soulsmp.joinleave;

import me.gemmerr.soulsmp.utils.MessageBuilder;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeave implements Listener {
    //custom join message
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        e.setJoinMessage(null);
        MessageBuilder.broadcastMessage("<dark_grey>[<bold><#9545a3>+</#9545a3></bold>]</dark_grey> <grey><#9545a3>"+player.getName()+"</#9545a3> joined the Server");
        //Spieler hat noch nicht gespielt (Einleitungstext)
        if(!player.hasPlayedBefore()) {
            MessageBuilder.prefixMessage("<grey><#9545a3>Willkommen</#9545a3> auf dem <#9545a3>SoulSMP</#9545a3>. trete gerne unserem <blue>Discord</blue> Server über den /discord Command bei.", player);
        }
    }
    //custom leave message
    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        e.setQuitMessage(null);
        MessageBuilder.broadcastMessage("<dark_grey>[<bold><#9545a3>-</#9545a3></bold>]</dark_grey> <grey><#9545a3>"+player.getName()+"</#9545a3> left the Server");
    }
}
