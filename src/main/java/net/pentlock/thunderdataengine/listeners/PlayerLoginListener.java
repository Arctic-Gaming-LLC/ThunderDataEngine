package net.pentlock.thunderdataengine.listeners;

import net.pentlock.thunderdataengine.ThunderDataEngine;
import net.pentlock.thunderdataengine.profiles.Guild;
import net.pentlock.thunderdataengine.profiles.ThunderPlayer;
import net.pentlock.thunderdataengine.utilities.GuildUtil;
import net.pentlock.thunderdataengine.utilities.PlayerUtil;
import net.pentlock.thunderdataengine.validator.PlayerValidator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// This class sets all of the default stats for a player the first time they log in

public class PlayerLoginListener implements Listener {
    private Player player;

    @EventHandler
    public void onPlayerLoginEvent(PlayerLoginEvent event) {

        //on player login - see if player data exists and load it - otherwise, create a new player
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
                    System.currentTimeMillis(), false, true, 0, 0, 0, 0,
                    0L, System.currentTimeMillis(), 1, 0.0, new long[0], new double[0], new double[0],
                    new double[0], new double[0], new double[0], new double[0], "New", new String[0], new double[0], runSessionSetup(), "", player.getName());

        }

        ThunderPlayer thunderPlayer = PlayerUtil.findPlayer(player.getUniqueId());

        // Clears a player's party on login - ensures that parties are not stored locally

        thunderPlayer.setParty(player.getUniqueId());

        // Validation of files
        new PlayerValidator(thunderPlayer, player);

        // Handles login times
        thunderPlayer.setLogin(System.currentTimeMillis());
        thunderPlayer.setTimesLoggedIn(thunderPlayer.getTimesLoggedIn() + 1);
        PlayerUtil.updatePlayer(thunderPlayer.getUUID(), thunderPlayer);


        // Checks to see if the player's guild exists by searching for its file
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

    private Map<String, double[]> runSessionSetup() {
        Map<String, double[]> sessionStats = new HashMap<>();

        sessionStats.put("pvpDamage", new double[0]);
        sessionStats.put("pvpDefenseDamage", new double[0]);
        sessionStats.put("pveDamage", new double[0]);
        sessionStats.put("pveDefenseDamage", new double[0]);
        sessionStats.put("wealthGain", new double[0]);
        sessionStats.put("moneyDrops", new double[0]);
        sessionStats.put("pvpDamageAve", new double[0]);
        sessionStats.put("pvpDefenseDamageAve", new double[0]);
        sessionStats.put("pveDamageAve", new double[0]);
        sessionStats.put("pveDefenseDamageAve", new double[0]);
        sessionStats.put("wealthGainAve", new double[0]);
        sessionStats.put("moneyDropsAve", new double[0]);

        return sessionStats;
    }
}
