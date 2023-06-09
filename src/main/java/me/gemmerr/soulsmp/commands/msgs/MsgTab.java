package me.gemmerr.soulsmp.commands.msgs;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MsgTab implements TabCompleter {
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if (strings.length > 1) {
            new ArrayList<>();
            List<String> list = new ArrayList<>();
            list.add("");
            return list;
        }
        return null;
    }
}
