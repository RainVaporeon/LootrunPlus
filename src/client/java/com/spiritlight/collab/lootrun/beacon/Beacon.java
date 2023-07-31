package com.spiritlight.collab.lootrun.beacon;

import com.spiritlight.collab.lootrun.beacon.characteristics.BeaconCharacteristics;

import java.util.Set;

public class Beacon{

    private final String name;
    private final BeaconColor color;
    private final Set<BeaconCharacteristics> characteristics;

    private Beacon(String name, BeaconColor color, Set<BeaconCharacteristics> characteristics) {
        this.name = name;
        this.color = color;
        this.characteristics = characteristics;
    }

    public Beacon(BeaconColor color) {
        this(color.name() + " Beacon", color, color.defaultCharacteristics());
    }

    public static Beacon of(BeaconColor color) {
        return new Beacon(color);
    }

    public String getName() {
        return name;
    }

    public BeaconColor getColor() {
        return color;
    }

    public Set<BeaconCharacteristics> characteristics() {
        return characteristics;
    }

    public Beacon copy() {
        return new Beacon(name, color, characteristics);
    }
}
