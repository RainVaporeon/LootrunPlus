package com.spiritlight.collab.lootrun.beacon;

import com.google.common.annotations.Beta;
import com.spiritlight.collab.lootrun.beacon.characteristics.BeaconCharacteristics;
import com.spiritlight.collab.lootrun.camp.Camp;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Beacon {

    private final BeaconType type;
    private final BeaconNode node;
    private final String locationName;
    private final BeaconTask task;
    private final Set<BeaconCharacteristics> characteristics;
    private boolean used;
    private static final Set<Beacon> REGISTRY = new HashSet<>();

    /* delegate used for jackson deserialization, not intended for use */
    private Beacon() {
        this.type = null;
        this.node = null;
        this.locationName = null;
        this.task = null;
        this.characteristics = null;
    }

    public Beacon(BeaconType type, BeaconNode node, String locationName, BeaconTask task) {
        this.type = type;
        this.node = node;
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

    public BeaconNode getNode() {
        return node;
    }

    public double getDistance() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) {
            return Double.NaN;
        }
        return this.node.subtract(player.getPos()).length();
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beacon beacon = (Beacon) o;
        return type == beacon.type && Objects.equals(node, beacon.node) && Objects.equals(locationName, beacon.locationName) && task == beacon.task && Objects.equals(characteristics, beacon.characteristics);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, node, locationName, task, characteristics);
    }
}
