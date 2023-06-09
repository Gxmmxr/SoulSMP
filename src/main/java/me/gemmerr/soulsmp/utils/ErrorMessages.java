package me.gemmerr.soulsmp.utils;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ErrorMessages {
    //Spieler hat keine Rechte auf etwas
    public static void noPermission(Player player) {
        MessageBuilder.errorPrefixMessage("<red>dazu hast du keine Rechte!", player);
    }
    //Sender eines Commands ist kein Spieler
    public static void noPlayer(CommandSender commandSender) {
        MessageBuilder.commandSenderMessage("<red>hierzu musst du ein Spieler sein.", commandSender);
    }
    //der Command wurde falsch genutzt
    public static void sendUsage(String usage, Player player) {
        MessageBuilder.message("<grey>usage: <blue>"+usage, player);
    }
}
