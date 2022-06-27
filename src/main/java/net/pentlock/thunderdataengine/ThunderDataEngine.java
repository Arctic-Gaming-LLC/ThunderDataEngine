package net.pentlock.thunderdataengine;

import net.pentlock.thunderdataengine.listeners.PlayerLoginListener;
import net.pentlock.thunderdataengine.listeners.PlayerLogoutListener;
import net.pentlock.thunderdataengine.profiles.ThunderPlayer;
import net.pentlock.thunderdataengine.utilities.FileNameCleaner;
import net.pentlock.thunderdataengine.utilities.GuildUtil;
import net.pentlock.thunderdataengine.utilities.HouseUtil;
import net.pentlock.thunderdataengine.utilities.PlayerUtil;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.FileNotFoundException;
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
        initiateFiles();
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
        Set<UUID> listPlayerUUID = PlayerUtil.THUNDER_PLAYERS.keySet();
        for (UUID playerUUID : listPlayerUUID) {
            try {
                PlayerUtil.savePlayer(playerUUID);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Set<UUID> listGuildUUID = GuildUtil.GUILDS.keySet();
        for (UUID guildUUID : listGuildUUID) {
            try {
                GuildUtil.saveGuild(guildUUID);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        Set<String> listHouseName = HouseUtil.HOUSES.keySet();
        for (String houseName : listHouseName) {
            try {
                HouseUtil.saveHouse(houseName);
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

    public void initiateFiles() {
        String[] fileNames = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/HouseData").list();
        if (fileNames != null) {
            for (String fileName : fileNames) {
                String cleaner = new FileNameCleaner().fileNameCleaner(fileName);
                try {
                    HouseUtil.loadHouse(cleaner);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/GuildData/069a79f4-44e9-4726-a5be-fca90e38aaf5.json");
        if (!file.exists()) {
            UUID[] members = new UUID[1];
            members[0] = UUID.fromString("069a79f4-44e9-4726-a5be-fca90e38aaf5");
            GuildUtil.createGuild(UUID.fromString("069a79f4-44e9-4726-a5be-fca90e38aaf5"), 0,"No Guild",1,
                    UUID.fromString("069a79f4-44e9-4726-a5be-fca90e38aaf5"), UUID.fromString("069a79f4-44e9-4726-a5be-fca90e38aaf5"),
                    new UUID[0], members,16,"You do not have a guild.", 0,0,0,0,
                    0,0,0,0, false, "None", System.currentTimeMillis(),
                    System.currentTimeMillis(), false);
        } else {
            try {
                GuildUtil.loadGuild(UUID.fromString("069a79f4-44e9-4726-a5be-fca90e38aaf5"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }



    // Saves both player and guild to json every 5 mins
    public void runnableSaveJson() {
        new BukkitRunnable() {

            @Override
            public void run() {
                Set<UUID> listPlayerUUID = PlayerUtil.THUNDER_PLAYERS.keySet();
                for (UUID playerUUID : listPlayerUUID) {
                    try {
                        PlayerUtil.savePlayer(playerUUID);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Set<UUID> listGuildUUID = GuildUtil.GUILDS.keySet();
                for (UUID guildUUID : listGuildUUID) {
                    try {
                        GuildUtil.saveGuild(guildUUID);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Set<String> listHouseNames = HouseUtil.HOUSES.keySet();
                for (String houseName : listHouseNames) {
                    try {
                        HouseUtil.saveHouse(houseName);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }.runTaskTimerAsynchronously(this, 20, 6000);
    }
}
