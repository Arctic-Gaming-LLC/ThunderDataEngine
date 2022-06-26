package net.pentlock.thunderdataengine.utilities;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.pentlock.thunderdataengine.ThunderDataEngine;
import net.pentlock.thunderdataengine.profiles.House;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HouseUtil {

    public static final Map<UUID, House> HOUSES = new HashMap<>();

    /**
     *
     * @param uuid UUID of house
     * @param name Name of house
     * @param cost cost of house
     * @param doorLocation exact location of door to be clicked
     * @param arrivalLocation the location player should be when leaving home
     * @param instances Map of UUID to String[] to hold locations of available houses
     * @param instanceLocation Map of player UUID to the location player arrives at in house world
     * @return this is the house object after it has been created
     */

    public static House createHouse(UUID uuid, String name, double cost, String[] doorLocation, String[] arrivalLocation,
                                    Map<UUID, String[]> instances, Map<UUID, String[]> instanceLocation) {

        House house = new House(uuid, name, cost, doorLocation, arrivalLocation, instances, instanceLocation);

        HOUSES.put(uuid, house);

        try {
            saveHouse(uuid);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return house;
    }

    /**
     *
     * @param uuid UUID of house
     */
    public static void deleteHouse(UUID uuid) {
        HOUSES.remove(uuid);
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/HouseData/" + uuid + ".json");
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     *
     * @param uuid UUID of house
     * @return the house object to be found
     */
    public static House findHouse(UUID uuid) {
        return HOUSES.get(uuid);
    }

    /**
     *
     * @param uuid UUID of house
     * @param newHouse House object to pass in
     * @return the house the has been updated
     */
    public static House updateHouse(UUID uuid, House newHouse) {
        House house = HOUSES.get(uuid);

        house.setUUID(newHouse.getUUID());
        house.setName(newHouse.getName());
        house.setCost(newHouse.getCost());
        house.setDoorLocation(newHouse.getDoorLocation());
        house.setArrivalLocation(newHouse.getArrivalLocation());
        house.setInstances(newHouse.getInstances());
        house.setInstanceLocation(newHouse.getInstanceLocation());

        return house;
    }

    /**
     *
     * @param uuid UUID of house
     * @throws IOException an exception?
     */
    public static void saveHouse(UUID uuid) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/HouseData/" + uuid + ".json");
        if (!file.exists()) {
            file.getParentFile().mkdir();
        }

        file.createNewFile();
        House house = HOUSES.get(uuid);
        if (house != null) {
            Writer writer = new FileWriter(file, false);
            gson.toJson(house, writer);
            writer.flush();
            writer.close();
        }
    }

    /**
     *
     * @param uuid UUID of house
     * @throws FileNotFoundException an exception?
     */
    public static void loadHouse(UUID uuid) throws FileNotFoundException {
        Gson gson = new Gson();
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/HouseData/" + uuid + ".json");

        if (file.exists()) {
            Reader reader = new FileReader(file);
            House house = gson.fromJson(reader, House.class);
            HOUSES.put(uuid, house);
        }
    }

    /**
     *
     * @param uuid
     */
    public static void unLoadHouse(UUID uuid) {
        try {
            saveHouse(uuid);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HOUSES.remove(uuid);
    }
}

