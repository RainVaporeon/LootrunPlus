package com.spiritlight.collab.lootrun.beacon.characteristics;

import com.spiritlight.collab.utils.ArgumentType;

import java.util.Objects;

public class BeaconCharacteristics {
    private final Characteristic characteristic;
    private final ArgumentType type;
    private final int value;

    public BeaconCharacteristics(Characteristic characteristic, ArgumentType type, int value) {
        this.characteristic = characteristic;
        this.type = type;
        this.value = value;
    }

    public static BeaconCharacteristics of(Characteristic key, ArgumentType type, int value) {
        return new BeaconCharacteristics(key, type, value);
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

    public ArgumentType type() {
        return type;
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
