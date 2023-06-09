package me.gemmerr.soulsmp.commands.item;

import me.gemmerr.soulsmp.utils.ErrorMessages;
import me.gemmerr.soulsmp.utils.MessageBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Date;

public class SignCommand implements CommandExecutor{
    //format für das Datum
    String pattern = "dd.MM.yyyy";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player player) {
            if(player.hasPermission("soulsmp.sign")) {
                if(player.getItemInHand().getType() != Material.AIR) {
                    if(strings.length == 0) {
                        //lore geben
                        ItemStack mainHand = player.getInventory().getItemInMainHand();
                        ItemMeta meta = mainHand.getItemMeta();
                        ArrayList<String> lore = new ArrayList<String>();
                        lore.add("§7signiert von:" + " §d" + player.getName() + " §7<3");
                        //aktuelles Datum bekommen
                        String date = simpleDateFormat.format(new Date());
                        lore.add("§7am §d" + date + " §7signiert");
                        meta.setLore(lore);
                        mainHand.setItemMeta(meta);
                    }else {
                        ErrorMessages.sendUsage("/sign", player);
                    }
                }
                else {
                    MessageBuilder.errorPrefixMessage("<red>du musst ein Item in der Hand halten!", player);
                }
            }
            else {
                ErrorMessages.noPermission(player);
            }
        }
        else {
            ErrorMessages.noPlayer(commandSender);
        }
        return false;
    }
}
