package net.pentlock.thunderdataengine.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.pentlock.thunderdataengine.ThunderDataEngine;
import net.pentlock.thunderdataengine.profiles.Party;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PartyUtil {

    public static final Map<UUID, Party> PARTIES = new HashMap<>();

    /**
     * <h3>Create Party Instance</h3>
     * @param uuid
     * @param name
     * @param leader
     * @param members
     * @return
     */
    public static Party createParty(UUID uuid, String name, UUID leader, UUID[] members) {
        Party party = new Party(uuid, name, leader, members);
        PARTIES.put(uuid, party);

        return party;
    }

    /**
     * <h3>Delete Party Instance</h3>
     * @param uuid
     */
    public static void deleteParty(UUID uuid) {
        PARTIES.remove(uuid);
    }

    /**
     * <h3>Find Party Instance</h3>
     * @param uuid
     * @return
     */
    public static Party findParty(UUID uuid) {
        return PARTIES.get(uuid);
    }

    /**
     * <h3> Update Party Instance</h3>
     * @param uuid
     * @param newParty
     * @return
     */
    public static Party updateParty(UUID uuid, Party newParty) {
        Party party = PARTIES.get(uuid);

        party.setUUID(newParty.getUUID());
        party.setName(newParty.getName());
        party.setLeader(newParty.getLeader());
        party.setMembers(newParty.getMembers());

        return  party;
    }
}
