package hoover.becomemon.mixin;

import hoover.becomemon.util.BecomemonHelperMethods;
import hoover.becomemon.util.BecomemonType;
import hoover.becomemon.util.IEntityDataSaver;
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
            IEntityDataSaver attackerAsDataSaver = (IEntityDataSaver)source.getAttacker();
            BecomemonType[] attackingType = getTypes(attackerAsDataSaver);

            IEntityDataSaver defenderAsDataSaver = (IEntityDataSaver)this;
            BecomemonType[] defendingType = getTypes(defenderAsDataSaver);

            if (attackingType[0] != null && attackingType[1] != null && defendingType[0] != null && defendingType[1] != null) {
                newAmount *= BecomemonHelperMethods.damageMultiplier(attackingType[0], defendingType[0]);
                newAmount *= BecomemonHelperMethods.damageMultiplier(attackingType[0], defendingType[1]);
                newAmount *= BecomemonHelperMethods.damageMultiplier(attackingType[1], defendingType[0]);
                newAmount *= BecomemonHelperMethods.damageMultiplier(attackingType[1], defendingType[1]);
            }
            return newAmount;
        }
        return amount;
    }
}
