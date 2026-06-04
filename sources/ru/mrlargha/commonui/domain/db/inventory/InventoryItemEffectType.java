package ru.mrlargha.commonui.domain.db.inventory;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ru.mrlargha.commonui.R;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: InventoryItemEntity.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lru/mrlargha/commonui/domain/db/inventory/InventoryItemEffectType;", "", "effectName", "", "resId", "", "effectType", "Lru/mrlargha/commonui/domain/db/inventory/InventoryEffectType;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Integer;Lru/mrlargha/commonui/domain/db/inventory/InventoryEffectType;)V", "getEffectName", "()Ljava/lang/String;", "getResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEffectType", "()Lru/mrlargha/commonui/domain/db/inventory/InventoryEffectType;", "NONE", "DRUID", "BERSERK", "FIRE", "WHITE_FIRE", "BLUE_FIRE", "GREEN_FIRE", "BEAR", "FRIEREN", "LICH", "WITCH", "ZOOTOPIA", "CommonUI"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InventoryItemEffectType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InventoryItemEffectType[] $VALUES;
    private final String effectName;
    private final InventoryEffectType effectType;
    private final Integer resId;
    public static final InventoryItemEffectType NONE = new InventoryItemEffectType("NONE", 0, "", null, InventoryEffectType.BACKGROUND);
    public static final InventoryItemEffectType DRUID = new InventoryItemEffectType("DRUID", 1, "druid", Integer.valueOf(R.drawable.inventory_item_effect_druid), null, 4, null);
    public static final InventoryItemEffectType BERSERK = new InventoryItemEffectType("BERSERK", 2, "berserk", Integer.valueOf(R.drawable.inventory_item_effect_berserk), null, 4, null);
    public static final InventoryItemEffectType FIRE = new InventoryItemEffectType("FIRE", 3, "fire", Integer.valueOf(R.drawable.inventory_item_effect_fire), InventoryEffectType.BACKGROUND);
    public static final InventoryItemEffectType WHITE_FIRE = new InventoryItemEffectType("WHITE_FIRE", 4, "white-fire", Integer.valueOf(R.drawable.inventory_item_effect_white_fire), InventoryEffectType.BACKGROUND);
    public static final InventoryItemEffectType BLUE_FIRE = new InventoryItemEffectType("BLUE_FIRE", 5, "blue-fire", Integer.valueOf(R.drawable.inventory_item_effect_blue_fire), InventoryEffectType.BACKGROUND);
    public static final InventoryItemEffectType GREEN_FIRE = new InventoryItemEffectType("GREEN_FIRE", 6, "green-fire", Integer.valueOf(R.drawable.inventory_item_effect_green_fire), InventoryEffectType.BACKGROUND);
    public static final InventoryItemEffectType BEAR = new InventoryItemEffectType("BEAR", 7, "bearEffect", Integer.valueOf(R.drawable.inventory_item_effec_bear), InventoryEffectType.BACKGROUND_TOP);
    public static final InventoryItemEffectType FRIEREN = new InventoryItemEffectType("FRIEREN", 8, "frierenEffect", Integer.valueOf(R.drawable.inventory_item_effec_frieren), InventoryEffectType.BACKGROUND_TOP);
    public static final InventoryItemEffectType LICH = new InventoryItemEffectType("LICH", 9, "lichEffect", Integer.valueOf(R.drawable.inventory_item_effec_lich), null, 4, null);
    public static final InventoryItemEffectType WITCH = new InventoryItemEffectType("WITCH", 10, "witchEffect", Integer.valueOf(R.drawable.inventory_item_effec_witch), null, 4, null);
    public static final InventoryItemEffectType ZOOTOPIA = new InventoryItemEffectType("ZOOTOPIA", 11, "zootopiaEffect", Integer.valueOf(R.drawable.inventory_item_effec_zootopia), InventoryEffectType.BACKGROUND_TOP);

    private static final /* synthetic */ InventoryItemEffectType[] $values() {
        return new InventoryItemEffectType[]{NONE, DRUID, BERSERK, FIRE, WHITE_FIRE, BLUE_FIRE, GREEN_FIRE, BEAR, FRIEREN, LICH, WITCH, ZOOTOPIA};
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

    private InventoryItemEffectType(String str, int i, String str2, Integer num, InventoryEffectType inventoryEffectType) {
        this.effectName = str2;
        this.resId = num;
        this.effectType = inventoryEffectType;
    }

    /* synthetic */ InventoryItemEffectType(String str, int i, String str2, Integer num, InventoryEffectType inventoryEffectType, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, str2, num, (i2 & 4) != 0 ? InventoryEffectType.FOREGROUND : inventoryEffectType);
    }

    public final String getEffectName() {
        return this.effectName;
    }

    public final InventoryEffectType getEffectType() {
        return this.effectType;
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
