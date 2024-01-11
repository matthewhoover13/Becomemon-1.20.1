package hoover.becomemon.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class TutorialScreen extends Screen {
    private final Screen parent;

    public TutorialScreen(Screen parent) {
        // The parameter is the title of the screen, which will be narrated when you enter the screen
        super(Text.literal("My tutorial screen"));
        this.parent = parent;
    }

    public ButtonWidget button1;
    public ButtonWidget button2;

    @Override
    protected void init() {
        button1 = ButtonWidget.builder(Text.literal("Button 1"), button -> {
            client.player.sendMessage(Text.of("You clicked button1!"));
        })
                .dimensions(width / 2 - 205, 20, 200, 20)
                .tooltip(Tooltip.of(Text.literal("Tooltip of button1")))
                .build();
        button2 = ButtonWidget.builder(Text.literal("Button 2"), button -> {
            client.player.sendMessage(Text.of("You clicked button2!"));
        })
                .dimensions(width / 2 + 5, 20, 200, 20)
                .tooltip(Tooltip.of(Text.literal("Tooltip of button2")))
                .build();
        addDrawableChild(button1);
        addDrawableChild(button2);
        addDrawableChild(ButtonWidget.builder(Text.literal("Button 3"), button -> {
            client.player.sendMessage(Text.of("You clicked button3!"));
        }).build());
    }

    @Override
    public void close() {
        client.setScreen(parent);
    }
}
