package me.gemmerr.soulsmp;

import me.gemmerr.soulsmp.commands.info.DiscordCommand;
import me.gemmerr.soulsmp.commands.info.PingCommand;
import me.gemmerr.soulsmp.commands.info.PlaytimeCommand;
import me.gemmerr.soulsmp.commands.inventory.CraftCommand;
import me.gemmerr.soulsmp.commands.inventory.EnderchestCommand;
import me.gemmerr.soulsmp.commands.other.GamemodeCommand;
import me.gemmerr.soulsmp.commands.other.GamemodeTab;
import me.gemmerr.soulsmp.commands.msgs.MsgCommand;
import me.gemmerr.soulsmp.commands.msgs.MsgTab;
import me.gemmerr.soulsmp.commands.msgs.ReplyCommand;
import me.gemmerr.soulsmp.commands.msgs.ReplyTab;
import me.gemmerr.soulsmp.commands.inventory.EnderchestseeCommand;
import me.gemmerr.soulsmp.commands.inventory.InvseeCommand;
import me.gemmerr.soulsmp.commands.item.ItemNameCommand;
import me.gemmerr.soulsmp.commands.item.SignCommand;
import me.gemmerr.soulsmp.commands.other.FlyCommand;
import me.gemmerr.soulsmp.commands.other.HealCommand;
import me.gemmerr.soulsmp.commands.teleport.back.BackCommand;
import me.gemmerr.soulsmp.commands.teleport.back.BackListener;
import me.gemmerr.soulsmp.commands.teleport.homes.HomeCommand;
import me.gemmerr.soulsmp.commands.teleport.homes.SetHomeCommand;
import me.gemmerr.soulsmp.commands.teleport.spawn.SetSpawnCommand;
import me.gemmerr.soulsmp.commands.teleport.spawn.SpawnCommand;
import me.gemmerr.soulsmp.commands.teleport.tpa.TpaCommand;
import me.gemmerr.soulsmp.commandwatcher.CommandWatcherToggle;
import me.gemmerr.soulsmp.commandwatcher.CommandWatcherListener;
import me.gemmerr.soulsmp.joinleave.JoinLeave;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SoulSMP extends JavaPlugin {
    public static SoulSMP plugin;
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        getCommand("discord").setExecutor(new DiscordCommand());

        getCommand("commandwatcher").setExecutor(new CommandWatcherToggle());

        getCommand("setspawn").setExecutor(new SetSpawnCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
        getCommand("tpa").setExecutor(new TpaCommand());
        getCommand("home").setExecutor(new HomeCommand());
        getCommand("sethome").setExecutor(new SetHomeCommand());

        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("gamemode").setTabCompleter(new GamemodeTab());

        getCommand("enderchest").setExecutor(new EnderchestCommand());
        getCommand("craft").setExecutor(new CraftCommand());

        getCommand("playtime").setExecutor(new PlaytimeCommand());
        getCommand("msg").setExecutor(new MsgCommand());
        getCommand("msg").setTabCompleter(new MsgTab());
        getCommand("reply").setExecutor(new ReplyCommand());
        getCommand("reply").setTabCompleter(new ReplyTab());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("sign").setExecutor(new SignCommand());
        getCommand("itemname").setExecutor(new ItemNameCommand());
        getCommand("ping").setExecutor(new PingCommand());
        getCommand("invsee").setExecutor(new InvseeCommand());
        getCommand("enderchestsee").setExecutor(new EnderchestseeCommand());
        getCommand("back").setExecutor(new BackCommand());

        Bukkit.getPluginManager().registerEvents(new JoinLeave(), this);
        Bukkit.getPluginManager().registerEvents(new CommandWatcherListener(), this);
        Bukkit.getPluginManager().registerEvents(new BackListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static SoulSMP getPlugin() {
        return plugin;
    }
}
