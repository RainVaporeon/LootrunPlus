package com.spiritlight.collab.lootrun.beacon;

import com.spiritlight.collab.lootrun.beacon.characteristics.BeaconCharacteristics;

import java.util.Set;

public interface IBeacon {

    String getName();

    BeaconColor getColor();

    Set<BeaconCharacteristics> characteristics();

}
