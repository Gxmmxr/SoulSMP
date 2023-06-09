package me.gemmerr.soulsmp.commands.teleport.back;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;

public class BackListener implements Listener {
    static HashMap<Player, Location> deathLocation = new HashMap<Player, Location>();

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player player = e.getPlayer();
        Location location = e.getPlayer().getLocation();
        deathLocation.put(player, location);
    }
}
