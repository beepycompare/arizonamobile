package ru.mrlargha.commonui.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Constants.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0019\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lru/mrlargha/commonui/utils/ActionTypes;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "INVENTORY_BUTTON_TYPE_USE", "INVENTORY_BUTTON_TYPE_PUT_ON", "INVENTORY_BUTTON_TYPE_DROP", "INVENTORY_BUTTON_TYPE_SPLIT", "INVENTORY_BUTTON_TYPE_INFO", "INVENTORY_BUTTON_TYPE_CLOSE", "INVENTORY_BUTTON_TYPE_ITEM_OPEN", "INVENTORY_BUTTON_TYPE_ITEM_CLOSE", "INVENTORY_A_BUTTON_TYPE_TAKE_ON", "INVENTORY_A_BUTTON_TYPE_CLEAR", "INVENTORY_A_BUTTON_TYPE_INSTALL", "INVENTORY_A_BUTTON_TYPE_EDIT", "INVENTORY_A_BUTTON_TYPE_OPEN", "INVENTORY_A_BUTTON_TYPE_RENT", "INVENTORY_A_BUTTON_TYPE_COLOR", "INVENTORY_BUTTON_TYPE_PUT", "INVENTORY_BUTTON_TYPE_TAKE", "INVENTORY_BUTTON_TYPE_SELL", "INVENTORY_BUTTON_TYPE_PUT_IN_GIFT", "INVENT_BUTTON_TYPE_SEND", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActionTypes {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ActionTypes[] $VALUES;
    private final int value;
    public static final ActionTypes INVENTORY_BUTTON_TYPE_USE = new ActionTypes("INVENTORY_BUTTON_TYPE_USE", 0, 1);
    public static final ActionTypes INVENTORY_BUTTON_TYPE_PUT_ON = new ActionTypes("INVENTORY_BUTTON_TYPE_PUT_ON", 1, 2);
    public static final ActionTypes INVENTORY_BUTTON_TYPE_DROP = new ActionTypes("INVENTORY_BUTTON_TYPE_DROP", 2, 4);
    public static final ActionTypes INVENTORY_BUTTON_TYPE_SPLIT = new ActionTypes("INVENTORY_BUTTON_TYPE_SPLIT", 3, 8);
    public static final ActionTypes INVENTORY_BUTTON_TYPE_INFO = new ActionTypes("INVENTORY_BUTTON_TYPE_INFO", 4, 16);
    public static final ActionTypes INVENTORY_BUTTON_TYPE_CLOSE = new ActionTypes("INVENTORY_BUTTON_TYPE_CLOSE", 5, 32);
    public static final ActionTypes INVENTORY_BUTTON_TYPE_ITEM_OPEN = new ActionTypes("INVENTORY_BUTTON_TYPE_ITEM_OPEN", 6, 64);
    public static final ActionTypes INVENTORY_BUTTON_TYPE_ITEM_CLOSE = new ActionTypes("INVENTORY_BUTTON_TYPE_ITEM_CLOSE", 7, 128);
    public static final ActionTypes INVENTORY_A_BUTTON_TYPE_TAKE_ON = new ActionTypes("INVENTORY_A_BUTTON_TYPE_TAKE_ON", 8, 256);
    public static final ActionTypes INVENTORY_A_BUTTON_TYPE_CLEAR = new ActionTypes("INVENTORY_A_BUTTON_TYPE_CLEAR", 9, 512);
    public static final ActionTypes INVENTORY_A_BUTTON_TYPE_INSTALL = new ActionTypes("INVENTORY_A_BUTTON_TYPE_INSTALL", 10, 1024);
    public static final ActionTypes INVENTORY_A_BUTTON_TYPE_EDIT = new ActionTypes("INVENTORY_A_BUTTON_TYPE_EDIT", 11, 2048);
    public static final ActionTypes INVENTORY_A_BUTTON_TYPE_OPEN = new ActionTypes("INVENTORY_A_BUTTON_TYPE_OPEN", 12, 4096);
    public static final ActionTypes INVENTORY_A_BUTTON_TYPE_RENT = new ActionTypes("INVENTORY_A_BUTTON_TYPE_RENT", 13, 8192);
    public static final ActionTypes INVENTORY_A_BUTTON_TYPE_COLOR = new ActionTypes("INVENTORY_A_BUTTON_TYPE_COLOR", 14, 16384);
    public static final ActionTypes INVENTORY_BUTTON_TYPE_PUT = new ActionTypes("INVENTORY_BUTTON_TYPE_PUT", 15, 32768);
    public static final ActionTypes INVENTORY_BUTTON_TYPE_TAKE = new ActionTypes("INVENTORY_BUTTON_TYPE_TAKE", 16, 65536);
    public static final ActionTypes INVENTORY_BUTTON_TYPE_SELL = new ActionTypes("INVENTORY_BUTTON_TYPE_SELL", 17, 131072);
    public static final ActionTypes INVENTORY_BUTTON_TYPE_PUT_IN_GIFT = new ActionTypes("INVENTORY_BUTTON_TYPE_PUT_IN_GIFT", 18, 262144);
    public static final ActionTypes INVENT_BUTTON_TYPE_SEND = new ActionTypes("INVENT_BUTTON_TYPE_SEND", 19, 524288);

    private static final /* synthetic */ ActionTypes[] $values() {
        return new ActionTypes[]{INVENTORY_BUTTON_TYPE_USE, INVENTORY_BUTTON_TYPE_PUT_ON, INVENTORY_BUTTON_TYPE_DROP, INVENTORY_BUTTON_TYPE_SPLIT, INVENTORY_BUTTON_TYPE_INFO, INVENTORY_BUTTON_TYPE_CLOSE, INVENTORY_BUTTON_TYPE_ITEM_OPEN, INVENTORY_BUTTON_TYPE_ITEM_CLOSE, INVENTORY_A_BUTTON_TYPE_TAKE_ON, INVENTORY_A_BUTTON_TYPE_CLEAR, INVENTORY_A_BUTTON_TYPE_INSTALL, INVENTORY_A_BUTTON_TYPE_EDIT, INVENTORY_A_BUTTON_TYPE_OPEN, INVENTORY_A_BUTTON_TYPE_RENT, INVENTORY_A_BUTTON_TYPE_COLOR, INVENTORY_BUTTON_TYPE_PUT, INVENTORY_BUTTON_TYPE_TAKE, INVENTORY_BUTTON_TYPE_SELL, INVENTORY_BUTTON_TYPE_PUT_IN_GIFT, INVENT_BUTTON_TYPE_SEND};
    }

    public static EnumEntries<ActionTypes> getEntries() {
        return $ENTRIES;
    }

    public static ActionTypes valueOf(String str) {
        return (ActionTypes) Enum.valueOf(ActionTypes.class, str);
    }

    public static ActionTypes[] values() {
        return (ActionTypes[]) $VALUES.clone();
    }

    private ActionTypes(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        ActionTypes[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
