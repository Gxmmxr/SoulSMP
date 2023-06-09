package me.gemmerr.soulsmp.commands.msgs;

import me.gemmerr.soulsmp.SoulSMP;
import me.gemmerr.soulsmp.utils.ErrorMessages;
import me.gemmerr.soulsmp.utils.MessageBuilder;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ReplyCommand implements CommandExecutor {
    SoulSMP plugin = SoulSMP.getPlugin();
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player messager) {
            if(strings.length > 0) {
                if (MessageManager.getReplyTarget(messager) == null) {
                    MessageBuilder.errorPrefixMessage("<red>aktuell hast du Niemanden zum Antworten!", messager);
                    return true;
                }
                Player reciever = MessageManager.getReplyTarget(messager);
                String msg = "";
                for (int i = 0; i < strings.length; i++) {
                    msg += strings[i] + " ";
                }
                MessageBuilder.message("<#9545a3>" + messager.getName() + " <grey>» <#9545a3>dir<grey>: " + msg, reciever);
                MessageBuilder.commandSenderMessage("<#9545a3>du <grey>» <#9545a3>" + reciever.getName() + "<grey>: " + msg, messager);
                return true;
            }
        }
        else {
            ErrorMessages.noPlayer(commandSender);
        }
        return false;
    }
}
