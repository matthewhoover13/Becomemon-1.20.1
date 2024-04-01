package hoover.becomemon.util;

public interface IEntityTypeStorage {
    BecomemonType getPrimaryType();
    void setPrimaryType(BecomemonType primaryType);
    BecomemonType getSecondaryType();
    void setSecondaryType(BecomemonType secondaryType);
}
