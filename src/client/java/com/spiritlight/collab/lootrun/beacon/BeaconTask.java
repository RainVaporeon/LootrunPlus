package com.spiritlight.collab.lootrun.beacon;

import com.spiritlight.collab.utils.StringUtils;

public enum BeaconTask {
    SPELUNK("Loot all chests in this cave"),
    SLAY("Slay all mob waves"),
    SLAY_TARGET("Slay all targeted mobs"),
    DESTROY("Destroy the objective"),
    DEFEND("Protect the objective for long enough")
    ;

    private final String description;

    BeaconTask(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return StringUtils.asTitle(this.name());
    }
}
