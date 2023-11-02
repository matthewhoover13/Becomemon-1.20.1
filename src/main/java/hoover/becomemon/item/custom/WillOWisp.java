package hoover.becomemon.item.custom;

import hoover.becomemon.util.BecomemonHelperMethods;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class WillOWisp extends Item {
    private static final float ACCURACY = 85;

    public WillOWisp(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getWorld().isClient()) {
            if (BecomemonHelperMethods.accuracyCheck(ACCURACY)) {
                entity.setOnFireFor(5);
                user.sendMessage(Text.literal("Success"));
            } else {
                user.sendMessage(Text.literal("Missed"));
            }
        }

        return ActionResult.SUCCESS;
    }
}
