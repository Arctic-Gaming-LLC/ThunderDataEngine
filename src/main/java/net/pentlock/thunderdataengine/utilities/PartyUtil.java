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

    public static final Map<UUID, Party> parties = new HashMap<>();

    public static Party createParty(UUID uuid, String name, UUID leader, UUID[] members) {
        Party party = new Party(uuid, name, leader, members);
        parties.put(uuid, party);

        return party;
    }

    public static void deleteParty(UUID uuid) {
        parties.remove(uuid);
    }

    public static Party findParty(UUID uuid) {
        return parties.get(uuid);
    }

    public static Party updateParty(UUID uuid, Party newParty) {
        Party party = parties.get(uuid);

        party.setUuid(newParty.getUuid());
        party.setName(newParty.getName());
        party.setLeader(newParty.getLeader());
        party.setMembers(newParty.getMembers());

        return  party;
    }

    public static void saveParty(UUID uuid) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/PartyData/" + uuid + ".json");
        if (!file.exists()) {
            file.getParentFile().mkdir();
        }

        file.createNewFile();
        Party party = parties.get(uuid);
        if (party != null) {
            Writer writer = new FileWriter(file, false);
            gson.toJson(party, writer);
            writer.flush();
            writer.close();
        }
    }

    public static void loadParty(UUID uuid) throws FileNotFoundException {
        Gson gson = new Gson();
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/PartyData/" + uuid + ".json");

        if (file.exists()) {
            Reader reader = new FileReader(file);
            Party party = gson.fromJson(reader, Party.class);
            parties.put(uuid, party);
        }
    }

    public static void unLoadParty(UUID uuid) {
        try {
            saveParty(uuid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        parties.remove(uuid);
    }
}
