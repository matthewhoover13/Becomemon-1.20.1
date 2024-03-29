package hoover.becomemon.mixin;

import hoover.becomemon.util.BecomemonType;
import hoover.becomemon.util.IPlayerTypeStorage;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(PlayerEntity.class)
public class ModPlayerEntityTypeStorage implements IPlayerTypeStorage {
    private BecomemonType primaryType;
    private BecomemonType secondaryType;
    private DefaultedList<ItemStack> typeInventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
    private static final int PRIMARY_SLOT = 0;
    private static final int SECONDARY_SLOT = 1;

    @Override
    public BecomemonType getPrimaryType() {
        return primaryType;
    }

    @Override
    public void setPrimaryType(BecomemonType primaryType) {
        this.primaryType = primaryType;
    }

    @Override
    public BecomemonType getSecondaryType() {
        return secondaryType;
    }

    @Override
    public void setSecondaryType(BecomemonType secondaryType) {
        this.secondaryType = secondaryType;
    }

    @Override
    public BecomemonType getType(int index) {
        return index == 1 ? secondaryType : primaryType;
    }

    @Override
    public void setType(int index, BecomemonType type) {
        if (index == 1) {
            secondaryType = type;
        } else {
            primaryType = type;
        }
    }

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
