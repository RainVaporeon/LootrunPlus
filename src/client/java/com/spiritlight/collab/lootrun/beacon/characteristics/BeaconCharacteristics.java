package com.spiritlight.collab.lootrun.beacon.characteristics;

import java.util.Objects;

public class BeaconCharacteristics {
    private final Characteristic characteristic;
    private final int value;

    public BeaconCharacteristics(Characteristic characteristic, int value) {
        this.characteristic = characteristic;
        this.value = value;
    }

    public static BeaconCharacteristics of(Characteristic key, int value) {
        return new BeaconCharacteristics(key, value);
    }

    /**
     * Gets the characteristic associated with this object
     * @return
     */
    public Characteristic characteristic() {
        return characteristic;
    }

    /**
     * Gets the value associated with this object
     * @return
     * @apiNote if this is a multiplier, return the multiplier value (+100% = 1),
     * if this is time, the unit is in seconds.
     */
    public int value() {
        return value;
    }

    public boolean hasValue() {
        return value != 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (BeaconCharacteristics) obj;
        return Objects.equals(this.characteristic, that.characteristic) &&
                this.value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(characteristic, value);
    }

    @Override
    public String toString() {
        return "BeaconCharacteristics[" +
                "characteristic=" + characteristic + ", " +
                "value=" + value + ']';
    }

}
