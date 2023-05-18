package hoover.becomemon.mixin;

import hoover.becomemon.util.BecomemonType;
import hoover.becomemon.util.IEntityDataSaver;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class ModLivingEntityTypeInjector {
    @Inject(method = "<init>", at = @At("TAIL"))
    protected void injectTypeIntoConstructor(EntityType<? extends LivingEntity> entityType, World world, CallbackInfo info) {
        BecomemonType type = switch (entityType.getUntranslatedName()) {
            case "allay":
                yield BecomemonType.FAIRY;
            case "axolotl":
                yield BecomemonType.WATER;
            case "bat":
                yield BecomemonType.FLYING;
            case "bee":
                yield BecomemonType.BUG;
            case "blaze":
                yield BecomemonType.FIRE;
            case "camel":
                yield BecomemonType.GROUND;
            case "cat":
                yield BecomemonType.NORMAL;
            case "cave_spider":
                yield BecomemonType.POISON;
            case "chicken":
                yield BecomemonType.FLYING;
            case "cod":
                yield BecomemonType.WATER;
            case "cow":
                yield BecomemonType.NORMAL;
            case "creeper":
                yield BecomemonType.ELECTRIC;
            case "dolphin":
                yield BecomemonType.WATER;
            case "donkey":
                yield BecomemonType.GROUND;
            case "drowned":
                yield BecomemonType.WATER;
            case "elder_guardian":
                yield BecomemonType.WATER;
            case "ender_dragon":
                yield BecomemonType.DRAGON;
            case "enderman":
                yield BecomemonType.PSYCHIC;
            case "endermite":
                yield BecomemonType.PSYCHIC;
            case "evoker":
                yield BecomemonType.DARK;
            case "fox":
                yield BecomemonType.NORMAL;
            case "frog":
                yield BecomemonType.WATER;
            case "ghast":
                yield BecomemonType.GHOST;
            case "glow_squid":
                yield BecomemonType.WATER;
            case "goat":
                yield BecomemonType.ROCK;
            case "guardian":
                yield BecomemonType.WATER;
            case "hoglin":
                yield BecomemonType.FIGHTING;
            case "horse":
                yield BecomemonType.GROUND;
            case "husk":
                yield BecomemonType.POISON;
            case "iron_golem":
                yield BecomemonType.STEEL;
            case "llama":
                yield BecomemonType.GROUND;
            case "magma_cube":
                yield BecomemonType.FIRE;
            case "mooshroom":
                yield BecomemonType.GRASS;
            case "mule":
                yield BecomemonType.GROUND;
            case "ocelot":
                yield BecomemonType.NORMAL;
            case "panda":
                yield BecomemonType.GRASS;
            case "parrot":
                yield BecomemonType.FLYING;
            case "phantom":
                yield BecomemonType.FLYING;
            case "pig":
                yield BecomemonType.NORMAL;
            case "piglin":
                yield BecomemonType.ROCK;
            case "piglin_brute":
                yield BecomemonType.FIGHTING;
            case "pillager":
                yield BecomemonType.NORMAL;
            case "polar_bear":
                yield BecomemonType.ICE;
            case "pufferfish":
                yield BecomemonType.POISON;
            case "rabbit":
                yield BecomemonType.NORMAL;
            case "ravager":
                yield BecomemonType.FIGHTING;
            case "salmon":
                yield BecomemonType.WATER;
            case "sheep":
                yield BecomemonType.NORMAL;
            case "shulker":
                yield BecomemonType.PSYCHIC;
            case "silverfish":
                yield BecomemonType.BUG;
            case "skeleton":
                yield BecomemonType.GHOST;
            case "skeleton_horse":
                yield BecomemonType.GHOST;
            case "slime":
                yield BecomemonType.NORMAL;
            case "sniffer":
                yield BecomemonType.ROCK;
            case "snow_golem":
                yield BecomemonType.ICE;
            case "spider":
                yield BecomemonType.DARK;
            case "squid":
                yield BecomemonType.WATER;
            case "stray":
                yield BecomemonType.ICE;
            case "strider":
                yield BecomemonType.FIRE;
            case "tadpole":
                yield BecomemonType.WATER;
            case "trader_llama":
                yield BecomemonType.GROUND;
            case "tropical_fish":
                yield BecomemonType.WATER;
            case "turtle":
                yield BecomemonType.WATER;
            case "vex":
                yield BecomemonType.GHOST;
            case "villager":
                yield BecomemonType.NORMAL;
            case "vindicator":
                yield BecomemonType.FIGHTING;
            case "wandering_trader":
                yield BecomemonType.NORMAL;
            case "warden":
                yield BecomemonType.DARK;
            case "witch":
                yield BecomemonType.DARK;
            case "wither":
                yield BecomemonType.POISON;
            case "wither_skeleton":
                yield BecomemonType.POISON;
            case "wolf":
                yield BecomemonType.NORMAL;
            case "zoglin":
                yield BecomemonType.GHOST;
            case "zombie":
                yield BecomemonType.GHOST;
            case "zombie_horse":
                yield BecomemonType.GHOST;
            case "zombie_villager":
                yield BecomemonType.GHOST;
            case "zombified_piglin":
                yield BecomemonType.GHOST;
            default:
                yield BecomemonType.TYPELESS;
        };

        IEntityDataSaver entity = (IEntityDataSaver)this;
        entity.getPersistentData().putString("type", type.getName());

        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player != null && entity.getPersistentData().getString("type").equals("typeless")) {
            mc.player.sendMessage(Text.of(entityType.getUntranslatedName() + ": " + entity.getPersistentData().getString("type")));
        }
    }
}
