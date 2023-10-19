package hoover.becomemon.command;

import com.google.common.collect.ImmutableList;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
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

public class SetTypeCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandRegistryAccess commandRegistryAccess, CommandManager.RegistrationEnvironment registrationEnvironment) {
        LiteralArgumentBuilder<ServerCommandSource> literalArgumentBuilder = CommandManager.literal("type");
        for (BecomemonType type : BecomemonType.values()) {
            literalArgumentBuilder.then(CommandManager.literal("set")
                    .requires(serverCommandSource -> serverCommandSource.hasPermissionLevel(2))
                    .then((ArgumentBuilder<ServerCommandSource, ?>)CommandManager.literal(type.getName())
                            .executes(context -> SetTypeCommand.run((ServerCommandSource)context.getSource(), ImmutableList.of(((ServerCommandSource)context.getSource()).getEntityOrThrow()), type))
                            .then(CommandManager.argument("targets", EntityArgumentType.entities())
                                    .executes(context -> SetTypeCommand.run((ServerCommandSource)context.getSource(), EntityArgumentType.getEntities(context, "targets"), type)))));
        }
        dispatcher.register(literalArgumentBuilder);
    }

    public static int run(ServerCommandSource source, Collection<? extends Entity> targets, BecomemonType type) throws CommandSyntaxException {
        for (Entity target : targets) {
            IEntityDataSaver targetAsDataSaver = (IEntityDataSaver)target;

            targetAsDataSaver.getPersistentData().putString("primaryType", type.getName());

            source.sendMessage(Text.of("Set type of " + target.getName().getString() + " to " + type.getName()));
        }
        return 0;
    }
}
