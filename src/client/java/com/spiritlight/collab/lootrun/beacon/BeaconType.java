package com.spiritlight.collab.lootrun.beacon;

import com.spiritlight.collab.lootrun.beacon.characteristics.BeaconCharacteristics;
import com.spiritlight.collab.lootrun.beacon.characteristics.Characteristic;
import com.spiritlight.collab.utils.ArgumentType;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Set;

public enum BeaconType {
    BLUE(Float.POSITIVE_INFINITY),
    PURPLE(Float.POSITIVE_INFINITY),
    YELLOW(Float.POSITIVE_INFINITY),
    AQUA(10),
    ORANGE(2),
    GRAY(1),
    DARK_GRAY(1),
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

    public static Set<BeaconCharacteristics> defaultCharacteristics(BeaconType color) {
        return color.defaultCharacteristics();
    }

    public Set<BeaconCharacteristics> defaultCharacteristics() {
        return switch(this) {
            case AQUA -> Set.of(Characteristic.AMPLIFIER.asCharacteristic(ArgumentType.MULTIPLIER, 1));
            case BLUE -> Set.of(Characteristic.POWER_UP.asCharacteristic());
            case DARK_GRAY -> Set.of(Characteristic.CURSE.asCharacteristic(3), Characteristic.EXTRA_ROLL.asCharacteristic(5));
            case GRAY -> Set.of(Characteristic.END_REROLL_BONUS.asCharacteristic(1));
            case GREEN -> Set.of(Characteristic.EXTRA_TIME.asCharacteristic(ArgumentType.TIME,120));
            case ORANGE -> Set.of(Characteristic.EXTRA_BEACON_CHOICE.asCharacteristic(1));
            case PURPLE -> Set.of(Characteristic.CURSE.asCharacteristic(1), Characteristic.EXTRA_ROLL.asCharacteristic(1));
            case RAINBOW -> Set.of(Characteristic.ALL_VIBRANT.asCharacteristic());
            case RED -> Set.of(Characteristic.EXTRA_ATTEMPTS.asCharacteristic(2));
            case WHITE -> Set.of(Characteristic.EXTRA_ATTEMPTS.asCharacteristic(5));
            case YELLOW -> Set.of(Characteristic.LOOT_QUALITY.asCharacteristic());
        };
    }

    public MutableText toText() {
        return switch(this) {
            case BLUE -> Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.BLUE));
            case PURPLE -> Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.DARK_PURPLE));
            case YELLOW -> Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.YELLOW));
            case AQUA -> Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.AQUA));
            case ORANGE -> Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.GOLD));
            case GRAY -> Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.GRAY));
            case DARK_GRAY -> Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.DARK_GRAY));
            case WHITE -> Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.WHITE));
            case GREEN -> Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.DARK_GREEN));
            case RED -> Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.RED));
            case RAINBOW -> Text.literal("R").setStyle(Style.EMPTY.withColor(Formatting.RED)).append(
                            Text.literal("A").setStyle(Style.EMPTY.withColor(Formatting.GOLD)).append(
                            Text.literal("I").setStyle(Style.EMPTY.withColor(Formatting.YELLOW)).append(
                            Text.literal("N").setStyle(Style.EMPTY.withColor(Formatting.GREEN)).append(
                            Text.literal("B").setStyle(Style.EMPTY.withColor(Formatting.BLUE)).append(
                            Text.literal("O").setStyle(Style.EMPTY.withColor(Formatting.DARK_PURPLE)).append(
                            Text.literal("W").setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE))))))));
        };
    }

    public Formatting getFormatting() {
        return switch(this) {
            case BLUE -> Formatting.BLUE;
            case PURPLE -> Formatting.DARK_PURPLE;
            case YELLOW -> Formatting.YELLOW;
            case AQUA -> Formatting.AQUA;
            case ORANGE -> Formatting.GOLD;
            case GRAY -> Formatting.GRAY;
            case DARK_GRAY -> Formatting.DARK_GRAY;
            case WHITE -> Formatting.WHITE;
            case GREEN -> Formatting.DARK_GREEN;
            case RED -> Formatting.RED;
            case RAINBOW -> Formatting.GRAY;
        };
    }
}
