package ru.mrlargha.commonui.elements.inventory.domain;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: InventoryId.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lru/mrlargha/commonui/elements/inventory/domain/InventoryId;", "", "subId", "", "<init>", "(Ljava/lang/String;II)V", "getSubId", "()I", "GET_ITEMS", "GET_USER_INFO", "GET_EDIT_INFO", "SHOW_DIALOG", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InventoryId {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ InventoryId[] $VALUES;
    private final int subId;
    public static final InventoryId GET_ITEMS = new InventoryId("GET_ITEMS", 0, 0);
    public static final InventoryId GET_USER_INFO = new InventoryId("GET_USER_INFO", 1, 1);
    public static final InventoryId GET_EDIT_INFO = new InventoryId("GET_EDIT_INFO", 2, 2);
    public static final InventoryId SHOW_DIALOG = new InventoryId("SHOW_DIALOG", 3, 3);

    private static final /* synthetic */ InventoryId[] $values() {
        return new InventoryId[]{GET_ITEMS, GET_USER_INFO, GET_EDIT_INFO, SHOW_DIALOG};
    }

    public static EnumEntries<InventoryId> getEntries() {
        return $ENTRIES;
    }

    public static InventoryId valueOf(String str) {
        return (InventoryId) Enum.valueOf(InventoryId.class, str);
    }

    public static InventoryId[] values() {
        return (InventoryId[]) $VALUES.clone();
    }

    private InventoryId(String str, int i, int i2) {
        this.subId = i2;
    }

    public final int getSubId() {
        return this.subId;
    }

    static {
        InventoryId[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
