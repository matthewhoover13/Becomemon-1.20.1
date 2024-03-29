package hoover.becomemon.mixin;

import hoover.becomemon.util.BecomemonType;
import hoover.becomemon.util.IEntityDataSaver;
import hoover.becomemon.util.IPlayerTypeStorage;
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
        if (!world.isClient()) {
            BecomemonType[] type = switch (entityType.getUntranslatedName()) {
                case "allay":
                    yield new BecomemonType[]{BecomemonType.FAIRY, BecomemonType.TYPELESS};
                case "axolotl":
                    yield new BecomemonType[]{BecomemonType.WATER, BecomemonType.TYPELESS};
                case "bat":
                    yield new BecomemonType[]{BecomemonType.FLYING, BecomemonType.TYPELESS};
                case "bee":
                    yield new BecomemonType[]{BecomemonType.BUG, BecomemonType.FLYING};
                case "blaze":
                    yield new BecomemonType[]{BecomemonType.FIRE, BecomemonType.TYPELESS};
                case "camel":
                    yield new BecomemonType[]{BecomemonType.GROUND, BecomemonType.TYPELESS};
                case "cat":
                    yield new BecomemonType[]{BecomemonType.NORMAL, BecomemonType.TYPELESS};
                case "cave_spider":
                    yield new BecomemonType[]{BecomemonType.BUG, BecomemonType.POISON};
                case "chicken":
                    yield new BecomemonType[]{BecomemonType.NORMAL, BecomemonType.FLYING};
                case "cod":
                    yield new BecomemonType[]{BecomemonType.WATER, BecomemonType.TYPELESS};
                case "cow":
                    yield new BecomemonType[]{BecomemonType.NORMAL, BecomemonType.TYPELESS};
                case "creeper":
                    yield new BecomemonType[]{BecomemonType.ELECTRIC, BecomemonType.TYPELESS};
                case "dolphin":
                    yield new BecomemonType[]{BecomemonType.WATER, BecomemonType.TYPELESS};
                case "donkey":
                    yield new BecomemonType[]{BecomemonType.GROUND, BecomemonType.TYPELESS};
                case "drowned":
                    yield new BecomemonType[]{BecomemonType.GHOST, BecomemonType.WATER};
                case "elder_guardian":
                    yield new BecomemonType[]{BecomemonType.WATER, BecomemonType.DARK};
                case "ender_dragon":
                    yield new BecomemonType[]{BecomemonType.DRAGON, BecomemonType.TYPELESS};
                case "enderman":
                    yield new BecomemonType[]{BecomemonType.PSYCHIC, BecomemonType.TYPELESS};
                case "endermite":
                    yield new BecomemonType[]{BecomemonType.PSYCHIC, BecomemonType.BUG};
                case "evoker":
                    yield new BecomemonType[]{BecomemonType.PSYCHIC, BecomemonType.TYPELESS};
                case "fox":
                    yield new BecomemonType[]{BecomemonType.NORMAL, BecomemonType.TYPELESS};
                case "frog":
                    yield new BecomemonType[]{BecomemonType.WATER, BecomemonType.TYPELESS};
                case "ghast":
                    yield new BecomemonType[]{BecomemonType.FIRE, BecomemonType.GHOST};
                case "glow_squid":
                    yield new BecomemonType[]{BecomemonType.WATER, BecomemonType.FAIRY};
                case "goat":
                    yield new BecomemonType[]{BecomemonType.NORMAL, BecomemonType.ROCK};
                case "guardian":
                    yield new BecomemonType[]{BecomemonType.WATER, BecomemonType.DARK};
                case "hoglin":
                    yield new BecomemonType[]{BecomemonType.FIGHTING, BecomemonType.TYPELESS};
                case "horse":
                    yield new BecomemonType[]{BecomemonType.GROUND, BecomemonType.TYPELESS};
                case "husk":
                    yield new BecomemonType[]{BecomemonType.GHOST, BecomemonType.GROUND};
                case "iron_golem":
                    yield new BecomemonType[]{BecomemonType.STEEL, BecomemonType.TYPELESS};
                case "llama":
                    yield new BecomemonType[]{BecomemonType.GROUND, BecomemonType.TYPELESS};
                case "magma_cube":
                    yield new BecomemonType[]{BecomemonType.FIRE, BecomemonType.TYPELESS};
                case "mooshroom":
                    yield new BecomemonType[]{BecomemonType.NORMAL, BecomemonType.GRASS};
                case "mule":
                    yield new BecomemonType[]{BecomemonType.GROUND, BecomemonType.TYPELESS};
                case "ocelot":
                    yield new BecomemonType[]{BecomemonType.NORMAL, BecomemonType.TYPELESS};
                case "panda":
                    yield new BecomemonType[]{BecomemonType.GRASS, BecomemonType.TYPELESS};
                case "parrot":
                    yield new BecomemonType[]{BecomemonType.FLYING, BecomemonType.TYPELESS};
                case "phantom":
                    yield new BecomemonType[]{BecomemonType.FLYING, BecomemonType.GHOST};
                case "pig":
                    yield new BecomemonType[]{BecomemonType.NORMAL, BecomemonType.TYPELESS};
                case "piglin":
                    yield new BecomemonType[]{BecomemonType.FIGHTING, BecomemonType.ROCK};
                case "piglin_brute":
                    yield new BecomemonType[]{BecomemonType.FIGHTING, BecomemonType.STEEL};
                case "pillager":
                    yield new BecomemonType[]{BecomemonType.FIGHTING, BecomemonType.TYPELESS};
                case "polar_bear":
                    yield new BecomemonType[]{BecomemonType.ICE, BecomemonType.TYPELESS};
                case "pufferfish":
                    yield new BecomemonType[]{BecomemonType.WATER, BecomemonType.POISON};
                case "rabbit":
                    yield new BecomemonType[]{BecomemonType.NORMAL, BecomemonType.TYPELESS};
                case "ravager":
                    yield new BecomemonType[]{BecomemonType.FIGHTING, BecomemonType.TYPELESS};
                case "salmon":
                    yield new BecomemonType[]{BecomemonType.WATER, BecomemonType.TYPELESS};
                case "sheep":
                    yield new BecomemonType[]{BecomemonType.NORMAL, BecomemonType.TYPELESS};
                case "shulker":
                    yield new BecomemonType[]{BecomemonType.PSYCHIC, BecomemonType.TYPELESS};
                case "silverfish":
                    yield new BecomemonType[]{BecomemonType.BUG, BecomemonType.TYPELESS};
                case "skeleton":
                    yield new BecomemonType[]{BecomemonType.GHOST, BecomemonType.TYPELESS};
                case "skeleton_horse":
                    yield new BecomemonType[]{BecomemonType.GROUND, BecomemonType.GHOST};
                case "slime":
                    yield new BecomemonType[]{BecomemonType.NORMAL, BecomemonType.TYPELESS};
                case "sniffer":
                    yield new BecomemonType[]{BecomemonType.GRASS, BecomemonType.TYPELESS};
                case "snow_golem":
                    yield new BecomemonType[]{BecomemonType.ICE, BecomemonType.TYPELESS};
                case "spider":
                    yield new BecomemonType[]{BecomemonType.BUG, BecomemonType.TYPELESS};
                case "squid":
                    yield new BecomemonType[]{BecomemonType.WATER, BecomemonType.TYPELESS};
                case "stray":
                    yield new BecomemonType[]{BecomemonType.GHOST, BecomemonType.ICE};
                case "strider":
                    yield new BecomemonType[]{BecomemonType.FIRE, BecomemonType.TYPELESS};
                case "tadpole":
                    yield new BecomemonType[]{BecomemonType.NORMAL, BecomemonType.WATER};
                case "trader_llama":
                    yield new BecomemonType[]{BecomemonType.GROUND, BecomemonType.TYPELESS};
                case "tropical_fish":
                    yield new BecomemonType[]{BecomemonType.WATER, BecomemonType.TYPELESS};
                case "turtle":
                    yield new BecomemonType[]{BecomemonType.WATER, BecomemonType.ROCK};
                case "vex":
                    yield new BecomemonType[]{BecomemonType.GHOST, BecomemonType.DARK};
                case "villager":
                    yield new BecomemonType[]{BecomemonType.NORMAL, BecomemonType.TYPELESS};
                case "vindicator":
                    yield new BecomemonType[]{BecomemonType.FIGHTING, BecomemonType.STEEL};
                case "wandering_trader":
                    yield new BecomemonType[]{BecomemonType.NORMAL, BecomemonType.TYPELESS};
                case "warden":
                    yield new BecomemonType[]{BecomemonType.DARK, BecomemonType.TYPELESS};
                case "witch":
                    yield new BecomemonType[]{BecomemonType.POISON, BecomemonType.TYPELESS};
                case "wither":
                    yield new BecomemonType[]{BecomemonType.DARK, BecomemonType.POISON};
                case "wither_skeleton":
                    yield new BecomemonType[]{BecomemonType.GHOST, BecomemonType.POISON};
                case "wolf":
                    yield new BecomemonType[]{BecomemonType.NORMAL, BecomemonType.TYPELESS};
                case "zoglin":
                    yield new BecomemonType[]{BecomemonType.FIGHTING, BecomemonType.GHOST};
                case "zombie":
                    yield new BecomemonType[]{BecomemonType.GHOST, BecomemonType.TYPELESS};
                case "zombie_horse":
                    yield new BecomemonType[]{BecomemonType.GROUND, BecomemonType.GHOST};
                case "zombie_villager":
                    yield new BecomemonType[]{BecomemonType.NORMAL, BecomemonType.GHOST};
                case "zombified_piglin":
                    yield new BecomemonType[]{BecomemonType.FIGHTING, BecomemonType.GHOST};
                default:
                    yield new BecomemonType[]{BecomemonType.TYPELESS, BecomemonType.TYPELESS};
            };

            IEntityDataSaver entity = (IEntityDataSaver) this;
            entity.getPersistentData().putString("primaryType", type[0].getName());
            entity.getPersistentData().putString("secondaryType", type[1].getName());

            MinecraftClient mc = MinecraftClient.getInstance();
            if (mc.player != null && entity.getPersistentData().getString("primaryType").equals("typeless")) {
                String typeAsString = entity.getPersistentData().getString("primaryType");
                if (!entity.getPersistentData().getString("secondaryType").equals("typeless")) {
                    typeAsString += " | " + entity.getPersistentData().getString("secondaryType");
                }
                mc.player.sendMessage(Text.of(
                        entityType.getUntranslatedName() + ": " + typeAsString
                ));
                if (entityType == EntityType.PLAYER) {
                    IPlayerTypeStorage player = (IPlayerTypeStorage) this;
                    player.setPrimaryType(type[0]);
                    player.setSecondaryType(type[1]);
                    typeAsString = player.getPrimaryType().asString();
                    if (player.getSecondaryType() != BecomemonType.TYPELESS) {
                        typeAsString += " | " + player.getSecondaryType().asString();
                    }
                    mc.player.sendMessage(Text.of(entityType.getUntranslatedName() + ": " + typeAsString));
                }
            }
        }
    }
}
