package com.spiritlight.collab.lootrun.beacon;

import com.spiritlight.collab.lootrun.beacon.characteristics.BeaconCharacteristics;

import java.util.Set;

public class Beacon implements IBeacon {

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

    public static IBeacon of(BeaconColor color) {
        return new Beacon(color);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public BeaconColor getColor() {
        return null;
    }

    @Override
    public Set<BeaconCharacteristics> characteristics() {
        return null;
    }

    public IBeacon copy() {
        return new Beacon(name, color, characteristics);
    }
}
