package hoover.becomemon.item.custom;

import hoover.becomemon.util.BecomemonCategory;
import hoover.becomemon.util.BecomemonType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class Teleport extends MoveItem {
    public Teleport(Settings settings, BecomemonType type, float power, float accuracy, BecomemonCategory category) {
        super(settings, type, power, accuracy, category);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        if (!world.isClient) {
            float f = user.getPitch();
            float g = user.getYaw();
            Vec3d vec3d = user.getEyePos();
            float h = MathHelper.cos(-g * 0.017453292F - 3.1415927F);
            float i = MathHelper.sin(-g * 0.017453292F - 3.1415927F);
            float j = -MathHelper.cos(-f * 0.017453292F);
            float k = MathHelper.sin(-f * 0.017453292F);
            float l = i * j;
            float n = h * j;
            double d = 64.0;
            Vec3d vec3d2 = vec3d.add((double)l * d, (double)k * d, (double)n * d);
            BlockHitResult blockHitResult = world.raycast(new RaycastContext(vec3d, vec3d2, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, user));
            if (blockHitResult.getType() == HitResult.Type.BLOCK) {
                BlockPos blockPos = blockHitResult.getBlockPos();
                blockPos = blockHitResult.getSide() == Direction.DOWN ? blockPos.add(blockHitResult.getSide().getVector().multiply(2)) : blockPos.add(blockHitResult.getSide().getVector());
                user.teleport(blockPos.getX() + 0.5F, blockPos.getY(), blockPos.getZ() + 0.5F);
                user.getItemCooldownManager().set(this, 200);
                return TypedActionResult.success(itemStack, world.isClient());
            }
        }
        return TypedActionResult.pass(itemStack);
    }
}
