package hoover.becomemon.effect;

import hoover.becomemon.Becomemon;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static StatusEffect PARALYSIS;

    public static StatusEffect registerStatusEffect(String name) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(Becomemon.MOD_ID, name),
                new ParalysisEffect(StatusEffectCategory.HARMFUL, 0xdbcf48).addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED, "7107DE5E-7CE8-4030-940E-514C1F160890", -0.8, EntityAttributeModifier.Operation.MULTIPLY_TOTAL));
    }

    public static void registerEffects() {
        PARALYSIS = registerStatusEffect("paralysis");
    }
}
