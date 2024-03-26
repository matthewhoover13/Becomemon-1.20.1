package hoover.becomemon.item.custom;

import hoover.becomemon.effect.ModEffects;
import hoover.becomemon.util.BecomemonCategory;
import hoover.becomemon.util.BecomemonHelperMethods;
import hoover.becomemon.util.BecomemonType;
import hoover.becomemon.util.IEntityDataSaver;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class ThunderWave extends MoveItem {
    public ThunderWave(Settings settings, BecomemonType type, float power, float accuracy, BecomemonCategory category) {
        super(settings, type, power, accuracy, category);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getWorld().isClient()) {
            IEntityDataSaver targetAsDataSaver = (IEntityDataSaver)entity;
            BecomemonType[] targetTypes = BecomemonHelperMethods.getTypes(targetAsDataSaver);
            if (BecomemonHelperMethods.accuracyCheck(accuracy) && targetTypes[0] != BecomemonType.GROUND && targetTypes[1] != BecomemonType.GROUND) {
                entity.addStatusEffect(new StatusEffectInstance(ModEffects.PARALYSIS, 200));
                user.getWorld().playSound(null, entity.getBlockPos(), SoundEvents.ENTITY_ELDER_GUARDIAN_CURSE, SoundCategory.PLAYERS, 1.0f, 1.6f);
            } else {
                user.getWorld().playSound(null, entity.getBlockPos(), SoundEvents.ENTITY_PLAYER_ATTACK_NODAMAGE, SoundCategory.PLAYERS, 1.0f, 1.0f);
            }
        }

        return ActionResult.SUCCESS;
    }
}
