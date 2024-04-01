package hoover.becomemon.mixin;

import hoover.becomemon.util.BecomemonType;
import hoover.becomemon.util.IEntityTypeStorage;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(LivingEntity.class)
public class ModLivingEntityTypeStorage implements IEntityTypeStorage {
    private BecomemonType primaryType;
    private BecomemonType secondaryType;

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
}
