package net.pentlock.thunderdataengine.profiles;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

public class House {
    @Setter @Getter
    private String name; // name of house
    @Setter @Getter
    private double cost;
    @Setter @Getter
    private String[] doorLocation; // exact location of door
    @Setter @Getter
    private String[] arrivalLocation; // this is location outside the door
    @Setter @Getter
    private Map<UUID, String[]> instances; // these are the house instances UUIDs and locations
    @Setter @Getter
    private Map<UUID, String[]> instanceLocation; // this is a map of locations tied to player UUID

    /**
     * <h3>House Objects</h3>
     * This is the constructor for a House type - not an individual house
     *
     * @param name the Name of the House
     * @param cost How much the house costs to purchase
     * @param doorLocation The exact location of the door
     * @param arrivalLocation Where players should spawn in the house
     * @param instances Stores the locations and UUIDs of all instances of this house type
     * @param instanceLocation Stores a map of player UUIDs and House Locations
     */
    public House(String name, double cost, String[] doorLocation, String[] arrivalLocation, Map<UUID, String[]> instances, Map<UUID, String[]> instanceLocation) {
        this.name = name;
        this.cost = cost;
        this.doorLocation = doorLocation;
        this.arrivalLocation = arrivalLocation;
        this.instances = instances;
        this.instanceLocation = instanceLocation;
    }
}
