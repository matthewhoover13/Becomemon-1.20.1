package hoover.becomemon.command;

import com.google.common.collect.ImmutableList;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import hoover.becomemon.util.BecomemonType;
import hoover.becomemon.util.IEntityTypeStorage;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import java.util.Collection;

// TO DO: Change "print" to "get" or something like that
// TO DO: Allow for checking the types of a certain mob (not just generic selectors)

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
                IEntityTypeStorage entity = (IEntityTypeStorage) target;
                String primaryTypeStr = entity.getPrimaryType().asString();
                String secondaryTypeStr = entity.getSecondaryType().asString();

                if (primaryTypeStr.length() > 0) {
                    if (secondaryTypeStr.length() > 0 && !secondaryTypeStr.equals(BecomemonType.TYPELESS.getName())) {
                        source.sendMessage(Text.of("Type of " + target.getName().getString() + " is " + primaryTypeStr + "/" + secondaryTypeStr));
                    } else {
                        source.sendMessage(Text.of("Type of " + target.getName().getString() + " is " + primaryTypeStr));
                    }
                } else {
                    source.sendMessage(Text.of("No type has been set for " + target.getName().getString()));
                }
            }
        }
        return 0;
    }
}
