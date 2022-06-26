package net.pentlock.thunderdataengine.profiles;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

public class ThunderPlayer {
    @Setter @Getter private String name;
    @Setter @Getter private double money;
    @Setter @Getter private int level;
    @Setter @Getter private long exp;
    @Setter @Getter private String grave;
    @Setter @Getter private String graveWorld;
    @Setter @Getter private int maxHealth;
    @Setter @Getter private double currentHealth;
    @Setter @Getter private int luck;
    @Setter @Getter private int physicalDefense;
    @Setter @Getter private int archeryDefense;
    @Setter @Getter private int physicalOffense;
    @Setter @Getter private int archeryOffense;
    @Setter @Getter private double criticalStrike;
    @Setter @Getter private double criticalPower;
    @Setter @Getter private Date dateCreated;
    @Setter @Getter private UUID UUID;
    @Setter @Getter private UUID guild;
    @Setter @Getter private UUID party;
    @Setter @Getter private boolean pvpEnabled;
    @Setter @Getter private int perkPoints;
    @Setter @Getter private int physicalDefensePerkPoints;
    @Setter @Getter private int archeryDefensePerkPoints;
    @Setter @Getter private int physicalOffensePerkPoints;
    @Setter @Getter private int archeryOffensePerkPoints;
    @Setter @Getter private int healthPerkPoints;
    @Setter @Getter private int criticalStrikePerkPoints;
    @Setter @Getter private int criticalPowerPerkPoints;
    @Setter @Getter private UUID[] houses;
    @Setter @Getter private long logout;
    @Setter @Getter private long login;
    @Setter @Getter private boolean godMode;
    @Setter @Getter private boolean acceptingPay;
    @Setter @Getter private int playerKills;
    @Setter @Getter private int mobKills;
    @Setter @Getter private int deaths;
    @Setter @Getter private int fallDeaths;
    @Setter @Getter private long totalPlayTime;
    @Setter @Getter private long lastDeathTime;
    @Setter @Getter private int timesLoggedIn;
    @Setter @Getter private double moneyFromDrops;
    @Setter @Getter private long[] dataPlayTime;
    @Setter @Getter private double[] dataPvpDamage;
    @Setter @Getter private double[] dataPvpDefenseDamage;
    @Setter @Getter private double[] dataPveDamage;
    @Setter @Getter private double[] dataPveDefenseDamage;
    @Setter @Getter private double[] dataWealthGain;
    @Setter @Getter private double[] dataMoneyDrops;
    @Setter @Getter private String tag;
    @Setter @Getter private String[] lastKnownLocation;
    @Setter @Getter private double[] dataWealth;

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
     * @param dataPvpDamage Total PvP damage output in past sessions individually
     * @param dataPvpDefenseDamage Total PvP damaged defended against in past sessions individually
     * @param dataPveDamage Total Damage output in past sessions
     * @param dataPveDefenseDamage Total Damage defended against in past sessions
     * @param dataWealthGain Wealth Gain over sessions
     * @param dataWealth Average Balance over time
     * @param dataMoneyDrops Money received from drops over sessions
     * @param tag Player's Chat Tag
     * @param lastKnownLocation Player's last known location, used on teleports
     */
    public ThunderPlayer(String name, double money, int level, long exp, String grave, String graveWorld, int maxHealth, double currentHealth,
                         int luck, int physicalDefense, int archeryDefense, int physicalOffense, int archeryOffense, double criticalStrike,
                         double criticalPower, Date dateCreated, UUID uuid, UUID guild, UUID party, boolean pvpEnabled, int perkPoints,
                         int physicalDefensePerkPoints, int archeryDefensePerkPoints, int physicalOffensePerkPoints, int archeryOffensePerkPoints,
                         int healthPerkPoints, int criticalStrikePerkPoints, int criticalPowerPerkPoints, UUID[] houses,
                         long logout, long login, boolean godMode, boolean acceptingPay, int playerKills, int mobKills, int deaths, int fallDeaths,
                         long totalPlayTime, long lastDeathTime, int timesLoggedIn, double moneyFromDrops, long[] dataPlayTime, double[] dataPvpDamage,
                         double[] dataPvpDefenseDamage, double[] dataPveDamage, double[] dataPveDefenseDamage, double[] dataWealthGain,
                         double[] dataMoneyDrops, String tag, String[] lastKnownLocation, double[] dataWealth) {
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
    }
}
