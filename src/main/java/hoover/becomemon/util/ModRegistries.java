package hoover.becomemon.util;

import hoover.becomemon.command.PrintTypeCommand;
import hoover.becomemon.command.SetTypeCommand;
import hoover.becomemon.event.ModPlayerEventCopyFrom;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;

public class ModRegistries {
    public static void registerModStuff() {
        registerCommands();
        registerEvents();
    }

    private static void registerCommands() {
        //CommandRegistrationCallback.EVENT.register(SetTypeCommand::register);
        CommandRegistrationCallback.EVENT.register(PrintTypeCommand::register);
    }

    private static void registerEvents() {
        ServerPlayerEvents.COPY_FROM.register(new ModPlayerEventCopyFrom());
    }
}
