package hoover.becomemon.item;

import hoover.becomemon.Becomemon;
import hoover.becomemon.item.custom.TestAdvancedItem;
import hoover.becomemon.item.custom.WillOWisp;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item TEST_ITEM = registerItem("test_item", new Item(new FabricItemSettings()));
    public static final Item BUNGER = registerItem("bunger", new Item(new FabricItemSettings()));
    public static final Item TEST_ADVANCED_ITEM = registerItem("test_advanced_item", new TestAdvancedItem(new FabricItemSettings().maxDamage(64)));
    public static final Item WILL_O_WISP = registerItem("will_o_wisp", new WillOWisp(new FabricItemSettings()));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(TEST_ITEM);
        entries.add(BUNGER);
        entries.add(TEST_ADVANCED_ITEM);
        entries.add(WILL_O_WISP);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Becomemon.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Becomemon.LOGGER.info("Registering items for " + Becomemon.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);
    }
}