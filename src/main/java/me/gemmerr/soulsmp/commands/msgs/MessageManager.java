package me.gemmerr.soulsmp.commands.msgs;

import me.gemmerr.soulsmp.SoulSMP;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class MessageManager {
    SoulSMP plugin;

    static HashMap<Player, Player> reply = new HashMap<Player, Player>();

    public static void setReplyTarget(Player messager, Player reciever) {
        reply.put(messager, reciever);
        reply.put(reciever, messager);
    }
    public static Player getReplyTarget(Player messager){
        return reply.get(messager);
    }
}
