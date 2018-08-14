package me.bruceboy.hub.scoreboard.board;

import me.bruceboy.hub.BungeeEvents;
import me.bruceboy.hub.Main;
import me.bruceboy.hub.scoreboard.utils.ScoreboardProvider;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;


public class HubScoreboard implements ScoreboardProvider {

    private static HubScoreboard instance;
    private BungeeEvents pluginMessage = new BungeeEvents();


    public String getTitle(Player player) {
        return ChatColor.DARK_RED.toString() + ChatColor.BOLD + "     FreeSrc Network      ";
    }


    public String getHeader() {
        return ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "------------------------------------";
    }


    public String getFooter() {
        return ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "------------------------------------";
    }


    public List<String> getLinesFor(Player player) {
        List<String> lines = new ArrayList<>();

        lines.add(ChatColor.RED + "Online Players §7» ");
        lines.add("" + (pluginMessage.hcfcount + pluginMessage.kmcount + pluginMessage.hubcount));

        lines.add(" ");

        lines.add(ChatColor.RED + "Your Rank §7»");
        lines.add(ChatColor.WHITE + Main.getPlugin().getVaultPermissions().getPrimaryGroup(player));

        lines.add(" ");

        lines.add(ChatColor.RED + "Website: ");
        lines.add("www.srcforfree.com");
        return lines;
    }





    
    public static ScoreboardProvider getInstance() {
        return (instance == null ? new HubScoreboard() : instance);
    }

}
