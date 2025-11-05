package ru.mrlargha.commonui.domain.db.inventory;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import ru.mrlargha.commonui.R;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: InventoryItemEntity.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEffectType;", "", "effectName", "", "resId", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;)V", "getEffectName", "()Ljava/lang/String;", "getResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "NONE", "DRUID", "BERSERK", "FIRE", "WHITE_FIRE", "CommonUI_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InventoryItemEffectType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InventoryItemEffectType[] $VALUES;
    private final String effectName;
    private final Integer resId;
    public static final InventoryItemEffectType NONE = new InventoryItemEffectType("NONE", 0, "", null);
    public static final InventoryItemEffectType DRUID = new InventoryItemEffectType("DRUID", 1, "druid", Integer.valueOf(R.drawable.inventory_item_effect_druid));
    public static final InventoryItemEffectType BERSERK = new InventoryItemEffectType("BERSERK", 2, "berserk", Integer.valueOf(R.drawable.inventory_item_effect_berserk));
    public static final InventoryItemEffectType FIRE = new InventoryItemEffectType("FIRE", 3, "fire", Integer.valueOf(R.drawable.inventory_item_effect_fire));
    public static final InventoryItemEffectType WHITE_FIRE = new InventoryItemEffectType("WHITE_FIRE", 4, "white-fire", Integer.valueOf(R.drawable.inventory_item_effect_white_fire));

    private static final /* synthetic */ InventoryItemEffectType[] $values() {
        return new InventoryItemEffectType[]{NONE, DRUID, BERSERK, FIRE, WHITE_FIRE};
    }

    public static EnumEntries<InventoryItemEffectType> getEntries() {
        return $ENTRIES;
    }

    public static InventoryItemEffectType valueOf(String str) {
        return (InventoryItemEffectType) Enum.valueOf(InventoryItemEffectType.class, str);
    }

    public static InventoryItemEffectType[] values() {
        return (InventoryItemEffectType[]) $VALUES.clone();
    }

    private InventoryItemEffectType(String str, int i, String str2, Integer num) {
        this.effectName = str2;
        this.resId = num;
    }

    public final String getEffectName() {
        return this.effectName;
    }

    public final Integer getResId() {
        return this.resId;
    }

    static {
        InventoryItemEffectType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
