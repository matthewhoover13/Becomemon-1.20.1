package hoover.becomemon;

import hoover.becomemon.event.KeyInputHandler;
import net.fabricmc.api.ClientModInitializer;

public class BecomemonClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandler.register();
    }
}
