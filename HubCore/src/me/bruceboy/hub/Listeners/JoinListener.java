package me.bruceboy.hub.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class JoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        e.setJoinMessage(null);
        Player p = e.getPlayer();
        p.sendMessage(ChatColor.GRAY + "Welcome " + p.getName() + ChatColor.GRAY +  " To " + ChatColor.DARK_RED + ChatColor.BOLD.toString() +  "FREESRC");


        ItemStack selector = new ItemStack(Material.COMPASS);
        ItemMeta meta =  selector.getItemMeta();
        meta.setDisplayName(ChatColor.GRAY + "Server Selector");
        selector.setItemMeta(meta);

        p.getInventory().setItem(4, selector);
    }
}
