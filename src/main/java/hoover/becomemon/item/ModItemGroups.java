package hoover.becomemon.item;

import hoover.becomemon.Becomemon;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BECOMEMON_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Becomemon.MOD_ID, "becomemon"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.becomemon"))
                    .icon(() -> new ItemStack(ModItems.TEST_ITEM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.TEST_ITEM);
                        entries.add(ModItems.BUNGER);
                        entries.add(ModItems.TEST_ADVANCED_ITEM);
                    }).build());

    public static void registerItemGroups() {
        Becomemon.LOGGER.info("Registering item groups for " + Becomemon.MOD_ID);
    }
}
