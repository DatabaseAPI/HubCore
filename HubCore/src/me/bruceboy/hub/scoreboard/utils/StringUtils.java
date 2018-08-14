package me.bruceboy.hub.scoreboard.utils;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public class StringUtils {

    private static Map<UUID, String> stringMap = new HashMap<>();

    private static Random r = new Random();
    private static char[] chars = new char[]{
            'A', 'B', 'C', 'D', 'E',
            'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O',
            'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y',
            'Z', 'a', 'b', 'c', 'd',
            'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x',
            'y', 'z', '1', '2', '3',
            '4', '5', '6', '7', '8',
            '9', '0'
    };

    public static String getRandomString(int length) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            builder.append(chars[r.nextInt(chars.length)]);
        }

        return builder.toString();
    }

    public static String getScoreboardId(Player player) {
        UUID uuid = player.getUniqueId();

        if (!stringMap.containsKey(uuid)) {
            stringMap.put(uuid, getRandomString(6));

            return stringMap.get(uuid);
        } else {
            return stringMap.get(uuid);
        }
    }
}