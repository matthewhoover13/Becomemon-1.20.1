package hoover.becomemon.command;

import com.google.common.collect.ImmutableList;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import hoover.becomemon.util.BecomemonType;
import hoover.becomemon.util.IEntityDataSaver;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import java.util.Collection;
import java.util.function.Supplier;

public class PrintTypeCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        dispatcher.register(CommandManager.literal("type")
                .then(CommandManager.literal("print")
                        .executes(context -> PrintTypeCommand.run((ServerCommandSource)context.getSource(), ImmutableList.of(((ServerCommandSource)context.getSource()).getEntityOrThrow())))
                        .then(CommandManager.argument("targets", EntityArgumentType.entities())
                                .executes(context -> PrintTypeCommand.run((ServerCommandSource)context.getSource(), EntityArgumentType.getEntities(context, "targets"))))));
    }

    private static int run(ServerCommandSource source, Collection<? extends Entity> targets) throws CommandSyntaxException {
        for (Entity target : targets) {
            if (target.isLiving()) {
                IEntityDataSaver targetAsDataSaver = (IEntityDataSaver) target;
                String primaryType = targetAsDataSaver.getPersistentData().getString("primaryType");
                String secondaryType = targetAsDataSaver.getPersistentData().getString("secondaryType");

                if (primaryType.length() > 0) {
                    if (secondaryType.length() > 0 && !secondaryType.equals(BecomemonType.TYPELESS.getName())) {
                        source.sendFeedback((Supplier<Text>) Text.of("Type of " + target.getName().getString() + " is " + primaryType + "/" + secondaryType), true);
                    } else {
                        source.sendFeedback((Supplier<Text>) Text.of("Type of " + target.getName().getString() + " is " + primaryType), true);
                    }
                } else {
                    source.sendFeedback((Supplier<Text>) Text.of("No type has been set for " + target.getName().getString()), true);
                }
            }
        }
        return 0;
    }
}
