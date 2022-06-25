package net.pentlock.thunderdataengine.profiles;

import java.util.Map;
import java.util.UUID;

public class House {
    private UUID uuid; // UUID of house group
    private String name; // name of house
    private double cost;
    private String[] doorLocation; // exact location of door
    private String[] arrivalLocation; // this is location outside the door
    private Map<UUID, String[]> instances; // these are the house instances UUIDs and locations
    private Map<UUID, String[]> instanceLocation; // this is a map of locations tied to player UUID

    public House(UUID uuid, String name, double cost, String[] doorLocation, String[] arrivalLocation, Map<UUID, String[]> instances, Map<UUID, String[]> instanceLocation) {
        this.uuid = uuid;
        this.name = name;
        this.cost = cost;
        this.doorLocation = doorLocation;
        this.arrivalLocation = arrivalLocation;
        this.instances = instances;
        this.instanceLocation = instanceLocation;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String[] getDoorLocation() {
        return doorLocation;
    }

    public void setDoorLocation(String[] doorLocation) {
        this.doorLocation = doorLocation;
    }

    public String[] getArrivalLocation() {
        return arrivalLocation;
    }

    public void setArrivalLocation(String[] arrivalLocation) {
        this.arrivalLocation = arrivalLocation;
    }

    public Map<UUID, String[]> getInstances() {
        return instances;
    }

    public void setInstances(Map<UUID, String[]> instances) {
        this.instances = instances;
    }

    public Map<UUID, String[]> getInstanceLocation() {
        return instanceLocation;
    }

    public void setInstanceLocation(Map<UUID, String[]> instanceLocation) {
        this.instanceLocation = instanceLocation;
    }
}
