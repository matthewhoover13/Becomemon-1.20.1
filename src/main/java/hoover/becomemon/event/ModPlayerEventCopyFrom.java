package hoover.becomemon.event;

import hoover.becomemon.util.IEntityDataSaver;
import net.fabricmc.fabric.api.entity.event.v1.ServerPlayerEvents;
import net.minecraft.server.network.ServerPlayerEntity;

public class ModPlayerEventCopyFrom implements ServerPlayerEvents.CopyFrom {
    @Override
    public void copyFromPlayer(ServerPlayerEntity oldPlayer, ServerPlayerEntity newPlayer, boolean alive) {
        IEntityDataSaver original = ((IEntityDataSaver)oldPlayer);
        IEntityDataSaver player = ((IEntityDataSaver)newPlayer);

        player.getPersistentData().putString("type", original.getPersistentData().getString("type"));
    }
}
