package hoover.becomemon.mixin;

import hoover.becomemon.util.BecomemonType;
import hoover.becomemon.util.IEntityTypeStorage;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import static hoover.becomemon.util.BecomemonHelperMethods.*;

@Mixin(LivingEntity.class)
public abstract class ModLivingEntityDamageModifier {
    @ModifyVariable(method = "damage", at = @At("HEAD"))
    protected float modifyDamage(float amount, DamageSource source) {
        float newAmount = amount;

        if (source.getAttacker() != null && source.getAttacker().isLiving()) {
            IEntityTypeStorage attacker = (IEntityTypeStorage) source.getAttacker();
            BecomemonType[] attackingType = getTypes(attacker);

            IEntityTypeStorage defender = (IEntityTypeStorage) this;
            BecomemonType[] defendingType = getTypes(defender);

            if (attackingType[0] != null && attackingType[1] != null && defendingType[0] != null && defendingType[1] != null) {
                newAmount *= damageMultiplier(attackingType[0], defendingType[0]);
                newAmount *= damageMultiplier(attackingType[0], defendingType[1]);
                newAmount *= damageMultiplier(attackingType[1], defendingType[0]);
                newAmount *= damageMultiplier(attackingType[1], defendingType[1]);
            }

            return newAmount;
        }
        return amount;
    }
}
