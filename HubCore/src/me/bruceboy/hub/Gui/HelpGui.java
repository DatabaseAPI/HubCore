package me.bruceboy.hub.Gui;

import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class HelpGui implements CommandExecutor, Listener {
    private Inventory help;

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        help = Bukkit.getServer().createInventory(null, 9, ChatColor.GREEN + ChatColor.BOLD.toString() + "Help Menu");
        Player p = (Player) sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage("Cannot Use this command in console");
        }
        if (args.length == 0) {

            ArrayList<String> lore = new ArrayList<String>();
            ItemStack cmds = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta meta = cmds.getItemMeta();
            meta.setDisplayName("Commands");
            cmds.setItemMeta(meta);
            lore.add(ChatColor.GREEN + "Help Menu Commands");
            lore.add(ChatColor.translateAlternateColorCodes('&', "&a(!) &7/f"));
            meta.setLore(lore);


            help.setItem(4, cmds);

            p.openInventory(help);
        }
        return false;
    }
}

