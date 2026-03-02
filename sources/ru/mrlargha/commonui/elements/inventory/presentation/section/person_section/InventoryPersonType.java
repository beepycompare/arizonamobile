package ru.mrlargha.commonui.elements.inventory.presentation.section.person_section;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: InventoryPersonSection.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/presentation/section/person_section/InventoryPersonType;", "", "<init>", "(Ljava/lang/String;I)V", "ACCESSORIES", "UPGRADES", "WALLET", "NONE", "CommonUI"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InventoryPersonType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InventoryPersonType[] $VALUES;
    public static final InventoryPersonType ACCESSORIES = new InventoryPersonType("ACCESSORIES", 0);
    public static final InventoryPersonType UPGRADES = new InventoryPersonType("UPGRADES", 1);
    public static final InventoryPersonType WALLET = new InventoryPersonType("WALLET", 2);
    public static final InventoryPersonType NONE = new InventoryPersonType("NONE", 3);

    private static final /* synthetic */ InventoryPersonType[] $values() {
        return new InventoryPersonType[]{ACCESSORIES, UPGRADES, WALLET, NONE};
    }

    public static EnumEntries<InventoryPersonType> getEntries() {
        return $ENTRIES;
    }

    public static InventoryPersonType valueOf(String str) {
        return (InventoryPersonType) Enum.valueOf(InventoryPersonType.class, str);
    }

    public static InventoryPersonType[] values() {
        return (InventoryPersonType[]) $VALUES.clone();
    }

    private InventoryPersonType(String str, int i) {
    }

    static {
        InventoryPersonType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
