package me.gemmerr.soulsmp.commands.other;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class GamemodeTab implements TabCompleter {
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(strings.length==1) {
            if (commandSender.hasPermission("goodtimer.timer") || commandSender.hasPermission("*")) {
                new ArrayList<>();
                List<String> list = new ArrayList<>();
                list.add("creative");
                list.add("survival");
                list.add("adventure");
                list.add("spectator");
                return list;
            } else {
                return null;
            }
        }
        return null;
    }
}

