package hoover.becomemon.mixin;

import hoover.becomemon.util.BecomemonHelperMethods;
import hoover.becomemon.util.BecomemonType;
import hoover.becomemon.util.IEntityDataSaver;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(LivingEntity.class)
public abstract class ModLivingEntityDamageModifier {
    @ModifyVariable(method = "damage", at = @At("HEAD"))
    protected float modifyDamage(float amount, DamageSource source) {
        float newAmount = amount;

        if (source.getSource() != null && source.getSource().isLiving()) {
            IEntityDataSaver attackerAsDataSaver = (IEntityDataSaver)source.getSource();
            BecomemonType attackingPrimaryType = BecomemonType.byName(attackerAsDataSaver.getPersistentData().getString("primaryType"));
            BecomemonType attackingSecondaryType = BecomemonType.byName(attackerAsDataSaver.getPersistentData().getString("secondaryType"));

            IEntityDataSaver defenderAsDataSaver = (IEntityDataSaver)this;
            BecomemonType defendingPrimaryType = BecomemonType.byName(defenderAsDataSaver.getPersistentData().getString("primaryType"));
            BecomemonType defendingSecondaryType = BecomemonType.byName(defenderAsDataSaver.getPersistentData().getString("secondaryType"));

            if (attackingPrimaryType != null && attackingSecondaryType != null && defendingPrimaryType != null && defendingSecondaryType != null) {
                newAmount *= BecomemonHelperMethods.damageMultiplier(attackingPrimaryType, defendingPrimaryType);
                newAmount *= BecomemonHelperMethods.damageMultiplier(attackingPrimaryType, defendingSecondaryType);
                newAmount *= BecomemonHelperMethods.damageMultiplier(attackingSecondaryType, defendingPrimaryType);
                newAmount *= BecomemonHelperMethods.damageMultiplier(attackingSecondaryType, defendingSecondaryType);
            }
            return newAmount;
        }
        return amount;
    }
}
