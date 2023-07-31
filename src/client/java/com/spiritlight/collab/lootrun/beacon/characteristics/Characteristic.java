package com.spiritlight.collab.lootrun.beacon.characteristics;

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
    MULTIPLIER("Vibrant (2x Effect)"),
    ALL_VIBRANT("Makes every beacon vibrant")
    ;

    private final String description;

    Characteristic(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public BeaconCharacteristics asCharacteristic(int value) {
        return BeaconCharacteristics.of(this, value);
    }

    public BeaconCharacteristics asCharacteristic() {
        return BeaconCharacteristics.of(this, 0);
    }
}
