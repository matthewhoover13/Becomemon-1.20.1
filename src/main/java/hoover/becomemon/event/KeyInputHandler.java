package hoover.becomemon.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandler {
    public static final String KEY_CATEGORY_BECOMEMON = "key.category.becomemon";
    public static final String KEY_TEST = "key.becomemon.test";

    public static KeyBinding testKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
           if (testKey.wasPressed()) {
               // This happens when our custom key is pressed
               client.player.sendMessage(Text.literal("Test"));
           }
        });
    }

    public static void register() {
        testKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                KEY_TEST,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                KEY_CATEGORY_BECOMEMON
        ));

        registerKeyInputs();
    }
}
