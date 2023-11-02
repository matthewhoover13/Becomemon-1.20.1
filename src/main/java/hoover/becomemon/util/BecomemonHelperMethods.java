package hoover.becomemon.util;

import java.util.Random;

public class BecomemonHelperMethods {
    private static final float SUPER_EFFECTIVE_MULTIPLIER = 2f;
    private static final float NOT_VERY_EFFECTIVE_MULTIPLIER = 0.5f;
    private static final float IMMUNE_MULTIPLIER = 0.25f;

    public static boolean accuracyCheck(float accuracy) {
        Random random = new Random();
        return accuracy > random.nextFloat(100);
    }

    public static BecomemonType[] getTypes(IEntityDataSaver entity) {
        BecomemonType[] types = new BecomemonType[2];
        types[0] = BecomemonType.byName(entity.getPersistentData().getString("primaryType"));
        types[1] = BecomemonType.byName(entity.getPersistentData().getString("secondaryType"));
        return types;
    }

    public static float damageMultiplier(BecomemonType attacker, BecomemonType defender) {
        return switch (attacker) {
            case BUG -> switch (defender) {
                case DARK, GRASS, PSYCHIC -> SUPER_EFFECTIVE_MULTIPLIER;
                case FIGHTING, FIRE, FLYING, GHOST, POISON, STEEL -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                default -> 1f;
            };
            case DARK -> switch (defender) {
                case GHOST, PSYCHIC -> SUPER_EFFECTIVE_MULTIPLIER;
                case DARK, FAIRY, FIGHTING -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                default -> 1f;
            };
            case DRAGON -> switch (defender) {
                case DRAGON -> SUPER_EFFECTIVE_MULTIPLIER;
                case STEEL -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                case FAIRY -> IMMUNE_MULTIPLIER;
                default -> 1f;
            };
            case ELECTRIC -> switch (defender) {
                case FLYING, WATER -> SUPER_EFFECTIVE_MULTIPLIER;
                case DRAGON, ELECTRIC, GRASS -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                default -> 1f;
            };
            case FAIRY -> switch (defender) {
                case DARK, DRAGON, FIGHTING -> SUPER_EFFECTIVE_MULTIPLIER;
                case FIRE, POISON, STEEL -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                default -> 1f;
            };
            case FIGHTING -> switch (defender) {
                case DARK, ICE, NORMAL, ROCK, STEEL -> SUPER_EFFECTIVE_MULTIPLIER;
                case BUG, FAIRY, FLYING, POISON, PSYCHIC -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                case GHOST -> IMMUNE_MULTIPLIER;
                default -> 1f;
            };
            case FIRE -> switch (defender) {
                case BUG, GRASS, ICE, STEEL -> SUPER_EFFECTIVE_MULTIPLIER;
                case DRAGON, FIRE, ROCK, WATER -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                default -> 1f;
            };
            case FLYING -> switch (defender) {
                case BUG, FIGHTING, GRASS -> SUPER_EFFECTIVE_MULTIPLIER;
                case ELECTRIC, ROCK, STEEL -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                default -> 1f;
            };
            case GHOST -> switch (defender) {
                case GHOST, PSYCHIC -> SUPER_EFFECTIVE_MULTIPLIER;
                case DARK -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                case NORMAL -> IMMUNE_MULTIPLIER;
                default -> 1f;
            };
            case GRASS -> switch (defender) {
                case GROUND, ROCK, WATER -> SUPER_EFFECTIVE_MULTIPLIER;
                case BUG, DRAGON, FIRE, FLYING, GRASS, POISON, STEEL -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                default -> 1f;
            };
            case GROUND -> switch (defender) {
                case ELECTRIC, FIRE, POISON, ROCK, STEEL -> SUPER_EFFECTIVE_MULTIPLIER;
                case BUG, GRASS -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                case FLYING -> IMMUNE_MULTIPLIER;
                default -> 1f;
            };
            case ICE -> switch (defender) {
                case DRAGON, FLYING, GRASS, GROUND -> SUPER_EFFECTIVE_MULTIPLIER;
                case FIRE, ICE, STEEL, WATER -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                default -> 1f;
            };
            case NORMAL -> switch (defender) {
                case ROCK, STEEL -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                case GHOST -> IMMUNE_MULTIPLIER;
                default -> 1f;
            };
            case POISON -> switch (defender) {
                case FAIRY, GRASS -> SUPER_EFFECTIVE_MULTIPLIER;
                case POISON, GROUND, ROCK, GHOST -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                case STEEL -> IMMUNE_MULTIPLIER;
                default -> 1f;
            };
            case PSYCHIC -> switch (defender) {
                case FIGHTING, POISON -> SUPER_EFFECTIVE_MULTIPLIER;
                case PSYCHIC, STEEL -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                case DARK -> IMMUNE_MULTIPLIER;
                default -> 1f;
            };
            case ROCK -> switch (defender) {
                case BUG, FIRE, FLYING, ICE -> SUPER_EFFECTIVE_MULTIPLIER;
                case FIGHTING, GROUND, STEEL -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                default -> 1f;
            };
            case STEEL -> switch (defender) {
                case FAIRY, ICE, ROCK -> SUPER_EFFECTIVE_MULTIPLIER;
                case ELECTRIC, FIRE, STEEL, WATER -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                default -> 1f;
            };
            case WATER -> switch (defender) {
                case FIRE, GROUND, ROCK -> SUPER_EFFECTIVE_MULTIPLIER;
                case DRAGON, GRASS, WATER -> NOT_VERY_EFFECTIVE_MULTIPLIER;
                default -> 1f;
            };
            default -> 1f;
        };
    }
}
