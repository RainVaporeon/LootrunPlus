package com.spiritlight.collab.beacon;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;

public class Beacon {
    private final BeaconType type;
    private final Vec3d location;
    private final String locationName;
    private final BeaconTask task;
    private boolean used;

    public Beacon(BeaconType type, Vec3d location, String locationName, BeaconTask task) {
        this.type = type;
        this.location = location;
        this.locationName = locationName;
        this.task = task;
        this.used = false;
    }

    public void use() {
        used = true;
    }

    public BeaconType getType() {
        return type;
    }

    public BeaconTask getTask() {
        return task;
    }

    public double getDistance() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) {
            return Double.NaN;
        }
        return location.subtract(player.getPos()).length();
    }

    public boolean isUsed() {
        return used;
    }

    public Text toText() {
        return type.toText().append( Text.literal(": ").setStyle(Style.EMPTY.withColor(type.getFormatting()))).append(
        Text.literal(locationName + " - " + task.toString().toLowerCase()).setStyle(Style.EMPTY.withColor(Formatting.WHITE))).append(
        Text.literal(" (" + (int)getDistance() + "m)").setStyle(Style.EMPTY.withColor(Formatting.GRAY)));
    }
}
