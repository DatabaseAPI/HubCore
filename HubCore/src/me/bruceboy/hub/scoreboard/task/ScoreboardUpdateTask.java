package me.bruceboy.hub.scoreboard.task;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import me.bruceboy.hub.scoreboard.PlayerBoard;

public class ScoreboardUpdateTask extends BukkitRunnable {

    @Override
    public void run() {
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            PlayerBoard.get(p).send();
        }
    }

}

