package me.gemmerr.soulsmp.commands.item;

import me.gemmerr.soulsmp.utils.ErrorMessages;
import me.gemmerr.soulsmp.utils.MessageBuilder;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class ItemNameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        if(commandSender instanceof Player player) {
            if(player.hasPermission("soulsmp.itemname")) {
                if(player.getItemInHand().getType() != Material.AIR) {
                    if(strings.length >= 1) {
                        //lore geben
                        ItemStack mainHand = player.getInventory().getItemInMainHand();
                        ItemMeta meta = mainHand.getItemMeta();
                        String msg = "";
                        for (int i = 0; i < strings.length; i++) {
                            msg += strings[i] + " ";
                        }
                        meta.setDisplayName(msg.replaceAll("&", "§"));
                        mainHand.setItemMeta(meta);
                    }
                    else {
                        ErrorMessages.sendUsage("/itemname", player);
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
