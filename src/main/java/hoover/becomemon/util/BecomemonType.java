package hoover.becomemon.util;

import net.minecraft.text.Text;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import org.jetbrains.annotations.Nullable;

import java.util.function.IntFunction;

public enum BecomemonType implements StringIdentifiable {
    BUG(0, "bug"),
    DARK(1, "dark"),
    DRAGON(2, "dragon"),
    ELECTRIC(3, "electric"),
    FAIRY(4, "fairy"),
    FIGHTING(5, "fighting"),
    FIRE(6, "fire"),
    FLYING(7, "flying"),
    GHOST(8, "ghost"),
    GRASS(9, "grass"),
    GROUND(10, "ground"),
    ICE(11, "ice"),
    NORMAL(12, "normal"),
    POISON(13, "poison"),
    PSYCHIC(14, "psychic"),
    ROCK(15, "rock"),
    STEEL(16, "steel"),
    TYPELESS(17, "typeless"),
    WATER(18, "water");

    public static final StringIdentifiable.Codec<BecomemonType> CODEC;
    private static final IntFunction<BecomemonType> BY_ID;
    private final int id;
    private final String name;

    private BecomemonType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return this.id; }

    public Text getTranslatableName() { return Text.translatable("becomemon.type." + this.name); }

    public Text getInfo() { return Text.translatable("becomemon.type." + this.name + ".info"); }

    public static BecomemonType byId(int id) { return BY_ID.apply(id); }

    @Nullable
    public static BecomemonType byName(String name) { return CODEC.byId(name); }

    public String getName() { return this.name; }

    @Override
    public String asString() { return this.name; }

    static {
        CODEC = StringIdentifiable.createCodec(BecomemonType::values);
        BY_ID = ValueLists.createIdToValueFunction(BecomemonType::getId, BecomemonType.values(), ValueLists.OutOfBoundsHandling.WRAP);
    }
}
