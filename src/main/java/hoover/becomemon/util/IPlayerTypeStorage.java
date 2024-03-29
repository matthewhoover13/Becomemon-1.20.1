package hoover.becomemon.util;

import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public interface IPlayerTypeStorage {
    BecomemonType getPrimaryType();
    void setPrimaryType(BecomemonType primaryType);
    BecomemonType getSecondaryType();
    void setSecondaryType(BecomemonType secondaryType);
    BecomemonType getType(int index);
    void setType(int index, BecomemonType type);
    DefaultedList<ItemStack> getTypeInventory();
    void setTypeInventory(DefaultedList<ItemStack> typeInventory);
    void setTypeInventoryByIndex(int index, ItemStack itemStack);
}
