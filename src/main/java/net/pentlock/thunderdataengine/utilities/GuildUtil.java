package net.pentlock.thunderdataengine.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.pentlock.thunderdataengine.ThunderDataEngine;
import net.pentlock.thunderdataengine.profiles.Guild;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class GuildUtil {
    //TODO add chat color for guilds
    public static final Map<UUID, Guild> GUILDS = new HashMap<>();

    /**
     * <h3>Creates a new Guild Instance</h3>
     *
     * @param uuid
     * @param bankBalance
     * @param name
     * @param level
     * @param leader
     * @param coLeader
     * @param officers
     * @param members
     * @param maxMembers
     * @param messageBoard
     * @param points
     * @param physicalDefensePoints
     * @param archeryDefensePoints
     * @param physicalOffensePoints
     * @param archeryOffensePoints
     * @param healthPoints
     * @param criticalStrikePoints
     * @param criticalPowerPoints
     * @param boostActive
     * @param activeBoost
     * @param boostTime
     * @param refreshTime
     * @param refreshActive
     * @return
     */
    public static Guild createGuild(UUID uuid, double bankBalance, String name, int level, UUID leader, UUID coLeader, UUID[] officers, UUID[] members,
                                    int maxMembers, String messageBoard, int points, int physicalDefensePoints, int archeryDefensePoints, int physicalOffensePoints,
                                    int archeryOffensePoints, int healthPoints, int criticalStrikePoints, int criticalPowerPoints, boolean boostActive, String activeBoost,
                                    long boostTime, long refreshTime, boolean refreshActive, String color) {
        Guild guild = new Guild(uuid, bankBalance, name, level, leader, coLeader, officers, members, maxMembers, messageBoard, points, physicalDefensePoints, archeryDefensePoints,
                physicalOffensePoints, archeryOffensePoints, healthPoints, criticalStrikePoints, criticalPowerPoints, boostActive, activeBoost, boostTime, refreshTime, refreshActive, color);

        GUILDS.put(uuid, guild);

        try {
            saveGuild(uuid);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return guild;
    }

    /**
     * <h3>Guild Deletions</h3>
     * removes a guild and its files
     *
     * @param uuid
     */
    public static void deleteGuild(UUID uuid) {
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/GuildData/" + uuid.toString() + ".json");
        if (file.exists()) {
            file.delete();
        }
        GUILDS.remove(uuid);
    }

    /**
     * <h3>Find Guild</h3>
     * returns a guild based on UUID
     *
     * @param uuid
     * @return returns either a Loaded Guild Instance OR queried player's UUID
     */
    public static Guild findGuild(UUID uuid) {
        return GUILDS.get(uuid);
    }

    /**
     * <h3>Update Guild</h3>
     * Updates a Guild Instance and Saves it to file
     *
     * @param uuid Guild to update
     * @param newGuild New updated Guild Instance
     * @return Guild Instances
     */
    public static Guild updateGuild(UUID uuid, Guild newGuild) {

        Guild guild = GUILDS.get(uuid);

        guild.setBankBalance(newGuild.getBankBalance());
        guild.setName(newGuild.getName());
        guild.setLevel(newGuild.getLevel());
        guild.setLeader(newGuild.getLeader());
        guild.setCoLeader(newGuild.getCoLeader());
        guild.setOfficers(newGuild.getOfficers());
        guild.setMembers(newGuild.getMembers());
        guild.setMaxMembers(newGuild.getMaxMembers());
        guild.setMessageBoard(newGuild.getMessageBoard());
        guild.setPoints(newGuild.getPoints());
        guild.setPhysicalDefensePoints(newGuild.getPhysicalDefensePoints());
        guild.setArcheryDefensePoints(newGuild.getArcheryDefensePoints());
        guild.setPhysicalOffensePoints(newGuild.getPhysicalOffensePoints());
        guild.setArcheryOffensePoints(newGuild.getArcheryOffensePoints());
        guild.setHealthPoints(newGuild.getHealthPoints());
        guild.setCriticalStrikePoints(newGuild.getCriticalStrikePoints());
        guild.setCriticalPowerPoints(newGuild.getCriticalPowerPoints());
        guild.setBoostActive(newGuild.isBoostActive());
        guild.setBoostType(newGuild.getBoostType());
        guild.setBoostTime(newGuild.getBoostTime());
        guild.setRefreshTime(newGuild.getRefreshTime());
        guild.setRefreshActive(newGuild.isRefreshActive());


        try {
            saveGuild(uuid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return guild;
    }

    /**
     * <H3>Save Guild to File</H3>
     * @param uuid
     * @throws IOException
     */
    public static void saveGuild(UUID uuid) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/GuildData/" + uuid + ".json");
        if (!file.exists()) {
            file.getParentFile().mkdir();
        }

        file.createNewFile();
        Guild guild = GUILDS.get(uuid);
        if (guild != null) {
            Writer writer = new FileWriter(file, false);
            gson.toJson(guild, writer);
            writer.flush();
            writer.close();
        }
    }

    /**
     * <h3>Load a Guild from File</h3>
     * @param uuid
     * @throws FileNotFoundException
     */
    public static void loadGuild(UUID uuid) throws FileNotFoundException {
        Gson gson = new Gson();
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/GuildData/" + uuid + ".json");

        if (file.exists()) {
            Reader reader = new FileReader(file);
            Guild guild = gson.fromJson(reader, Guild.class);
            GUILDS.put(uuid, guild);
        }
    }

    /**
     * <h3> Unload a Guild</h3>
     * saves Queried guild and unloads it from memory
     * @param uuid
     */
    public static void unLoadGuild(UUID uuid) {
        try {
            saveGuild(uuid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        GUILDS.remove(uuid);
    }
}

