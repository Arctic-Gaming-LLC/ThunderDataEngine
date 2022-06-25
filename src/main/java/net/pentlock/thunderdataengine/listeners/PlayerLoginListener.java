package net.pentlock.thunderdataengine.listeners;

import net.pentlock.thunderdataengine.ThunderDataEngine;
import net.pentlock.thunderdataengine.profiles.Guild;
import net.pentlock.thunderdataengine.profiles.ThunderPlayer;
import net.pentlock.thunderdataengine.utilities.GuildUtil;
import net.pentlock.thunderdataengine.utilities.PlayerUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

// This class sets all of the default stats for a player the first time they log in

public class PlayerLoginListener implements Listener {
    private Player player;

    @EventHandler
    public void onPlayerLoginEvent(PlayerLoginEvent event) {

        Player player = event.getPlayer();
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/PlayerData/" + player.getUniqueId() + ".json");
        if (file.exists()) {
            try {
                PlayerUtil.loadPlayer(player.getUniqueId());
            } catch (IOException e) {
                e.printStackTrace();
                ThunderDataEngine.getPlugin().log("Failed to load player " + player.getName());
            }
        } else {
            UUID playerUUID = player.getUniqueId();
            PlayerUtil.createPlayer(player.getName(), 0, 1, 0, "None", "world", 10, 10,
                    0, 0, 0, 0, 0, 0.0, 0.0, new Date(),
                    playerUUID, playerUUID, playerUUID, false, 0, 0, 0, 0,
                    0, 0, 0, 0, new String[0], System.currentTimeMillis(),
                    System.currentTimeMillis(), false, true, 0, 0, 0, 0, 0L, System.currentTimeMillis(), 1, 0.0,
                    new long[0], new double[0], new double[0], new double[0], new double[0], new double[0], new double[0], "New", new String[0]);

        }

        ThunderPlayer thunderPlayer = PlayerUtil.findPlayer(player.getUniqueId());

        assert thunderPlayer != null;
        thunderPlayer.setParty(player.getUniqueId());
        PlayerUtil.updatePlayer(thunderPlayer.getUUID(), thunderPlayer);

        File fileGuild = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/GuildData/" + thunderPlayer.getGuild() + ".json");
        if (fileGuild.exists()) {
            Guild guild = GuildUtil.findGuild(thunderPlayer.getGuild());
            if (guild == null) {
                try {
                    GuildUtil.loadGuild(thunderPlayer.getGuild());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
