package net.pentlock.thunderdataengine.profiles;

import java.util.UUID;

public class Party {
    private UUID uuid;
    private String name;
    private UUID leader;
    private UUID[] members;

    public Party(UUID uuid, String name, UUID leader, UUID[] members) {
        this.uuid = uuid;
        this.name = name;
        this.leader = leader;
        this.members = members;
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getLeader() {
        return leader;
    }

    public void setLeader(UUID leader) {
        this.leader = leader;
    }

    public UUID[] getMembers() {
        return members;
    }

    public void setMembers(UUID[] members) {
        this.members = members;
    }
}
