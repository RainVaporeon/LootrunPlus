package com.spiritlight.collab.enums;

public enum BeaconType {
    BLUE(Float.POSITIVE_INFINITY),
    PURPLE(Float.POSITIVE_INFINITY),
    YELLOW(Float.POSITIVE_INFINITY),
    AQUA(10),
    ORANGE(2),
    GREY(1),
    DARK_GREY(1),
    WHITE(1),
    GREEN(10),
    RED(10),
    RAINBOW(1);

    private final float maxUses;

    BeaconType(float maxUses) {
        this.maxUses = maxUses;
    }

    public float getMaxUses() {
        return maxUses;
    }
}
