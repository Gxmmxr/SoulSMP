package me.gemmerr.soulsmp.commands.info;

import me.gemmerr.soulsmp.utils.ErrorMessages;
import me.gemmerr.soulsmp.utils.MessageBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PlaytimeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        //playtime von sich selber
        if(strings.length == 0) {
            int playtime = player.getStatistic(Statistic.PLAY_ONE_MINUTE);
            playtime = playtime / 20;
            MessageBuilder.prefixMessage("<grey>du hast eine Spielzeit von <#9545a3>" + shortInteger(playtime) + "<grey>.", player);
        }
        //playtime von jemand anderem
        else if(Bukkit.getPlayer(strings[0]) != null && strings.length == 1) {
            if(player.hasPermission("soul.mod") || player.isOp()) {
                Player target = Bukkit.getPlayer(strings[0]);
                int playtime = target.getStatistic(Statistic.PLAY_ONE_MINUTE);
                playtime = playtime / 20;
                MessageBuilder.adminPrefixMessage("<grey><#9545a3>" + target.getName() + "</#9545a3> hat eine Spielzeit von <#9545a3>" + shortInteger(playtime) + "<grey>.", player);
                return false;
            }
            else{
                sendUsage(player);
            }
        }
        else{
            sendUsage(player);
        }
        return false;
    }
    //usage message
    private void sendUsage(Player player){
        ErrorMessages.sendUsage("/playtime", player);
    }
    //Umrechnung von Sekunden in Tage, Stunden, Minuten, Sekunden
    private String shortInteger(int duration) {
        String string = "";
        int hours = 0;
        int minutes = 0;
        int seconds = 0;
        if(duration / 60 / 60 >=1) {
            hours = duration / 60 /60;
            duration = duration - ((duration / 60 / 60) * 60 * 60);
        }
        if(duration / 60 >= 1) {
            minutes = duration / 60;
            duration = duration - ((duration /60)*60);
        }
        if(duration >=1) {
            seconds = duration;
        }
        if(hours!=0) {
            if (hours <= 9) {
                string = string + "0" + hours + "h ";
            } else {
                string = string + hours + "h ";
            }
        }else {
            string =string;
        }
        if(minutes!=0) {
            if (minutes <= 9) {
                string = string + "0" + minutes + "m ";
            } else {
                string = string + minutes + "m ";
            }
        }else{
            string= string;
        }
        if(seconds <=9) {
            string= string+"0"+seconds+"s";
        }else{
            string= string+seconds+"s";
        }
        return string;
    }
}