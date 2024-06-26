package hoover.becomemon;

import hoover.becomemon.effect.ModEffects;
import hoover.becomemon.item.ModItemGroups;
import hoover.becomemon.item.ModItems;
import hoover.becomemon.util.ModRegistries;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Becomemon implements ModInitializer {
    public static final String MOD_ID = "becomemon";
    public static final Logger LOGGER = LoggerFactory.getLogger("becomemon");

    @Override
    public void onInitialize() {
        ModRegistries.registerModStuff();
        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModEffects.registerEffects();
    }
}