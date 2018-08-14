package me.bruceboy.hub.scoreboard.utils;

import java.util.List;

import org.bukkit.entity.Player;

public interface ScoreboardProvider {

    String getTitle(Player player);

    String getHeader();

    String getFooter();

    List<String> getLinesFor(Player player);
}
