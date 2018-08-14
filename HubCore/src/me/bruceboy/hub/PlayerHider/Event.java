package me.bruceboy.hub.PlayerHider;

import java.util.ArrayList;
import java.util.Arrays;

import me.bruceboy.hub.BungeeEvents;
import me.bruceboy.hub.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class Event extends BukkitRunnable implements Listener {

    private Inventory inv;
    private Inventory hcf;
    private BungeeEvents pluginMessage = new BungeeEvents();

    public void run() {

    }
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player p = event.getPlayer();

        ItemMeta os1meta = p.getItemInHand().getItemMeta();
        inv = Bukkit.getServer().createInventory(null, 9, ChatColor.GREEN + ChatColor.BOLD.toString() + "Server Selector");
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (p.getInventory().getItemInHand().getType() == Material.COMPASS && os1meta.getDisplayName()
                    .equals(ChatColor.GRAY + "Server Selector")) {
                p.sendMessage(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "FREESRC §7»" + ChatColor.GRAY + " Opening Server Selector");

                ItemStack empty = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 15);
                ItemMeta emptyMeta = empty.getItemMeta();
                emptyMeta.setDisplayName("'");
                empty.setItemMeta(emptyMeta);

                ItemStack hcf = new ItemStack(Material.FISHING_ROD);
                ItemMeta hmeta = hcf.getItemMeta();
                hmeta.setDisplayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "HCF");
                hcf.setItemMeta(hmeta);

                ItemStack kitmap = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemMeta kmeta = kitmap.getItemMeta();
                kmeta.setDisplayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Kitmap");

                kitmap.setItemMeta(kmeta);

                ItemStack prac = new ItemStack(Material.DIAMOND_SWORD);
                ItemMeta Pmeta = prac.getItemMeta();
                Pmeta.setDisplayName(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Practice");

                prac.setItemMeta(Pmeta);



                inv.setItem(0, empty);
                inv.setItem(1, hcf);
                inv.setItem(2, empty);
                inv.setItem(3, empty);
                inv.setItem(4, kitmap);
                inv.setItem(6, empty);
                inv.setItem(7, prac);
                inv.setItem(8, empty);
                p.openInventory(inv);
            }
        }
    }


    @SuppressWarnings("unused")
    @EventHandler
    public void InvenClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        org.bukkit.inventory.PlayerInventory pi = p.getInventory();

        Inventory open = event.getInventory();
        ItemStack item = event.getCurrentItem();

        if (open == null) {
            return;
        }
        if (open.getName().equals(ChatColor.GREEN + ChatColor.BOLD.toString() + "Server Selector")) {

            event.setCancelled(true);

            if (item == null || !item.hasItemMeta()) {
                return;
            }
            if (open == null) {
                return;
            }

            if (open == null) {
                return;
            } else if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Kitmap")) {
                p.closeInventory();
                p.sendMessage(ChatColor.DARK_RED + ChatColor.BOLD.toString() + " §7» " + ChatColor.GRAY + "You Are Being Connected To §4§lKitmap");
                pluginMessage.connectserver(p, "Kitmap");
            }
            if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "practice")) {
                p.sendMessage(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "" + ChatColor.GRAY + "» " + ChatColor.GRAY + "Sorry " + ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Practice " + ChatColor.GRAY + "Is In Development!");
                p.closeInventory();
            } else if (item.getItemMeta().getDisplayName().equals(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "HCF")) {
                p.closeInventory();
                p.sendMessage(ChatColor.DARK_RED + ChatColor.BOLD.toString() + "ERROR §7» " + ChatColor.GRAY + "You Are Being Connected To §4§lHCF");
                pluginMessage.connectserver(p,"factions");



            }
        }
    }
}
