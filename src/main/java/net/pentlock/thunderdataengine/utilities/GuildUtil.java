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

    public static final Map<UUID, Guild> guilds = new HashMap<>();

    public static Guild createGuild(UUID uuid, double bankBalance, String name, int level, UUID leader, UUID coLeader, UUID[] officers, UUID[] members,
                                    int maxMembers, String messageBoard, int points, int physicalDefensePoints, int archeryDefensePoints, int physicalOffensePoints,
                                    int archeryOffensePoints, int healthPoints, int criticalStrikePoints, int criticalPowerPoints, boolean boostActive, String activeBoost,
                                    long boostTime, long refreshTime, boolean refreshActive) {
        Guild guild = new Guild(uuid, bankBalance, name, level, leader, coLeader, officers, members, maxMembers, messageBoard, points, physicalDefensePoints, archeryDefensePoints,
                physicalOffensePoints, archeryOffensePoints, healthPoints, criticalStrikePoints, criticalPowerPoints, boostActive, activeBoost, boostTime, refreshTime, refreshActive);

        guilds.put(uuid, guild);

        try {
            saveGuild(uuid);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return guild;
    }

    public static void deleteGuild(UUID uuid) {
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/GuildData/" + uuid.toString() + ".json");
        if (file.exists()) {
            file.delete();
        }
    }

    public static Guild findGuild(UUID uuid) {
        return guilds.get(uuid);
    }

    public static Guild updateGuild(UUID uuid, Guild newGuild) {

        Guild guild = guilds.get(uuid);

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


    public static void saveGuild(UUID uuid) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/GuildData/" + uuid + ".json");
        if (!file.exists()) {
            file.getParentFile().mkdir();
        }

        file.createNewFile();
        Guild guild = guilds.get(uuid);
        if (guild != null) {
            Writer writer = new FileWriter(file, false);
            gson.toJson(guild, writer);
            writer.flush();
            writer.close();
        }
    }

    public static void loadGuild(UUID uuid) throws FileNotFoundException {
        Gson gson = new Gson();
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/GuildData/" + uuid + ".json");

        if (file.exists()) {
            Reader reader = new FileReader(file);
            Guild guild = gson.fromJson(reader, Guild.class);
            guilds.put(uuid, guild);
        }
    }

    public static void unLoadGuild(UUID uuid) {
        try {
            saveGuild(uuid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        guilds.remove(uuid);
    }
}
