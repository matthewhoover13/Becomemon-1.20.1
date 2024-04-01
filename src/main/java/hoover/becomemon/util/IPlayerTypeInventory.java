package hoover.becomemon.util;

import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

public interface IPlayerTypeInventory {
    DefaultedList<ItemStack> getTypeInventory();
    void setTypeInventory(DefaultedList<ItemStack> typeInventory);
    void setTypeInventoryByIndex(int index, ItemStack itemStack);
}
