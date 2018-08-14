package me.bruceboy.hub;

import org.bukkit.entity.Player;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;



public class BungeeEvents implements PluginMessageListener {

    private Main plugin = Main.getInstance();
    public int hcfcount = 0;
    public int hubcount = 0;
    public boolean hubonline = false;
    public int kmcount = 0;
    public boolean hcfonline = false;
    public boolean kmonline = false;

    public void checkHCFCount(Player player){
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("PlayerCount");
        out.writeUTF("HCF");
        player.sendPluginMessage(plugin,"BungeeCord", out.toByteArray());
    }

    public void checkKMCount(Player player){
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("PlayerCount");
        out.writeUTF("Kitmap");
        player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
    }

    public void checkHubCount(Player player){
        ByteArrayDataOutput out = ByteStreams.newDataOutput();
        out.writeUTF("PlayerCount");
        out.writeUTF("Hub");
        player.sendPluginMessage(plugin, "BungeeCord", out.toByteArray());
    }

    public void onPluginMessageReceived(String s, Player player, byte[] bytes) {
        if (s.equals("BungeeCord")) {
            ByteArrayDataInput byteArrayDataInput = ByteStreams.newDataInput(bytes);
            String subchannel = byteArrayDataInput.readUTF();
            if (subchannel.equals("PlayerCount")) {
                String server = byteArrayDataInput.readUTF();


                try {
                    if (server.equalsIgnoreCase("HCF")) {
                        hcfcount = byteArrayDataInput.readInt();
                    }

                    if (server.equalsIgnoreCase("Kitmap")) {
                        kmcount = byteArrayDataInput.readInt();
                    }

                    if (server.equalsIgnoreCase("Hub")) {
                        hubcount = byteArrayDataInput.readInt();
                    }

                } catch (Exception ex) {

                    hcfcount = -1;
                    hcfonline = false;

                    hubcount = -1;
                    hubonline = false;

                    kmcount = -1;
                    kmonline = false;

                }
            }
        }
    }
    public void connectserver(Player player, String server) {
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("Connect");
        output.writeUTF(server);
        player.sendPluginMessage(plugin, "BungeeCord", output.toByteArray());



    }
    public void playercount(Player player, String server) {
        ByteArrayDataOutput output = ByteStreams.newDataOutput();
        output.writeUTF("playercount");
        output.writeUTF(server);
        player.sendPluginMessage(plugin, "BungeeCord", output.toByteArray());
    }


}
