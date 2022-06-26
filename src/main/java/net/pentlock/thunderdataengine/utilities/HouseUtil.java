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

    public static final Map<String, House> HOUSES = new HashMap<>();

    /**
     *
     * @param name Name of house
     * @param cost cost of house
     * @param unitsAvailable the units made but not yet assigned
     * @param unitsIssued the unit number of units that have been issued
     * @param doorLocation exact location of door to be clicked
     * @param arrivalLocation the location player should be when leaving home
     * @param instances Map of UUID to String[] to hold locations of available houses
     * @param instanceLocation Map of player UUID to the location player arrives at in house world
     * @return this is the house object after it has been created
     */

    public static House createHouse(String name, double cost, double unitsAvailable, double unitsIssued, String[] doorLocation, String[] arrivalLocation,
                                    Map<UUID, String[]> instances, Map<UUID, String[]> instanceLocation) {

        House house = new House(name, cost,unitsAvailable, unitsIssued, doorLocation, arrivalLocation, instances, instanceLocation);

        HOUSES.put(name, house);

        try {
            saveHouse(name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return house;
    }

    /**
     *
     * @param name Name of house
     */
    public static void deleteHouse(String name) {
        HOUSES.remove(name);
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/HouseData/" + name + ".json");
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     *
     * @param name Name of house
     * @return the house object to be found
     */
    public static House findHouse(String name) {
        return HOUSES.get(name);
    }

    /**
     *
     * @param name Name of house
     * @param newHouse House object to pass in
     * @return the house the has been updated
     */
    public static House updateHouse(String name, House newHouse) {
        House house = HOUSES.get(name);

        house.setName(newHouse.getName());
        house.setCost(newHouse.getCost());
        house.setUnitsAvailable(newHouse.getUnitsAvailable());
        house.setUnitsIssued(newHouse.getUnitsIssued());
        house.setDoorLocation(newHouse.getDoorLocation());
        house.setArrivalLocation(newHouse.getArrivalLocation());
        house.setInstances(newHouse.getInstances());
        house.setInstanceLocation(newHouse.getInstanceLocation());

        return house;
    }

    /**
     *
     * @param name Name of house
     * @throws IOException an exception?
     */
    public static void saveHouse(String name) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/HouseData/" + name + ".json");
        if (!file.exists()) {
            file.getParentFile().mkdir();
        }

        file.createNewFile();
        House house = HOUSES.get(name);
        if (house != null) {
            Writer writer = new FileWriter(file, false);
            gson.toJson(house, writer);
            writer.flush();
            writer.close();
        }
    }

    /**
     *
     * @param name Name of house
     * @throws FileNotFoundException an exception?
     */
    public static void loadHouse(String name) throws FileNotFoundException {
        Gson gson = new Gson();
        File file = new File(ThunderDataEngine.getPlugin().getDataFolder().getAbsolutePath() + "/HouseData/" + name + ".json");

        if (file.exists()) {
            Reader reader = new FileReader(file);
            House house = gson.fromJson(reader, House.class);
            HOUSES.put(name, house);
        }
    }

    /**
     *
     * @param name Name of house
     */
    public static void unLoadHouse(String name) {
        try {
            saveHouse(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        HOUSES.remove(name);
    }
}

