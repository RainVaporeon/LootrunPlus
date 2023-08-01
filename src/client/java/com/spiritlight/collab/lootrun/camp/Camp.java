package com.spiritlight.collab.lootrun.camp;

import com.spiritlight.collab.lootrun.beacon.Beacon;
import org.jetbrains.annotations.Unmodifiable;

import java.util.HashSet;
import java.util.Set;

public interface Camp extends Iterable<Beacon> {

    /**
     * Retrieves the camp name
     */
    String campName();

    /**
     * Returns a set of beacons denoting the
     * beacons registered to this camp
     */
    Set<Beacon> registeredBeacons();

    /**
     * Registers a beacon to this camp
     * @param beacon The beacon to register
     * @return whether this beacon was added
     */
    default boolean registerBeacon(Beacon beacon) {
        throw new UnsupportedOperationException();
    }

    /**
     * Removes a beacon from this camp
     * @param beacon the beacon to register
     * @return whether this beacon was removed
     */
    default boolean unregisterBeacon(Beacon beacon) {
        throw new UnsupportedOperationException();
    }

    static Camp of(String name, Set<Beacon> beacons) {
        return new CampImpl(name, beacons);
    }

    static Camp of(String name, Beacon... beacons) {
        return of(name, new HashSet<>(Set.of(beacons)));
    }
}
