package net.pentlock.thunderdataengine.profiles;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

public class Party {
    @Setter @Getter
    private UUID UUID;
    @Setter @Getter
    private String name;
    @Setter @Getter
    private UUID leader;
    @Setter @Getter
    private UUID[] members;

    /**
     * <h3>Party Object</h3>
     * Constructor for Party objects - instances are NOT saved to file
     *
     * @param uuid party's unique ID
     * @param name name of the party - not required, but nice
     * @param leader the current leader of a party
     * @param members an array of members stored as UUIDs
     */
    public Party(UUID uuid, String name, UUID leader, UUID[] members) {
        this.UUID = uuid;
        this.name = name;
        this.leader = leader;
        this.members = members;
    }
}
