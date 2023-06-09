package me.gemmerr.soulsmp.commands.msgs;

import me.gemmerr.soulsmp.utils.ErrorMessages;
import me.gemmerr.soulsmp.utils.MessageBuilder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MsgCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player player) {
            if (strings.length > 1) {
                String msg = "";
                for (int i = 1; i < strings.length; i++) {
                    msg += strings[i] + " ";
                }
                Player target = Bukkit.getServer().getPlayer(strings[0]);
                MessageBuilder.message("<#9545a3>" + commandSender.getName() + " <grey>» <#9545a3>dir<grey>: " + msg, target);
                MessageBuilder.commandSenderMessage("<#9545a3>du <grey>» <#9545a3>" + target.getName() + "<grey>: " + msg, commandSender);
                MessageManager.reply.put((Player) commandSender, target);
            }
            else {
                ErrorMessages.sendUsage("/msg [player]", player);
            }
            return false;
        }
        else{
            ErrorMessages.noPlayer(commandSender);
        }
        return false;
    }
}
