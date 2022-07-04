package net.pentlock.thunderdataengine.profiles;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class ThunderPlayer {
    @Setter @Getter private String name;
    @Setter @Getter private double money;  // implemented in TCS
    @Setter @Getter private int level;  // implemented in TCS
    @Setter @Getter private long exp;  // implemented in TCS
    @Setter @Getter private String grave; // implemented in TCS
    @Setter @Getter private String graveWorld;  // implemented in TCS
    @Setter @Getter private int maxHealth;  // implemented in TCS
    @Setter @Getter private double currentHealth;  // implemented in TCS
    @Setter @Getter private int luck;  // implemented in TCS
    @Setter @Getter private int physicalDefense;  // implemented in TCS
    @Setter @Getter private int archeryDefense;  // implemented in TCS
    @Setter @Getter private int physicalOffense;  // implemented in TCS
    @Setter @Getter private int archeryOffense;  // implemented in TCS
    @Setter @Getter private double criticalStrike;  // implemented in TCS
    @Setter @Getter private double criticalPower;  // implemented in TCS
    @Setter @Getter private Date dateCreated;
    @Setter @Getter private UUID UUID;
    @Setter @Getter private UUID guild;  // implemented in TCS
    @Setter @Getter private UUID party;  // implemented in TCS
    @Setter @Getter private boolean pvpEnabled;  // implemented in TCS
    @Setter @Getter private int perkPoints;  // implemented in TCS
    @Setter @Getter private int physicalDefensePerkPoints;  // implemented in TCS
    @Setter @Getter private int archeryDefensePerkPoints;  // implemented in TCS
    @Setter @Getter private int physicalOffensePerkPoints;  // implemented in TCS
    @Setter @Getter private int archeryOffensePerkPoints;  // implemented in TCS
    @Setter @Getter private int healthPerkPoints;  // implemented in TCS
    @Setter @Getter private int criticalStrikePerkPoints;  // implemented in TCS
    @Setter @Getter private int criticalPowerPerkPoints;  // implemented in TCS
    @Setter @Getter private String[] houses;  // implemented in PlayerHousing
    @Setter @Getter private long logout; // implemented in engine
    @Setter @Getter private long login;  // implemented in engine
    @Setter @Getter private boolean godMode;  // implemented in TCS, command in core
    @Setter @Getter private boolean acceptingPay;  // implemented in core
    @Setter @Getter private int playerKills;  // implemented in TCS
    @Setter @Getter private int mobKills;  // implemented in TCS
    @Setter @Getter private int deaths;  // implemented in TCS
    @Setter @Getter private int fallDeaths;  // implemented in TCS
    @Setter @Getter private long totalPlayTime;  // implemented in engine
    @Setter @Getter private long lastDeathTime;  // implemented in TCS
    @Setter @Getter private int timesLoggedIn;  // implemented in engine
    @Setter @Getter private double moneyFromDrops;  // implemented in TCS
    @Setter @Getter private long[] dataPlayTime;  // implemented in engine
    @Setter @Getter private double[] dataPvpDamage;  // implemented in TCS
    @Setter @Getter private double[] dataPvpDefenseDamage;  // implemented in TCS
    @Setter @Getter private double[] dataPveDamage;  // implemented in TCS
    @Setter @Getter private double[] dataPveDefenseDamage;  // implemented in TCS
    @Setter @Getter private double[] dataWealthGain;  // implemented in TCS
    @Setter @Getter private double[] dataMoneyDrops;  // implemented in TCS
    @Setter @Getter private String tag;  // implemented in chat system
    @Setter @Getter private String[] lastKnownLocation;  // implemented in core
    @Setter @Getter private double[] dataWealth;   // implemented in TCS
    @Setter @Getter private Map<String, double[]> sessionStats;
    @Setter @Getter private String bank64;
    @Setter @Getter private String nickName;

    /**
     * <h3>Thunder Player Object</h3>
     * Constructor for a Thunder Player, synonymous with Player
     *
     *
     * @param name Players name
     * @param money Players Money Balance
     * @param level Player's Thunder Combat System Level
     * @param exp Player's current experience
     * @param grave Name of the player's preferred grave
     * @param graveWorld World that the grave exists in
     * @param maxHealth Player's Maximum Health Value
     * @param currentHealth Player's Current Health Value
     * @param luck Player's Luck Value, positive or negative
     * @param physicalDefense Player's Defense against Physical attacks
     * @param archeryDefense Player's Defense against Ranged attacks
     * @param physicalOffense Player's Physical Damage to others
     * @param archeryOffense Player's Ranged Damage to others
     * @param criticalStrike Player's chance of making a critical strike
     * @param criticalPower Current Critical Power
     * @param dateCreated Date the player first logged in or File was created
     * @param uuid Player's UUID
     * @param guild Player's Guild UUID
     * @param party Player's Party UUID, not saved locally
     * @param pvpEnabled Can player PvP with others?
     * @param perkPoints Total Perk Points player has
     * @param physicalDefensePerkPoints How many points are invested in this category
     * @param archeryDefensePerkPoints How many points are invested in this category
     * @param physicalOffensePerkPoints How many points are invested in this category
     * @param archeryOffensePerkPoints How many points are invested in this category
     * @param healthPerkPoints How many points are invested in this category
     * @param criticalStrikePerkPoints How many points are invested in this category
     * @param criticalPowerPerkPoints How many points are invested in this category
     * @param houses Houses player owns
     * @param logout Player logout time
     * @param login Player login time
     * @param godMode God Mode Enabled
     * @param acceptingPay Can player be paid by others?
     * @param playerKills Total number of other players killed
     * @param mobKills Total number of Mobs killed
     * @param deaths Total times a player has died
     * @param fallDeaths Total times a player has died from fall damage, included in Deaths
     * @param totalPlayTime Total time player has played
     * @param lastDeathTime Last time a player died
     * @param timesLoggedIn Total number of times a player has logged in
     * @param moneyFromDrops How much money player has earned from drops
     * @param dataPlayTime Time played in past sessions individually
     * @param dataPvpDamage Average PvP damage output in past sessions individually
     * @param dataPvpDefenseDamage Average PvP damaged defended against in past sessions individually
     * @param dataPveDamage Average Damage output in past sessions
     * @param dataPveDefenseDamage Average Damage defended against in past sessions
     * @param dataWealthGain Wealth Gain over sessions
     * @param dataWealth Average Balance over time
     * @param dataMoneyDrops Money received from drops over sessions
     * @param tag Player's Chat Tag
     * @param lastKnownLocation Player's last known location, used on teleports
     * @param sessionStats Players temporary session stats
     * @param bank64 Inventory of player bank
     */
    public ThunderPlayer(String name, double money, int level, long exp, String grave, String graveWorld, int maxHealth, double currentHealth,
                         int luck, int physicalDefense, int archeryDefense, int physicalOffense, int archeryOffense, double criticalStrike,
                         double criticalPower, Date dateCreated, UUID uuid, UUID guild, UUID party, boolean pvpEnabled, int perkPoints,
                         int physicalDefensePerkPoints, int archeryDefensePerkPoints, int physicalOffensePerkPoints, int archeryOffensePerkPoints,
                         int healthPerkPoints, int criticalStrikePerkPoints, int criticalPowerPerkPoints, String[] houses,
                         long logout, long login, boolean godMode, boolean acceptingPay, int playerKills, int mobKills, int deaths, int fallDeaths,
                         long totalPlayTime, long lastDeathTime, int timesLoggedIn, double moneyFromDrops, long[] dataPlayTime, double[] dataPvpDamage,
                         double[] dataPvpDefenseDamage, double[] dataPveDamage, double[] dataPveDefenseDamage, double[] dataWealthGain,
                         double[] dataMoneyDrops, String tag, String[] lastKnownLocation, double[] dataWealth, Map<String, double[]> sessionStats,
                         String bank64, String nickName) {
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
        this.UUID = uuid;
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
        this.dataWealth = dataWealth;
        this.sessionStats = sessionStats;
        this.bank64 = bank64;
        this.nickName = nickName;

    }
}
