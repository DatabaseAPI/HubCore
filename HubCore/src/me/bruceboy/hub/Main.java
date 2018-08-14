package me.bruceboy.hub;

import com.google.common.io.ByteStreams;
import me.bruceboy.hub.Gui.HelpGui;
import me.bruceboy.hub.Listeners.JoinListener;
import me.bruceboy.hub.PlayerHider.Event;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.HashMap;

import me.bruceboy.hub.scoreboard.PlayerBoard;
import me.bruceboy.hub.scoreboard.board.HubScoreboard;
import me.bruceboy.hub.scoreboard.task.ScoreboardUpdateTask;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;
import org.bukkit.scheduler.BukkitRunnable;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class Main extends JavaPlugin implements Listener {

    private static Main instance;
    private static Main plugin;
    private static Permission perms = null;
    private Event servers;

    public void onEnable() {
        setInstance(this);
        plugin = this;
        Bukkit.getPluginManager().registerEvents(this, this);
        Bukkit.getPluginManager().registerEvents(new JoinListener(), this);
        Bukkit.getPluginManager().registerEvents(new Event(), this);
        Bukkit.getPluginManager().registerEvents(new HelpGui(), this);
        getCommand("help").setExecutor(new HelpGui());
        getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
        this.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", new BungeeEvents());

        setupPermissions();
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            PlayerBoard.get(p).setProvider(HubScoreboard.getInstance());
        }




    }








    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        Player p = event.getPlayer();
        event.setCancelled(true);
        Bukkit.broadcastMessage(ChatColor.GRAY + "(" + ChatColor.GOLD + ChatColor.BOLD.toString() + "Hub" + ChatColor.GRAY + ") " + p.getName() + " " + event.getMessage());


    }




    @EventHandler(priority = EventPriority.HIGHEST)
    public void ItemDrop(PlayerDropItemEvent event) {
        Player p = event.getPlayer();
        if(!p.hasPermission("item.use")) {
            event.setCancelled(true);
        }else {

        }
    }

    @EventHandler
    public void breakBlock(BlockBreakEvent event) {
        Player p = event.getPlayer();
        if(!p.hasPermission("op.use")) {
            event.setCancelled(true);
        }else {
        }
    }


    @EventHandler
    public void food(FoodLevelChangeEvent event) {
        event.setFoodLevel(20);
    }

    @EventHandler
    public void Explotion(EntityDamageEvent event) {
        if ((event.getCause().equals(EntityDamageEvent.DamageCause.BLOCK_EXPLOSION)) || (event.getCause().equals(EntityDamageEvent.DamageCause.ENTITY_EXPLOSION))) {
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void CancelDamage(EntityDamageEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void PVP(EntityDamageByEntityEvent event) {
        event.setCancelled(true);
    }
    public Permission getVaultPermissions() {
        return this.perms;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }



    private static void setInstance(Main instance) {
        Main.instance = instance;
    }
    public static Main getPlugin() {
        return plugin;
    }
    public Event getEvent() {
        return this.servers;
    }






    public static Main getInstance() {
        return instance;
    }

}




















