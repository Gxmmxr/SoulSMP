package me.gemmerr.soulsmp.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.swing.*;
import java.io.Console;
import java.util.logging.Logger;

public class MessageBuilder {
    public static final MiniMessage miniMessage = MiniMessage.miniMessage();
    //plugin Prefix (Player):
    public static final Component prefix = miniMessage.deserialize("<dark_grey>[<#9545a3>SoulSMP</#9545a3>]</dark_grey> ");
    //plugin Prefix (Team):
    public static final Component adminPrefix = miniMessage.deserialize("<dark_grey>[<red>SoulSMP</red>]</dark_grey> ");
    //plugin Prefix (Error):
    public static final Component errorPrefix = miniMessage.deserialize("<red>ℹ</red> ");


    //normale (farbige) Nachricht:
    public static void message(String message, Player player){
        player.sendMessage(miniMessage.deserialize(message));
    }
    //COMMANDSENDER normale (farbige) Nachricht:
    public static void commandSenderMessage(String message, CommandSender commandSender) {
        commandSender.sendMessage(miniMessage.deserialize(message));
    }
    //normale (farbige) Nachricht die jeder sieht:
    public static void broadcastMessage(String message){
        Bukkit.broadcast(miniMessage.deserialize(message));
    }
    //normale (farbige) Nachricht mit prefix:
    public static void prefixMessage(String message, Player player) {
        player.sendMessage(prefix.append(miniMessage.deserialize(message)));
    }
    public static void errorPrefixMessage(String message, Player player) {
        player.sendMessage(errorPrefix.append(miniMessage.deserialize(message)));
    }
    //COMMANDSENDER (farbige) Nachricht mit prefix:
    public static void commandSenderPrefixMessage(String message, CommandSender commandSender) {
        commandSender.sendMessage(prefix.append(miniMessage.deserialize(message)));
    }
    //ADMIN normale (farbige) Nachricht mit prefix:
    public static void adminPrefixMessage(String message, Player player) {
        player.sendMessage(adminPrefix.append(miniMessage.deserialize(message)));
    }
    //normale (farbige) Nachricht die jeder sieht mit prefix:
    public static void prefixBroadcastMessage(String message) {
        Bukkit.broadcast(prefix.append(miniMessage.deserialize(message)));
    }
    //link message mit Einleitungstext, Link Text, Link, Hover Text:
    public static void prefixLinkBroadcastMessage(String message, String linkMessage, String link, String hoverText, Player player) {
        player.sendMessage(prefix.append(miniMessage.deserialize(message)).append(miniMessage.deserialize(linkMessage).hoverEvent(HoverEvent.showText(miniMessage.deserialize(hoverText))).clickEvent(ClickEvent.openUrl(link))));
    }
    //es wird ein Command ausgeführt, wenn ein man auf den Text drückt (mit hover text):
    public static void clickEvent(String message, Player player, String command, String hoverText) {
        player.sendMessage(prefix.append(miniMessage.deserialize(message)).clickEvent(ClickEvent.runCommand(command)).hoverEvent(HoverEvent.showText(miniMessage.deserialize(hoverText))));
    }
}
