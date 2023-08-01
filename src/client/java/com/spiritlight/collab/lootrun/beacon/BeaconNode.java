package com.spiritlight.collab.lootrun.beacon;

import com.spiritlight.collab.lootrun.camp.Camp;
import net.minecraft.util.math.Vec3d;

import java.util.Objects;

/**
 * A node representing the location of this beacon.
 * <p>
 * The node extends from {@link Vec3d} for arithmetic support
 * and this object holds a {@link Camp} denoting the originated
 * owner.
 */
public class BeaconNode extends Vec3d {
    private final Camp owner;

    public BeaconNode(Camp owner, int x, int y, int z) {
        super(x, y, z);
        this.owner = owner;
    }

    public BeaconNode(Camp owner, int x, int z) {
        this(owner, x, 0, z);
    }

    public Camp getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BeaconNode that = (BeaconNode) o;
        return Objects.equals(owner, that.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), owner);
    }
}
