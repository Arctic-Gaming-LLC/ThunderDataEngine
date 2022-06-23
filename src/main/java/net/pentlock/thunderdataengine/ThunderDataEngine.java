package net.pentlock.thunderdataengine;

import net.pentlock.thunderdataengine.listeners.PlayerLoginListener;
import net.pentlock.thunderdataengine.listeners.PlayerLogoutListener;
import net.pentlock.thunderdataengine.profiles.ThunderPlayer;
import net.pentlock.thunderdataengine.utilities.GuildUtil;
import net.pentlock.thunderdataengine.utilities.PlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.util.Set;
import java.util.UUID;

public final class ThunderDataEngine extends JavaPlugin implements Listener {
    public static ThunderDataEngine plugin;


    @Override
    public void onEnable() {
        plugin = this;

        // Creating config if its not there already
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        Bukkit.getPluginManager().registerEvents( this, this);
        final PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new PlayerLoginListener(), this);
        pm.registerEvents(new PlayerLogoutListener(), this);

        runnableSaveJson();
    }

    @Override
    public void onDisable() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player != null) {
                if (!player.hasMetadata("NPC")) {
                    ThunderPlayer thunderPlayer = PlayerUtil.findPlayer(player.getUniqueId());
                    thunderPlayer.setParty(player.getUniqueId());
                    PlayerUtil.updatePlayer(player.getUniqueId(), thunderPlayer);
                }
            }
        }
        Set<UUID> listPlayerUUID = PlayerUtil.thunderPlayers.keySet();
        for (UUID playerUUID : listPlayerUUID) {
            try {
                PlayerUtil.savePlayer(playerUUID);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Set<UUID> listGuildUUID = GuildUtil.guilds.keySet();
        for (UUID guildUUID : listGuildUUID) {
            try {
                GuildUtil.saveGuild(guildUUID);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static ThunderDataEngine getPlugin() {
        return plugin;
    }

    //quick logging
    public void log(String log){
        plugin.getLogger().info(ChatColor.BLUE + log);
    }

    // Saves both player and guild to json every 5 mins
    public void runnableSaveJson() {
        new BukkitRunnable() {

            @Override
            public void run() {
                Set<UUID> listPlayerUUID = PlayerUtil.thunderPlayers.keySet();
                for (UUID playerUUID : listPlayerUUID) {
                    try {
                        PlayerUtil.savePlayer(playerUUID);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Set<UUID> listGuildUUID = GuildUtil.guilds.keySet();
                for (UUID guildUUID : listGuildUUID) {
                    try {
                        GuildUtil.saveGuild(guildUUID);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.runTaskTimerAsynchronously(this, 20, 6000);
    }
}
