package hoover.becomemon.mixin;

import hoover.becomemon.effect.ModEffects;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class ModLivingEntityParalysisJumpModifier {
    @Inject(method = "getJumpVelocity()F", at = @At("HEAD"), cancellable = true)
    protected void modifyJumpVelocityIfParalyzed(CallbackInfoReturnable<Float> cir) {
        LivingEntity thisObject = (LivingEntity)(Object)this;
        if (thisObject.hasStatusEffect(ModEffects.PARALYSIS)) {
            cir.setReturnValue(0.0F);
        }
    }
}
