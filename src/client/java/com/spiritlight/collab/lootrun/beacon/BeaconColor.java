package com.spiritlight.collab.lootrun.beacon;

import com.spiritlight.collab.lootrun.beacon.characteristics.BeaconCharacteristics;
import com.spiritlight.collab.lootrun.beacon.characteristics.Characteristic;

import java.util.Set;

public enum BeaconColor {
    PURPLE,
    YELLOW,
    BLUE,
    ORANGE,
    AQUA,
    DARK_GRAY,
    GRAY,
    WHITE,
    RED,
    GREEN,
    RAINBOW;

    BeaconColor() {

    }

    public static Set<BeaconCharacteristics> defaultCharacteristics(BeaconColor color) {
        return color.defaultCharacteristics();
    }

    public Set<BeaconCharacteristics> defaultCharacteristics() {
        return switch(this) {
            case AQUA -> Set.of(Characteristic.AMPLIFIER.asCharacteristic(1));
            case BLUE -> Set.of(Characteristic.POWER_UP.asCharacteristic());
            case DARK_GRAY -> Set.of(Characteristic.CURSE.asCharacteristic(3), Characteristic.EXTRA_ROLL.asCharacteristic(5));
            case GRAY -> Set.of(Characteristic.END_REROLL_BONUS.asCharacteristic(1));
            case GREEN -> Set.of(Characteristic.EXTRA_TIME.asCharacteristic(120));
            case ORANGE -> Set.of(Characteristic.EXTRA_BEACON_CHOICE.asCharacteristic(1));
            case PURPLE -> Set.of(Characteristic.CURSE.asCharacteristic(1), Characteristic.EXTRA_ROLL.asCharacteristic(1));
            case RAINBOW -> Set.of(Characteristic.ALL_VIBRANT.asCharacteristic());
            case RED -> Set.of(Characteristic.EXTRA_ATTEMPTS.asCharacteristic(2));
            case WHITE -> Set.of(Characteristic.EXTRA_ATTEMPTS.asCharacteristic(5));
            case YELLOW -> Set.of(Characteristic.LOOT_QUALITY.asCharacteristic());
        };
    }
}
