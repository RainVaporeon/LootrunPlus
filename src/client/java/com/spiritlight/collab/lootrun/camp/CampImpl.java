package com.spiritlight.collab.lootrun.camp;

import com.spiritlight.collab.lootrun.beacon.Beacon;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Iterator;
import java.util.Set;

public class CampImpl implements Camp {
    private final String name;

    private final Set<Beacon> beacons;

    CampImpl(String name, Set<Beacon> beacons) {
        this.name = name;
        this.beacons = beacons;
    }

    @NotNull
    @Override @Unmodifiable
    public Iterator<Beacon> iterator() {
        return registeredBeacons().iterator();
    }

    @Override
    public String campName() {
        return name;
    }

    @Override @Unmodifiable
    public Set<Beacon> registeredBeacons() {
        return Set.copyOf(beacons);
    }

    @Override
    public boolean registerBeacon(Beacon beacon) {
        return this.beacons.add(beacon);
    }

    @Override
    public boolean unregisterBeacon(Beacon beacon) {
        return this.beacons.remove(beacon);
    }
}
