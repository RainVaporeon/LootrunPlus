package com.spiritlight.collab.lootrun.camp;

import com.spiritlight.collab.lootrun.beacon.Beacon;
import com.spiritlight.collab.utils.Stable;

import java.util.Set;

// TODO: Implement beacon detail here
public enum EnumCamp {
    SILENT_EXPANSE(Camp.of("Silent Expanse Expedition")),
    CORKUS(Camp.of("The Corkus Traversal"))
    ;

    private final Camp camp;

    @Stable
    private boolean locked;

    EnumCamp(Camp camp) {
        this.camp = camp;
    }

    public Camp getCamp() {
        return camp;
    }

    /**
     * Adds all the beacons into this camp
     * @param beacons the beacons
     * @return true if this camp was modified
     * @throws IllegalStateException if this camp was locked
     */
    public boolean addBeacon(Iterable<Beacon> beacons) {
        if(locked) throw new IllegalStateException("cannot add beacons to locked camp " + this);
        boolean modified = false;
        for(Beacon beacon : beacons) {
            boolean mod = this.camp.registerBeacon(beacon);
            if(mod) modified = true;
        }
        return modified;
    }

    /**
     * Adds all the beacons into this camp
     * @param beacons the beacons
     * @return true if this camp was modified
     * @throws IllegalStateException if this camp was locked
     */
    public boolean addBeacon(Beacon... beacons) {
        return addBeacon(Set.of(beacons));
    }

    /**
     * Removes all the beacons from this camp
     * @param beacons the beacons
     * @return true if this camp was modified
     * @throws IllegalStateException if this camp was locked
     */
    public boolean removeBeacon(Iterable<Beacon> beacons) {
        if(locked) throw new IllegalStateException("cannot add beacons to locked camp " + this);
        boolean modified = false;
        for(Beacon beacon : beacons) {
            boolean mod = this.camp.unregisterBeacon(beacon);
            if(mod) modified = true;
        }
        return modified;
    }

    /**
     * Removes all the beacons from this camp
     * @param beacons the beacons
     * @return true if this camp was modified
     * @throws IllegalStateException if this camp was locked
     */
    public boolean removeBeacon(Beacon... beacons) {
        return removeBeacon(Set.of(beacons));
    }

    public void lock() {
        if(locked) throw new IllegalStateException("cannot lock camp " + this + " as it was already locked");
        locked = true;
    }
}
