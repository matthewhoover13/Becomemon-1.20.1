package hoover.becomemon.item.custom;

import hoover.becomemon.util.BecomemonCategory;
import hoover.becomemon.util.BecomemonHelperMethods;
import hoover.becomemon.util.BecomemonType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class WillOWisp extends MoveItem {
    public WillOWisp(Settings settings, BecomemonType type, float power, float accuracy, BecomemonCategory category) {
        super(settings, type, power, accuracy, category);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getWorld().isClient()) {
            if (BecomemonHelperMethods.accuracyCheck(accuracy)) {
                entity.setOnFireFor(5);
                user.getWorld().playSound(null, entity.getBlockPos(), SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.PLAYERS, 1.0f, 1.0f);
            } else {
                user.getWorld().playSound(null, entity.getBlockPos(), SoundEvents.ENTITY_PLAYER_ATTACK_NODAMAGE, SoundCategory.PLAYERS, 1.0f, 1.0f);
            }
        }

        return ActionResult.SUCCESS;
    }
}
