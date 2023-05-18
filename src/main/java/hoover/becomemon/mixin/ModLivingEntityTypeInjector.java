package hoover.becomemon.mixin;

import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class ModLivingEntityTypeInjector {
    @Inject(method = "<init>", at = @At("TAIL"))
    protected void injectTypeIntoConstructor(CallbackInfo info) {

    }
}
