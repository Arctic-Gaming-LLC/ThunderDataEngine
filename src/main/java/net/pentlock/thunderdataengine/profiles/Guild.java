package net.pentlock.thunderdataengine.profiles;

import java.util.UUID;

public class Guild {
    private UUID uuid;
    private double bankBalance;
    private String name;
    private int level;
    private UUID leader;
    private UUID coLeader;
    private UUID[] officers;
    private UUID[] members;
    private int maxMembers;
    private String messageBoard;
    private int points;
    private int physicalDefensePoints;
    private int archeryDefensePoints;
    private int physicalOffensePoints;
    private int archeryOffensePoints;
    private int healthPoints;
    private int criticalStrikePoints;
    private int criticalPowerPoints;
    private boolean boostActive;
    private String boostType;
    private long boostTime;
    private long refreshTime;
    private boolean refreshActive;

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

    public UUID getUUID() {
        return uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public double getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(double bankBalance) {
        this.bankBalance = bankBalance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public UUID getLeader() {
        return leader;
    }

    public void setLeader(UUID leader) {
        this.leader = leader;
    }

    public UUID getCoLeader() {
        return coLeader;
    }

    public void setCoLeader(UUID coLeader) {
        this.coLeader = coLeader;
    }

    public UUID[] getOfficers() {
        return officers;
    }

    public void setOfficers(UUID[] officers) {
        this.officers = officers;
    }

    public UUID[] getMembers() {
        return members;
    }

    public void setMembers(UUID[] members) {
        this.members = members;
    }

    public int getMaxMembers() {
        return maxMembers;
    }

    public void setMaxMembers(int maxMembers) {
        this.maxMembers = maxMembers;
    }

    public String getMessageBoard() {
        return messageBoard;
    }

    public void setMessageBoard(String messageBoard) {
        this.messageBoard = messageBoard;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPhysicalDefensePoints() {
        return physicalDefensePoints;
    }

    public void setPhysicalDefensePoints(int physicalDefensePoints) {
        this.physicalDefensePoints = physicalDefensePoints;
    }

    public int getArcheryDefensePoints() {
        return archeryDefensePoints;
    }

    public void setArcheryDefensePoints(int archeryDefensePoints) {
        this.archeryDefensePoints = archeryDefensePoints;
    }

    public int getPhysicalOffensePoints() {
        return physicalOffensePoints;
    }

    public void setPhysicalOffensePoints(int physicalOffensePoints) {
        this.physicalOffensePoints = physicalOffensePoints;
    }

    public int getArcheryOffensePoints() {
        return archeryOffensePoints;
    }

    public void setArcheryOffensePoints(int archeryOffensePoints) {
        this.archeryOffensePoints = archeryOffensePoints;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getCriticalStrikePoints() {
        return criticalStrikePoints;
    }

    public void setCriticalStrikePoints(int criticalStrikePoints) {
        this.criticalStrikePoints = criticalStrikePoints;
    }

    public int getCriticalPowerPoints() {
        return criticalPowerPoints;
    }

    public void setCriticalPowerPoints(int criticalPowerPoints) {
        this.criticalPowerPoints = criticalPowerPoints;
    }

    public boolean isBoostActive() {
        return boostActive;
    }

    public void setBoostActive(boolean boostActive) {
        this.boostActive = boostActive;
    }

    public String getBoostType() {
        return boostType;
    }

    public void setBoostType(String boostType) {
        this.boostType = boostType;
    }

    public long getBoostTime() {
        return boostTime;
    }

    public void setBoostTime(long boostTime) {
        this.boostTime = boostTime;
    }

    public long getRefreshTime() {
        return refreshTime;
    }

    public void setRefreshTime(long refreshTime) {
        this.refreshTime = refreshTime;
    }

    public boolean isRefreshActive() {
        return refreshActive;
    }

    public void setRefreshActive(boolean refreshActive) {
        this.refreshActive = refreshActive;
    }
}
