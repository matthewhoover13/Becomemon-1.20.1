package hoover.becomemon.item.custom;

import hoover.becomemon.util.BecomemonCategory;
import hoover.becomemon.util.BecomemonType;
import net.minecraft.item.Item;

public class MoveItem extends Item {
    protected BecomemonType type;
    protected float power;
    protected float accuracy;
    protected BecomemonCategory category;

    public MoveItem(Settings settings) {
        super(settings);
        this.type = BecomemonType.TYPELESS;
        this.power = 0;
        this.accuracy = 100;
        this.category = BecomemonCategory.NONE;
    }

    public MoveItem(Settings settings, BecomemonType type, float power, float accuracy, BecomemonCategory category) {
        super(settings);
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
        this.category = category;
    }
}
