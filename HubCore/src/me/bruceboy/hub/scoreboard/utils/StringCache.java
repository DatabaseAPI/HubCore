package me.bruceboy.hub.scoreboard.utils;

import org.bukkit.ChatColor;

import java.util.HashMap;
import java.util.Map;

public class StringCache {

    private static final Map<String, String[]> CACHE = new HashMap<>();

    public static String[] get(String str) {
        if (CACHE.containsKey(str))
            return CACHE.get(str);

        String str1 = "";
        String str2 = "";

        String[] array = new String[2];
        if (str.length() <= 16) {
            str1 = str;
            str2 = "";
        } else {
            str1 = str.substring(0, 16);

            if (str.length() <= 32) {
                str2 = str.substring(16);
            } else {
                str2 = str.substring(16, 32);
            }
        }

        if (str1.endsWith(ChatColor.COLOR_CHAR + "")) {
            str1 = str1.substring(0, 15);
            str2 = ChatColor.COLOR_CHAR + str2;
        }

        if (!str2.startsWith(ChatColor.COLOR_CHAR + "")) {
            str2 = ChatColor.getLastColors(str1) + str2;
        }

        if (str1.length() > 16) str1 = str1.substring(0, 16);
        if (str2.length() > 16) str2 = str2.substring(0, 16);

        array[0] = str1;
        array[1] = str2;

        CACHE.put(str, array);
        return array;
    }

}

