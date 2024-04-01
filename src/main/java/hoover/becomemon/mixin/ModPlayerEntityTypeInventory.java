package hoover.becomemon.mixin;

import hoover.becomemon.util.IPlayerTypeInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlayerEntity.class)
public class ModPlayerEntityTypeInventory implements IPlayerTypeInventory {
    private DefaultedList<ItemStack> typeInventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
    private static final int PRIMARY_SLOT = 0;
    private static final int SECONDARY_SLOT = 1;

    @Override
    public DefaultedList<ItemStack> getTypeInventory() {
        return typeInventory;
    }

    @Override
    public void setTypeInventory(DefaultedList<ItemStack> typeInventory) {
        this.typeInventory = typeInventory;
    }

    @Override
    public void setTypeInventoryByIndex(int index, ItemStack itemStack) {
        if (index < typeInventory.size()) {
            typeInventory.set(index, itemStack);
        }
    }
}
