package com.spiritlight.collab.beacon;

import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public enum BeaconType {
    BLUE(Float.POSITIVE_INFINITY),
    PURPLE(Float.POSITIVE_INFINITY),
    YELLOW(Float.POSITIVE_INFINITY),
    AQUA(10),
    ORANGE(2),
    GREY(1),
    DARK_GREY(1),
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

    public MutableText toText() {
        switch(this) {
            case BLUE -> { return Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.BLUE)); }
            case PURPLE -> { return Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.DARK_PURPLE)); }
            case YELLOW -> { return Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.YELLOW)); }
            case AQUA -> { return Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.AQUA)); }
            case ORANGE -> { return Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.GOLD)); }
            case GREY -> { return Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.GRAY)); }
            case DARK_GREY -> { return Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.DARK_GRAY)); }
            case WHITE -> { return Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.WHITE)); }
            case GREEN -> { return Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.DARK_GREEN)); }
            case RED -> { return Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.RED)); }
            case RAINBOW -> { return Text.literal("R").setStyle(Style.EMPTY.withColor(Formatting.RED)).append(
                                     Text.literal("A").setStyle(Style.EMPTY.withColor(Formatting.GOLD)).append(
                                     Text.literal("I").setStyle(Style.EMPTY.withColor(Formatting.YELLOW)).append(
                                     Text.literal("N").setStyle(Style.EMPTY.withColor(Formatting.GREEN)).append(
                                     Text.literal("B").setStyle(Style.EMPTY.withColor(Formatting.BLUE)).append(
                                     Text.literal("O").setStyle(Style.EMPTY.withColor(Formatting.DARK_PURPLE)).append(
                                     Text.literal("W").setStyle(Style.EMPTY.withColor(Formatting.LIGHT_PURPLE))))))));
            }
            default -> { return Text.literal(this.toString()).setStyle(Style.EMPTY.withColor(Formatting.WHITE)); }
        }
    }

    public Formatting getFormatting() {
        switch(this) {
            case BLUE -> { return Formatting.BLUE; }
            case PURPLE -> { return Formatting.DARK_PURPLE; }
            case YELLOW -> { return Formatting.YELLOW; }
            case AQUA -> { return Formatting.AQUA; }
            case ORANGE -> { return Formatting.GOLD; }
            case GREY -> { return Formatting.GRAY; }
            case DARK_GREY -> { return Formatting.DARK_GRAY; }
            case GREEN -> { return Formatting.DARK_GREEN; }
            case RED -> { return Formatting.RED; }
            case RAINBOW -> { return Formatting.GRAY; }
            default -> { return Formatting.GRAY; }
        }
    }
}
