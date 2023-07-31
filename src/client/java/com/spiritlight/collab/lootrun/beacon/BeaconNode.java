package com.spiritlight.collab.lootrun.beacon;

public abstract class BeaconNode {

    private final int x;
    private final int y;

    private final IBeacon beacon;

    public BeaconNode(int x, int y, IBeacon beacon) {
        this.x = x;
        this.y = y;
        this.beacon = beacon;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public IBeacon getBeacon() {
        return beacon;
    }
}
