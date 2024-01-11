package hoover.becomemon.item.custom;

import hoover.becomemon.util.BecomemonCategory;
import hoover.becomemon.util.BecomemonType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Recover extends MoveItem {
    public Recover(Settings settings, BecomemonType type, float power, float accuracy, BecomemonCategory category) {
        super(settings, type, power, accuracy, category);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient && user.getHealth() < user.getMaxHealth()) {
            user.setHealth(user.getHealth() + user.getMaxHealth() / 2);
            return TypedActionResult.success(itemStack);
        }
        return TypedActionResult.pass(itemStack);
    }
}
