package com.spiritlight.collab.lootrun.beacon;

import com.spiritlight.collab.lootrun.beacon.characteristics.BeaconCharacteristics;
import com.spiritlight.collab.lootrun.beacon.characteristics.Characteristic;
import com.spiritlight.collab.utils.ArgumentType;
import net.minecraft.text.HoverEvent;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.Set;

public enum BeaconType {
    BLUE(Integer.MAX_VALUE),
    PURPLE(Integer.MAX_VALUE),
    YELLOW(Integer.MAX_VALUE),
    AQUA(10),
    ORANGE(2),
    GRAY(1),
    DARK_GRAY(1),
    WHITE(1),
    GREEN(10),
    RED(10),
    RAINBOW(1);

    private final int maxUses;

    BeaconType(int maxUses) {
        this.maxUses = maxUses;
    }

    /**
     * Retrieves the max uses for this beacon
     */
    public int getMaxUses() {
        return maxUses;
    }

    /**
     * Retrieves the default characteristics for this beacon type
     * <p></p>
     * Call to this method is same as calling {@link BeaconType#defaultCharacteristics()}
     *
     * @see BeaconType#defaultCharacteristics()
     */
    public static Set<BeaconCharacteristics> defaultCharacteristics(BeaconType color) {
        return color.defaultCharacteristics();
    }

    /**
     * Retrieves the default characteristics for this beacon type
     * <p></p>
     * The returned characteristic set is immutable.
     */
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

    /**
     * Retrieves a {@link Text} representation of this beacon type.
     * @return A {@link MutableText} instance containing the text representation of
     * this type, with a hover over for all (default) characteristics.
     */
    public MutableText toText() {
        MutableText mt = switch(this) {
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

        StringBuilder builder = new StringBuilder(Formatting.GOLD + "Beacon Characteristics:" + "\n");

        // There's an extra linebreak regardless, though it should not be too much of a concern.
        for(BeaconCharacteristics characteristics : this.defaultCharacteristics()) {
            builder.append(characteristics.toString()).append("\n");
        }

        Style style = mt.getStyle();

        return mt.setStyle(style.withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, Text.of(builder.toString()))));
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
