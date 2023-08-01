package com.spiritlight.collab.lootrun.beacon.characteristics;

import com.spiritlight.collab.utils.ArgumentType;
import org.jetbrains.annotations.Contract;

public enum Characteristic {
    CURSE("Buffed enemy stats"),
    EXTRA_ROLL("Extra reward roll"),
    LOOT_QUALITY("Better loot in next chest"),
    POWER_UP("Choose a power-up"),

    EXTRA_BEACON_CHOICE("Extra beacon choice"),
    AMPLIFIER("Amplified next beacon stat"),
    END_REROLL_BONUS("Extra end reward re-roll"),
    EXTRA_ATTEMPTS("Extra attempts"),
    EXTRA_TIME("Increased timer"),
    MULTIPLIER("Vibrant (2x Effect)"), // Unused - Reserved for "Vibrant" beacons.
    ALL_VIBRANT("Makes every beacon vibrant")
    ;

    private final String description;

    Characteristic(String description) {
        this.description = description;
    }

    /**
     * Retrieves a simple line describing the effect of this beacon
     */
    public String getDescription() {
        return description;
    }

    /**
     * Creates a new beacon characteristic from this characteristic
     * @param type the type of the value
     * @param value the value
     * @return a new instance of beacon characteristic
     */
    @Contract("_, _ -> new")
    public BeaconCharacteristics asCharacteristic(ArgumentType type, int value) {
        return BeaconCharacteristics.of(this, type, value);
    }

    /**
     * Creates a new beacon characteristic from this characteristic
     * @param value the value
     * @return a new instance of beacon characteristic, with the value type
     * as {@link ArgumentType#VALUE}
     */
    @Contract("_ -> new")
    public BeaconCharacteristics asCharacteristic(int value) {
        return BeaconCharacteristics.of(this, ArgumentType.VALUE, value);
    }

    /**
     * Creates a new beacon characteristic from this characteristic
     * @return a new instance of beacon characteristic, with the value type
     * as {@link ArgumentType#VALUE}, and a value of {@code 0}
     */
    @Contract("-> new")
    public BeaconCharacteristics asCharacteristic() {
        return BeaconCharacteristics.of(this, ArgumentType.VALUE, 0);
    }
}
