package net.pentlock.thunderdataengine.profiles;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class Guild {
    @Setter @Getter
    private UUID uuid;
    @Setter @Getter
    private double bankBalance;
    @Setter @Getter
    private String name;
    @Setter @Getter
    private int level;
    @Setter @Getter
    private UUID leader;
    @Setter @Getter
    private UUID coLeader;
    @Setter @Getter
    private UUID[] officers;
    @Setter @Getter
    private UUID[] members;
    @Setter @Getter
    private int maxMembers;
    @Setter @Getter
    private String messageBoard;
    @Setter @Getter
    private int points;
    @Setter @Getter
    private int physicalDefensePoints;
    @Setter @Getter
    private int archeryDefensePoints;
    @Setter @Getter
    private int physicalOffensePoints;
    @Setter @Getter
    private int archeryOffensePoints;
    @Setter @Getter
    private int healthPoints;
    @Setter @Getter
    private int criticalStrikePoints;
    @Setter @Getter
    private int criticalPowerPoints;
    @Setter @Getter
    private boolean boostActive;
    @Setter @Getter
    private String boostType;
    @Setter @Getter
    private long boostTime;
    @Setter @Getter
    private long refreshTime;
    @Setter @Getter
    private boolean refreshActive;

    /**
     * <h3>Guild Object</h3>
     * <p>All data objects used to create a guild</p>
     *
     * @param uuid Guild's Unique ID
     * @param bankBalance Guild's Economy Balance
     * @param name Name of Guild
     * @param level Guild's overall level
     * @param leader Guild's Leader
     * @param coLeader Guild's CoLeader
     * @param officers Guild's Officers
     * @param members Guild's Members
     * @param maxMembers Maximum Number of Player a guild can have
     * @param messageBoard Message sent to Guild Members on Login
     * @param points Points available to use on upgrades
     * @param physicalDefensePoints Total number of points in category
     * @param archeryDefensePoints Total number of points in category
     * @param physicalOffensePoints Total number of points in category
     * @param archeryOffensePoints Total number of points in category
     * @param healthPoints Total number of points in category
     * @param criticalStrikePoints Total number of points in category
     * @param criticalPowerPoints Total number of points in category
     * @param boostActive Is Boost Active
     * @param boostType Type of Boost Active
     * @param boostTime How long a boost has left to run
     * @param refreshTime Config value for Boost Cooldown
     * @param refreshActive Checks if there is a refresh time applied to a boost
     */
    public Guild(UUID uuid, double bankBalance, String name, int level, UUID leader, UUID coLeader, UUID[] officers, UUID[] members,
                 int maxMembers, String messageBoard, int points, int physicalDefensePoints, int archeryDefensePoints, int physicalOffensePoints,
                 int archeryOffensePoints, int healthPoints, int criticalStrikePoints, int criticalPowerPoints, boolean boostActive, String boostType,
                 long boostTime, long refreshTime, boolean refreshActive) {
        this.uuid = uuid;
        this.bankBalance = bankBalance;
        this.name = name;
        this.level = level;
        this.leader = leader;
        this.coLeader = coLeader;
        this.officers = officers;
        this.members = members;
        this.maxMembers = maxMembers;
        this.messageBoard = messageBoard;
        this.points = points;
        this.physicalDefensePoints = physicalDefensePoints;
        this.archeryDefensePoints = archeryDefensePoints;
        this.physicalOffensePoints = physicalOffensePoints;
        this.archeryOffensePoints = archeryOffensePoints;
        this.healthPoints = healthPoints;
        this.criticalStrikePoints = criticalStrikePoints;
        this.criticalPowerPoints = criticalPowerPoints;
        this.boostActive = boostActive;
        this.boostType = boostType;
        this.boostTime = boostTime;
        this.refreshTime = refreshTime;
        this.refreshActive = refreshActive;
    }
}
