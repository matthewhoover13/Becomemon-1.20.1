package hoover.becomemon.item;

import hoover.becomemon.Becomemon;
import hoover.becomemon.item.custom.*;
import hoover.becomemon.util.BecomemonCategory;
import hoover.becomemon.util.BecomemonType;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item TEST_ITEM = registerItem("test_item", new Item(new FabricItemSettings()));
    public static final Item BUNGER = registerItem("bunger", new Item(new FabricItemSettings()));
    public static final Item TEST_ADVANCED_ITEM = registerItem("test_advanced_item", new TestAdvancedItem(new FabricItemSettings().maxDamage(64)));
    public static final Item WILL_O_WISP = registerItem("will_o_wisp", new WillOWisp(new FabricItemSettings(), BecomemonType.FIRE, 0, 85, BecomemonCategory.STATUS));
    public static final Item TELEPORT = registerItem("teleport", new Teleport(new FabricItemSettings(), BecomemonType.PSYCHIC, 0, 100, BecomemonCategory.STATUS));
    public static final Item RECOVER = registerItem("recover", new Recover(new FabricItemSettings(), BecomemonType.NORMAL, 0, 100, BecomemonCategory.STATUS));
    public static final Item THUNDER_WAVE = registerItem("thunder_wave", new ThunderWave(new FabricItemSettings(), BecomemonType.ELECTRIC, 0, 90, BecomemonCategory.STATUS));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Becomemon.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Becomemon.LOGGER.info("Registering items for " + Becomemon.MOD_ID);
    }
}
