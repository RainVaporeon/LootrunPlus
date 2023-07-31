package com.spiritlight.collab.lootrun.beacon;

import com.spiritlight.collab.lootrun.beacon.characteristics.BeaconCharacteristics;
import com.spiritlight.collab.lootrun.camp.Camp;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;

import java.util.HashSet;
import java.util.Set;

public class Beacon {

    private final BeaconType type;
    private final Camp camp;
    private final Vec3d location;
    private final String locationName;
    private final BeaconTask task;
    private final Set<BeaconCharacteristics> characteristics;
    private boolean used;
    private static final Set<Beacon> REGISTRY = new HashSet<>();

    public Beacon(BeaconType type, Camp camp, Vec3d location, String locationName, BeaconTask task) {
        this.type = type;
        this.camp = camp;
        this.location = location;
        this.locationName = locationName;
        this.task = task;
        this.characteristics = type.defaultCharacteristics();
        this.used = false;
        REGISTRY.add(this);
    }

    public void use() {
        used = true;
    }

    public BeaconType getType() {
        return type;
    }

    public Camp getCamp() {
        return camp;
    }

    public Vec3d getLocation() {
        return location;
    }

    public double getDistance() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) {
            return Double.NaN;
        }
        return location.subtract(player.getPos()).length();
    }

    public Text toText() {
        return type.toText().append(
            Text.literal(": ").setStyle(Style.EMPTY.withColor(type.getFormatting()))).append(
            Text.literal(locationName + " - " + task.toString().toLowerCase()).setStyle(Style.EMPTY.withColor(Formatting.WHITE))).append(
            Text.literal(" (" + (int)getDistance() + "m)").setStyle(Style.EMPTY.withColor(Formatting.GRAY))
        );
    }

    public BeaconTask getTask() {
        return task;
    }

    public Set<BeaconCharacteristics> getCharacteristics() {
        return Set.copyOf(characteristics);
    }

    public boolean isUsed() {
        return used;
    }

    public static Set<Beacon> getRegistry() {
        return Set.copyOf(REGISTRY);
    }
}
