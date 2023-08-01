package com.spiritlight.collab.lootrun.beacon;

import com.spiritlight.collab.lootrun.beacon.characteristics.BeaconCharacteristics;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.jetbrains.annotations.Unmodifiable;

import java.text.DecimalFormat;
import java.util.Objects;
import java.util.Set;

/**
 * An object representing a Beacon in the lootrun.
 * <p>
 * This object contains information such as the beacon type,
 * the node location (which also contains the originated camp),
 * as well as the task. Additionally, the beacon may contain
 * some characteristics.

 */
public class Beacon {

    private static final DecimalFormat defaultFormatter = new DecimalFormat("0.00");

    private final BeaconType type;
    private final BeaconNode node;
    private final String locationName;
    private final BeaconTask task;
    private final Set<BeaconCharacteristics> characteristics;
    private boolean used;

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

    /**
     * Retrieves the distance (in blocks) from the current player to the beacon's node
     * @return {@link Double#NaN} if player is null, otherwise the length from the
     * player to the node.
     */
    public double getDistance() {
        ClientPlayerEntity player = MinecraftClient.getInstance().player;
        if (player == null) {
            return Double.NaN;
        }
        return this.node.subtract(player.getPos()).length();
    }

    /**
     * Retrieves the text representation of this element
     * @return
     */
    public Text toText() {
        return type.toText().append(
            Text.literal(": ").setStyle(Style.EMPTY.withColor(type.getFormatting()))).append(
            Text.literal(locationName + " - " + task.toString().toLowerCase()).setStyle(Style.EMPTY.withColor(Formatting.WHITE))).append(
            Text.literal(" (" + defaultFormatter.format(this.getDistance()) + "m)").setStyle(Style.EMPTY.withColor(Formatting.GRAY))
        );
    }

    public BeaconTask getTask() {
        return task;
    }

    @Unmodifiable
    public Set<BeaconCharacteristics> getCharacteristics() {
        return Set.copyOf(characteristics);
    }

    public boolean isUsed() {
        return used;
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
