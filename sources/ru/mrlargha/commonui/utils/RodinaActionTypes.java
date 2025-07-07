package ru.mrlargha.commonui.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Constants.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/utils/RodinaActionTypes;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "INVENTORY_BUTTON_TYPE_USE", "INVENTORY_BUTTON_TYPE_PUT", "INVENTORY_BUTTON_TYPE_DROP", "INVENTORY_BUTTON_TYPE_SPLIT", "INVENTORY_BUTTON_TYPE_INFO", "INVENTORY_BUTTON_TYPE_CLOSE", "INVENTORY_BUTTON_TYPE_ITEM_OPEN", "INVENTORY_BUTTON_TYPE_ITEM_C", "INVENTORY_A_BUTTON_TYPE_USE", "INVENTORY_A_BUTTON_TYPE_TAKE", "INVENTORY_A_BUTTON_TYPE_CLEAR", "INVENTORY_A_BUTTON_TYPE_INSTALL", "INVENTORY_A_BUTTON_TYPE_EDIT", "INVENTORY_A_BUTTON_TYPE_INFO", "INVENTORY_A_BUTTON_TYPE_CLOSE", "INVENTORY_A_BUTTON_TYPE_OPEN", "INVENTORY_A_BUTTON_TYPE_RENT", "INVENTORY_A_BUTTON_TYPE_COLOR", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RodinaActionTypes {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RodinaActionTypes[] $VALUES;
    private final int value;
    public static final RodinaActionTypes INVENTORY_BUTTON_TYPE_USE = new RodinaActionTypes("INVENTORY_BUTTON_TYPE_USE", 0, 1);
    public static final RodinaActionTypes INVENTORY_BUTTON_TYPE_PUT = new RodinaActionTypes("INVENTORY_BUTTON_TYPE_PUT", 1, 2);
    public static final RodinaActionTypes INVENTORY_BUTTON_TYPE_DROP = new RodinaActionTypes("INVENTORY_BUTTON_TYPE_DROP", 2, 4);
    public static final RodinaActionTypes INVENTORY_BUTTON_TYPE_SPLIT = new RodinaActionTypes("INVENTORY_BUTTON_TYPE_SPLIT", 3, 8);
    public static final RodinaActionTypes INVENTORY_BUTTON_TYPE_INFO = new RodinaActionTypes("INVENTORY_BUTTON_TYPE_INFO", 4, 16);
    public static final RodinaActionTypes INVENTORY_BUTTON_TYPE_CLOSE = new RodinaActionTypes("INVENTORY_BUTTON_TYPE_CLOSE", 5, 32);
    public static final RodinaActionTypes INVENTORY_BUTTON_TYPE_ITEM_OPEN = new RodinaActionTypes("INVENTORY_BUTTON_TYPE_ITEM_OPEN", 6, 64);
    public static final RodinaActionTypes INVENTORY_BUTTON_TYPE_ITEM_C = new RodinaActionTypes("INVENTORY_BUTTON_TYPE_ITEM_C", 7, 128);
    public static final RodinaActionTypes INVENTORY_A_BUTTON_TYPE_USE = new RodinaActionTypes("INVENTORY_A_BUTTON_TYPE_USE", 8, 256);
    public static final RodinaActionTypes INVENTORY_A_BUTTON_TYPE_TAKE = new RodinaActionTypes("INVENTORY_A_BUTTON_TYPE_TAKE", 9, 512);
    public static final RodinaActionTypes INVENTORY_A_BUTTON_TYPE_CLEAR = new RodinaActionTypes("INVENTORY_A_BUTTON_TYPE_CLEAR", 10, 1024);
    public static final RodinaActionTypes INVENTORY_A_BUTTON_TYPE_INSTALL = new RodinaActionTypes("INVENTORY_A_BUTTON_TYPE_INSTALL", 11, 2048);
    public static final RodinaActionTypes INVENTORY_A_BUTTON_TYPE_EDIT = new RodinaActionTypes("INVENTORY_A_BUTTON_TYPE_EDIT", 12, 4096);
    public static final RodinaActionTypes INVENTORY_A_BUTTON_TYPE_INFO = new RodinaActionTypes("INVENTORY_A_BUTTON_TYPE_INFO", 13, 8192);
    public static final RodinaActionTypes INVENTORY_A_BUTTON_TYPE_CLOSE = new RodinaActionTypes("INVENTORY_A_BUTTON_TYPE_CLOSE", 14, 16384);
    public static final RodinaActionTypes INVENTORY_A_BUTTON_TYPE_OPEN = new RodinaActionTypes("INVENTORY_A_BUTTON_TYPE_OPEN", 15, 32768);
    public static final RodinaActionTypes INVENTORY_A_BUTTON_TYPE_RENT = new RodinaActionTypes("INVENTORY_A_BUTTON_TYPE_RENT", 16, 65536);
    public static final RodinaActionTypes INVENTORY_A_BUTTON_TYPE_COLOR = new RodinaActionTypes("INVENTORY_A_BUTTON_TYPE_COLOR", 17, 131072);

    private static final /* synthetic */ RodinaActionTypes[] $values() {
        return new RodinaActionTypes[]{INVENTORY_BUTTON_TYPE_USE, INVENTORY_BUTTON_TYPE_PUT, INVENTORY_BUTTON_TYPE_DROP, INVENTORY_BUTTON_TYPE_SPLIT, INVENTORY_BUTTON_TYPE_INFO, INVENTORY_BUTTON_TYPE_CLOSE, INVENTORY_BUTTON_TYPE_ITEM_OPEN, INVENTORY_BUTTON_TYPE_ITEM_C, INVENTORY_A_BUTTON_TYPE_USE, INVENTORY_A_BUTTON_TYPE_TAKE, INVENTORY_A_BUTTON_TYPE_CLEAR, INVENTORY_A_BUTTON_TYPE_INSTALL, INVENTORY_A_BUTTON_TYPE_EDIT, INVENTORY_A_BUTTON_TYPE_INFO, INVENTORY_A_BUTTON_TYPE_CLOSE, INVENTORY_A_BUTTON_TYPE_OPEN, INVENTORY_A_BUTTON_TYPE_RENT, INVENTORY_A_BUTTON_TYPE_COLOR};
    }

    public static EnumEntries<RodinaActionTypes> getEntries() {
        return $ENTRIES;
    }

    private RodinaActionTypes(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        RodinaActionTypes[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static RodinaActionTypes valueOf(String str) {
        return (RodinaActionTypes) Enum.valueOf(RodinaActionTypes.class, str);
    }

    public static RodinaActionTypes[] values() {
        return (RodinaActionTypes[]) $VALUES.clone();
    }
}
