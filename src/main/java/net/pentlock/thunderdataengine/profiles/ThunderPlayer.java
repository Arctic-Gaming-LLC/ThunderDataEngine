package net.pentlock.thunderdataengine.profiles;

import java.util.Date;
import java.util.UUID;

public class ThunderPlayer {
    private String name;
    private double money;
    private int level;
    private long exp;
    private String grave;
    private String graveWorld;
    private int maxHealth;
    private double currentHealth;
    private int luck;
    private int physicalDefense;
    private int archeryDefense;
    private int physicalOffense;
    private int archeryOffense;
    private double criticalStrike;
    private double criticalPower;
    private Date dateCreated;
    private UUID uuid;
    private UUID guild;
    private UUID party;
    private boolean pvpEnabled;
    private int perkPoints;
    private int physicalDefensePerkPoints;
    private int archeryDefensePerkPoints;
    private int physicalOffensePerkPoints;
    private int archeryOffensePerkPoints;
    private int healthPerkPoints;
    private int criticalStrikePerkPoints;
    private int criticalPowerPerkPoints;
    private String[] houses;
    private long logout;
    private long login;
    private boolean godMode;
    private boolean acceptingPay;
    private int playerKills;
    private int mobKills;
    private int deaths;
    private int fallDeaths;
    private long totalPlayTime;
    private long lastDeathTime;
    private int timesLoggedIn;
    private double moneyFromDrops;
    private long[] dataPlayTime;
    private double[] dataPvpDamage;
    private double[] dataPvpDefenseDamage;
    private double[] dataPveDamage;
    private double[] dataPveDefenseDamage;
    private double[] dataWealthGain;
    private double[] dataMoneyDrops;
    private String tag;
    private String[] lastKnownLocation;

    public ThunderPlayer(String name, double money, int level, long exp, String grave, String graveWorld, int maxHealth, double currentHealth,
                         int luck, int physicalDefense, int archeryDefense, int physicalOffense, int archeryOffense, double criticalStrike,
                         double criticalPower, Date dateCreated, UUID uuid, UUID guild, UUID party, boolean pvpEnabled, int perkPoints,
                         int physicalDefensePerkPoints, int archeryDefensePerkPoints, int physicalOffensePerkPoints, int archeryOffensePerkPoints,
                         int healthPerkPoints, int criticalStrikePerkPoints, int criticalPowerPerkPoints, String[] houses,
                         long logout, long login, boolean godMode, boolean acceptingPay, int playerKills, int mobKills, int deaths, int fallDeaths,
                         long totalPlayTime, long lastDeathTime, int timesLoggedIn, double moneyFromDrops, long[] dataPlayTime, double[] dataPvpDamage,
                         double[] dataPvpDefenseDamage, double[] dataPveDamage, double[] dataPveDefenseDamage, double[] dataWealthGain,
                         double[] dataMoneyDrops, String tag, String[] lastKnownLocation) {
        this.name = name;
        this.money = money;
        this.level = level;
        this.exp = exp;
        this.grave = grave;
        this.graveWorld = graveWorld;
        this.maxHealth = maxHealth;
        this.currentHealth = currentHealth;
        this.luck = luck;
        this.physicalDefense = physicalDefense;
        this.archeryDefense = archeryDefense;
        this.physicalOffense = physicalOffense;
        this.archeryOffense = archeryOffense;
        this.criticalStrike = criticalStrike;
        this.criticalPower = criticalPower;
        this.dateCreated = dateCreated;
        this.uuid = uuid;
        this.guild = guild;
        this.party = party;
        this.pvpEnabled = pvpEnabled;
        this.perkPoints = perkPoints;
        this.physicalDefensePerkPoints = physicalDefensePerkPoints;
        this.archeryDefensePerkPoints = archeryDefensePerkPoints;
        this.physicalOffensePerkPoints = physicalOffensePerkPoints;
        this.archeryOffensePerkPoints = archeryOffensePerkPoints;
        this.healthPerkPoints = healthPerkPoints;
        this.criticalStrikePerkPoints = criticalStrikePerkPoints;
        this.criticalPowerPerkPoints = criticalPowerPerkPoints;
        this.houses = houses;
        this.logout = logout;
        this.login = login;
        this.godMode = godMode;
        this.acceptingPay = acceptingPay;
        this.playerKills = playerKills;
        this.mobKills = mobKills;
        this.deaths = deaths;
        this.fallDeaths = fallDeaths;
        this.totalPlayTime = totalPlayTime;
        this.lastDeathTime = lastDeathTime;
        this.timesLoggedIn = timesLoggedIn;
        this.moneyFromDrops = moneyFromDrops;
        this.dataPlayTime = dataPlayTime;
        this.dataPvpDamage = dataPvpDamage;
        this.dataPvpDefenseDamage = dataPvpDefenseDamage;
        this.dataPveDamage = dataPveDamage;
        this.dataPveDefenseDamage = dataPveDefenseDamage;
        this.dataWealthGain = dataWealthGain;
        this.dataMoneyDrops = dataMoneyDrops;
        this.tag = tag;
        this.lastKnownLocation = lastKnownLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }

    public String getGrave() {
        return grave;
    }

    public void setGrave(String grave) {
        this.grave = grave;
    }

    public String getGraveWorld() {
        return graveWorld;
    }

    public void setGraveWorld(String graveWorld) {
        this.graveWorld = graveWorld;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(double currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getPhysicalDefense() {
        return physicalDefense;
    }

    public void setPhysicalDefense(int physicalDefense) {
        this.physicalDefense = physicalDefense;
    }

    public int getArcheryDefense() {
        return archeryDefense;
    }

    public void setArcheryDefense(int archeryDefense) {
        this.archeryDefense = archeryDefense;
    }

    public int getPhysicalOffense() {
        return physicalOffense;
    }

    public void setPhysicalOffense(int physicalOffense) {
        this.physicalOffense = physicalOffense;
    }

    public int getArcheryOffense() {
        return archeryOffense;
    }

    public void setArcheryOffense(int archeryOffense) {
        this.archeryOffense = archeryOffense;
    }

    public double getCriticalStrike() {
        return criticalStrike;
    }

    public void setCriticalStrike(double criticalStrike) {
        this.criticalStrike = criticalStrike;
    }

    public double getCriticalPower() {
        return criticalPower;
    }

    public void setCriticalPower(double criticalPower) {
        this.criticalPower = criticalPower;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getGuild() {
        return guild;
    }

    public void setGuild(UUID guild) {
        this.guild = guild;
    }

    public UUID getParty() {
        return party;
    }

    public void setParty(UUID party) {
        this.party = party;
    }

    public boolean isPvpEnabled() {
        return pvpEnabled;
    }

    public void setPvpEnabled(boolean pvpEnabled) {
        this.pvpEnabled = pvpEnabled;
    }

    public int getPerkPoints() {
        return perkPoints;
    }

    public void setPerkPoints(int perkPoints) {
        this.perkPoints = perkPoints;
    }

    public int getPhysicalDefensePerkPoints() {
        return physicalDefensePerkPoints;
    }

    public void setPhysicalDefensePerkPoints(int physicalDefensePerkPoints) {
        this.physicalDefensePerkPoints = physicalDefensePerkPoints;
    }

    public int getArcheryDefensePerkPoints() {
        return archeryDefensePerkPoints;
    }

    public void setArcheryDefensePerkPoints(int archeryDefensePerkPoints) {
        this.archeryDefensePerkPoints = archeryDefensePerkPoints;
    }

    public int getPhysicalOffensePerkPoints() {
        return physicalOffensePerkPoints;
    }

    public void setPhysicalOffensePerkPoints(int physicalOffensePerkPoints) {
        this.physicalOffensePerkPoints = physicalOffensePerkPoints;
    }

    public int getArcheryOffensePerkPoints() {
        return archeryOffensePerkPoints;
    }

    public void setArcheryOffensePerkPoints(int archeryOffensePerkPoints) {
        this.archeryOffensePerkPoints = archeryOffensePerkPoints;
    }

    public int getHealthPerkPoints() {
        return healthPerkPoints;
    }

    public void setHealthPerkPoints(int healthPerkPoints) {
        this.healthPerkPoints = healthPerkPoints;
    }

    public int getCriticalStrikePerkPoints() {
        return criticalStrikePerkPoints;
    }

    public void setCriticalStrikePerkPoints(int criticalStrikePerkPoints) {
        this.criticalStrikePerkPoints = criticalStrikePerkPoints;
    }

    public int getCriticalPowerPerkPoints() {
        return criticalPowerPerkPoints;
    }

    public void setCriticalPowerPerkPoints(int criticalPowerPerkPoints) {
        this.criticalPowerPerkPoints = criticalPowerPerkPoints;
    }

    public String[] getHouses() {
        return houses;
    }

    public void setHouses(String[] houses) {
        this.houses = houses;
    }

    public long getLogout() {
        return logout;
    }

    public void setLogout(long logout) {
        this.logout = logout;
    }

    public long getLogin() {
        return login;
    }

    public void setLogin(long login) {
        this.login = login;
    }

    public boolean isGodMode() {
        return godMode;
    }

    public void setGodMode(boolean godMode) {
        this.godMode = godMode;
    }

    public boolean isAcceptingPay() {
        return acceptingPay;
    }

    public void setAcceptingPay(boolean acceptingPay) {
        this.acceptingPay = acceptingPay;
    }

    public int getPlayerKills() {
        return playerKills;
    }

    public void setPlayerKills(int playerKills) {
        this.playerKills = playerKills;
    }

    public int getMobKills() {
        return mobKills;
    }

    public void setMobKills(int mobKills) {
        this.mobKills = mobKills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getFallDeaths() {
        return fallDeaths;
    }

    public void setFallDeaths(int fallDeaths) {
        this.fallDeaths = fallDeaths;
    }

    public long getTotalPlayTime() {
        return totalPlayTime;
    }

    public void setTotalPlayTime(long totalPlayTime) {
        this.totalPlayTime = totalPlayTime;
    }

    public long getLastDeathTime() {
        return lastDeathTime;
    }

    public void setLastDeathTime(long lastDeathTime) {
        this.lastDeathTime = lastDeathTime;
    }

    public int getTimesLoggedIn() {
        return timesLoggedIn;
    }

    public void setTimesLoggedIn(int timesLoggedIn) {
        this.timesLoggedIn = timesLoggedIn;
    }

    public double getMoneyFromDrops() {
        return moneyFromDrops;
    }

    public void setMoneyFromDrops(double moneyFromDrops) {
        this.moneyFromDrops = moneyFromDrops;
    }

    public long[] getDataPlayTime() {
        return dataPlayTime;
    }

    public void setDataPlayTime(long[] dataPlayTime) {
        this.dataPlayTime = dataPlayTime;
    }

    public double[] getDataPvpDamage() {
        return dataPvpDamage;
    }

    public void setDataPvpDamage(double[] dataPvpDamage) {
        this.dataPvpDamage = dataPvpDamage;
    }

    public double[] getDataPvpDefenseDamage() {
        return dataPvpDefenseDamage;
    }

    public void setDataPvpDefenseDamage(double[] dataPvpDefenseDamage) {
        this.dataPvpDefenseDamage = dataPvpDefenseDamage;
    }

    public double[] getDataPveDamage() {
        return dataPveDamage;
    }

    public void setDataPveDamage(double[] dataPveDamage) {
        this.dataPveDamage = dataPveDamage;
    }

    public double[] getDataPveDefenseDamage() {
        return dataPveDefenseDamage;
    }

    public void setDataPveDefenseDamage(double[] dataPveDefenseDamage) {
        this.dataPveDefenseDamage = dataPveDefenseDamage;
    }

    public double[] getDataWealthGain() {
        return dataWealthGain;
    }

    public void setDataWealthGain(double[] dataWealthGain) {
        this.dataWealthGain = dataWealthGain;
    }

    public double[] getDataMoneyDrops() {
        return dataMoneyDrops;
    }

    public void setDataMoneyDrops(double[] dataMoneyDrops) {
        this.dataMoneyDrops = dataMoneyDrops;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String[] getLastKnownLocation() {
        return lastKnownLocation;
    }

    public void setLastKnownLocation(String[] lastKnownLocation) {
        this.lastKnownLocation = lastKnownLocation;
    }
}
