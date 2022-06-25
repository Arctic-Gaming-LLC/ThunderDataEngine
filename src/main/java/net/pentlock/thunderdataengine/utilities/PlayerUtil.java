package net.pentlock.thunderdataengine.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.pentlock.thunderdataengine.ThunderDataEngine;
import net.pentlock.thunderdataengine.profiles.ThunderPlayer;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerUtil {


    public static final Map<UUID, ThunderPlayer> THUNDER_PLAYERS = new HashMap<>();

    public static ThunderPlayer createPlayer(String name, double money, int level, long exp, String grave, String graveWorld, int maxHealth, double currentHealth,
                                             int luck, int physicalDefense, int archeryDefense, int physicalOffense, int archeryOffense, double criticalStrike,
                                             double criticalPower, Date dateCreated, UUID uuid, UUID guild, UUID party, boolean pvpEnabled, int perkPoints,
                                             int physicalDefensePerkPoints, int archeryDefensePerkPoints, int physicalOffensePerkPoints, int archeryOffensePerkPoints,
                                             int healthPerkPoints, int criticalStrikePerkPoints, int criticalPowerPerkPoints, UUID[] houses,
                                             long logout, long login, boolean godMode, boolean acceptingPay, int playerKills, int mobKills, int deaths, int fallDeaths,
                                             long totalPlayTime, long lastDeathTime, int timesLoggedIn, double moneyFromDrops, long[] dataPlayTime,
                                             double[] dataPvpDamage, double[] dataPvpDefenseDamage, double[] dataPveDamage, double[] dataPveDefenseDamage,
                                             double[] dataWealthGain, double[] dataMoneyDrops, String tag, String[] lastKnownLocation) {

        ThunderPlayer thunderPlayer = new ThunderPlayer(name, money, level, exp, grave, graveWorld, maxHealth, currentHealth, luck, physicalDefense, archeryDefense,
                physicalOffense, archeryOffense, criticalStrike, criticalPower, dateCreated, uuid, guild, party, pvpEnabled, perkPoints,
                physicalDefensePerkPoints, archeryDefensePerkPoints, physicalOffensePerkPoints, archeryOffensePerkPoints, healthPerkPoints,
                criticalStrikePerkPoints, criticalPowerPerkPoints, houses, logout, login, godMode, acceptingPay, playerKills,
                mobKills, deaths, fallDeaths, totalPlayTime, lastDeathTime, timesLoggedIn, moneyFromDrops, dataPlayTime, dataPvpDamage,
                dataPvpDefenseDamage, dataPveDamage, dataPveDefenseDamage, dataWealthGain, dataMoneyDrops, tag, lastKnownLocation);

        THUNDER_PLAYERS.put(uuid, thunderPlayer);

        try {
            savePlayer(uuid);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return thunderPlayer;
    }

    public static void deletePlayer(UUID uuid) {
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/PlayerData/" + uuid.toString() + ".json");
        if (file.exists()) {
            file.delete();
        }
    }

    public static ThunderPlayer findPlayer(UUID uuid) {
        return THUNDER_PLAYERS.get(uuid);
    }

    public static ThunderPlayer updatePlayer(UUID uuid, ThunderPlayer newThunderPlayer) {
        ThunderPlayer thunderPlayer = THUNDER_PLAYERS.get(uuid);

        thunderPlayer.setName(newThunderPlayer.getName());
        thunderPlayer.setMoney(newThunderPlayer.getMoney());
        thunderPlayer.setLevel(newThunderPlayer.getLevel());
        thunderPlayer.setExp(newThunderPlayer.getExp());
        thunderPlayer.setGrave(newThunderPlayer.getGrave());
        thunderPlayer.setGraveWorld(newThunderPlayer.getGraveWorld());
        thunderPlayer.setMaxHealth(newThunderPlayer.getMaxHealth());
        thunderPlayer.setCurrentHealth(newThunderPlayer.getCurrentHealth());
        thunderPlayer.setLuck(newThunderPlayer.getLuck());
        thunderPlayer.setPhysicalDefense(newThunderPlayer.getPhysicalDefense());
        thunderPlayer.setArcheryDefense(newThunderPlayer.getArcheryDefense());
        thunderPlayer.setPhysicalOffense(newThunderPlayer.getPhysicalOffense());
        thunderPlayer.setCriticalStrike(newThunderPlayer.getCriticalStrike());
        thunderPlayer.setCriticalPower(newThunderPlayer.getCriticalPower());
        thunderPlayer.setDateCreated(newThunderPlayer.getDateCreated());
        thunderPlayer.setUUID(newThunderPlayer.getUUID());
        thunderPlayer.setGuild(newThunderPlayer.getGuild());
        thunderPlayer.setParty(newThunderPlayer.getParty());
        thunderPlayer.setPvpEnabled(newThunderPlayer.isPvpEnabled());
        thunderPlayer.setPerkPoints(newThunderPlayer.getPerkPoints());
        thunderPlayer.setPhysicalDefensePerkPoints(newThunderPlayer.getPhysicalDefensePerkPoints());
        thunderPlayer.setArcheryDefensePerkPoints(newThunderPlayer.getArcheryDefensePerkPoints());
        thunderPlayer.setPhysicalOffensePerkPoints(newThunderPlayer.getPhysicalOffensePerkPoints());
        thunderPlayer.setArcheryOffensePerkPoints(newThunderPlayer.getArcheryOffensePerkPoints());
        thunderPlayer.setHealthPerkPoints(newThunderPlayer.getHealthPerkPoints());
        thunderPlayer.setCriticalStrikePerkPoints(newThunderPlayer.getCriticalStrikePerkPoints());
        thunderPlayer.setCriticalPowerPerkPoints(newThunderPlayer.getCriticalPowerPerkPoints());
        thunderPlayer.setHouses(newThunderPlayer.getHouses());
        thunderPlayer.setLogout(newThunderPlayer.getLogout());
        thunderPlayer.setLogin(newThunderPlayer.getLogin());
        thunderPlayer.setGodMode(newThunderPlayer.isGodMode());
        thunderPlayer.setAcceptingPay(newThunderPlayer.isAcceptingPay());
        thunderPlayer.setPlayerKills(newThunderPlayer.getPlayerKills());
        thunderPlayer.setMobKills(newThunderPlayer.getMobKills());
        thunderPlayer.setDeaths(newThunderPlayer.getDeaths());
        thunderPlayer.setFallDeaths(newThunderPlayer.getFallDeaths());
        thunderPlayer.setTotalPlayTime(newThunderPlayer.getTotalPlayTime());
        thunderPlayer.setLastDeathTime(newThunderPlayer.getLastDeathTime());
        thunderPlayer.setTimesLoggedIn(newThunderPlayer.getTimesLoggedIn());
        thunderPlayer.setMoneyFromDrops(newThunderPlayer.getMoneyFromDrops());
        thunderPlayer.setDataPlayTime(newThunderPlayer.getDataPlayTime());
        thunderPlayer.setDataPveDamage(newThunderPlayer.getDataPvpDamage());
        thunderPlayer.setDataPvpDefenseDamage(newThunderPlayer.getDataPvpDefenseDamage());
        thunderPlayer.setDataPveDamage(newThunderPlayer.getDataPveDamage());
        thunderPlayer.setDataPveDefenseDamage(newThunderPlayer.getDataPveDefenseDamage());
        thunderPlayer.setDataWealthGain(newThunderPlayer.getDataWealthGain());
        thunderPlayer.setDataMoneyDrops(newThunderPlayer.getDataMoneyDrops());
        thunderPlayer.setTag(newThunderPlayer.getTag());
        thunderPlayer.setLastKnownLocation(newThunderPlayer.getLastKnownLocation());

        return thunderPlayer;
    }

    public static void savePlayer(UUID uuid) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/PlayerData/" + uuid.toString() + ".json");
        if (!file.exists()) {
            file.getParentFile().mkdir();
        }

        file.createNewFile();

        ThunderPlayer thunderPlayer = THUNDER_PLAYERS.get(uuid);
        if (thunderPlayer != null) {
            Writer writer = new FileWriter(file);
            gson.toJson(thunderPlayer, writer);
            writer.flush();
            writer.close();
        }
    }

    public static void loadPlayer(UUID uuid) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/PlayerData/" + uuid.toString() + ".json");
        if (file.exists()) {
            ThunderPlayer thunderPlayer = gson.fromJson(new FileReader(file), ThunderPlayer.class);
            THUNDER_PLAYERS.put(uuid, thunderPlayer);
        }
    }

    public static void unloadPlayer(UUID uuid) {
        try {
            savePlayer(uuid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        THUNDER_PLAYERS.remove(uuid);
    }
}
