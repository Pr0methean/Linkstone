package net.minecraft.server;

import net.glowstone.linkstone.annotations.LClassfile;
import net.glowstone.linkstone.annotations.LEnum;
import net.glowstone.linkstone.annotations.LField;
import net.glowstone.linkstone.annotations.LMethod;

import static net.glowstone.linkstone.annotations.Version.V1_12_R1;

@LClassfile(version = V1_12_R1)
public enum EnumDifficulty {
    @LEnum(version = V1_12_R1)
    PEACEFUL(0, "peaceful"),

    @LEnum(version = V1_12_R1)
    EASY(1, "easy"),

    @LEnum(version = V1_12_R1)
    NORMAL(2, "normal"),

    @LEnum(version = V1_12_R1)
    HARD(3, "hard");

    @LMethod(version = V1_12_R1)
    public static EnumDifficulty getById(int n) {
        return values[n % values.length];
    }

    @LField(version = V1_12_R1, name = "e")
    private static final EnumDifficulty[] values = EnumDifficulty.values();

    @LField(version = V1_12_R1, name = "f")
    private final int id;

    @LField(version = V1_12_R1, name = "g")
    private final String optionName;

    EnumDifficulty(int id, String name) {
        this.id = id;
        this.optionName = "options.difficulty." + name;
    }

    @LMethod(version = V1_12_R1, name = "a")
    public int getId() {
        return id;
    }

    @LMethod(version = V1_12_R1, name = "b")
    public String getOptionName() {
        return optionName;
    }
}
