package ru.mrlargha.commonui.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Constants.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016¨\u0006\u0017"}, d2 = {"Lru/mrlargha/commonui/utils/ArzInventoryButtonTypes;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "BUTTON_INVENTORY", "BUTTON_CAR_INVENTORY", "BUTTON_SECURITY", "BUTTON_HOTEL_ROOM", "BUTTON_TRUNK", "BUTTON_FAM_FLAT", "BUTTON_HOUSE", "BUTTON_TRAILER", "BUTTON_STOREHOUSE", "BUTTON_PAWNSHOP", "BUTTON_TRASH", "BUTTON_CHEST", "BUTTON_CARS", "BUTTON_BIZ", "BUTTON_HOUSES", "CommonUI_release_web"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ArzInventoryButtonTypes {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ArzInventoryButtonTypes[] $VALUES;
    private final int value;
    public static final ArzInventoryButtonTypes BUTTON_INVENTORY = new ArzInventoryButtonTypes("BUTTON_INVENTORY", 0, 1);
    public static final ArzInventoryButtonTypes BUTTON_CAR_INVENTORY = new ArzInventoryButtonTypes("BUTTON_CAR_INVENTORY", 1, 2);
    public static final ArzInventoryButtonTypes BUTTON_SECURITY = new ArzInventoryButtonTypes("BUTTON_SECURITY", 2, 4);
    public static final ArzInventoryButtonTypes BUTTON_HOTEL_ROOM = new ArzInventoryButtonTypes("BUTTON_HOTEL_ROOM", 3, 8);
    public static final ArzInventoryButtonTypes BUTTON_TRUNK = new ArzInventoryButtonTypes("BUTTON_TRUNK", 4, 16);
    public static final ArzInventoryButtonTypes BUTTON_FAM_FLAT = new ArzInventoryButtonTypes("BUTTON_FAM_FLAT", 5, 32);
    public static final ArzInventoryButtonTypes BUTTON_HOUSE = new ArzInventoryButtonTypes("BUTTON_HOUSE", 6, 64);
    public static final ArzInventoryButtonTypes BUTTON_TRAILER = new ArzInventoryButtonTypes("BUTTON_TRAILER", 7, 128);
    public static final ArzInventoryButtonTypes BUTTON_STOREHOUSE = new ArzInventoryButtonTypes("BUTTON_STOREHOUSE", 8, 256);
    public static final ArzInventoryButtonTypes BUTTON_PAWNSHOP = new ArzInventoryButtonTypes("BUTTON_PAWNSHOP", 9, 512);
    public static final ArzInventoryButtonTypes BUTTON_TRASH = new ArzInventoryButtonTypes("BUTTON_TRASH", 10, 1024);
    public static final ArzInventoryButtonTypes BUTTON_CHEST = new ArzInventoryButtonTypes("BUTTON_CHEST", 11, 2048);
    public static final ArzInventoryButtonTypes BUTTON_CARS = new ArzInventoryButtonTypes("BUTTON_CARS", 12, 4096);
    public static final ArzInventoryButtonTypes BUTTON_BIZ = new ArzInventoryButtonTypes("BUTTON_BIZ", 13, 8192);
    public static final ArzInventoryButtonTypes BUTTON_HOUSES = new ArzInventoryButtonTypes("BUTTON_HOUSES", 14, 16384);

    private static final /* synthetic */ ArzInventoryButtonTypes[] $values() {
        return new ArzInventoryButtonTypes[]{BUTTON_INVENTORY, BUTTON_CAR_INVENTORY, BUTTON_SECURITY, BUTTON_HOTEL_ROOM, BUTTON_TRUNK, BUTTON_FAM_FLAT, BUTTON_HOUSE, BUTTON_TRAILER, BUTTON_STOREHOUSE, BUTTON_PAWNSHOP, BUTTON_TRASH, BUTTON_CHEST, BUTTON_CARS, BUTTON_BIZ, BUTTON_HOUSES};
    }

    public static EnumEntries<ArzInventoryButtonTypes> getEntries() {
        return $ENTRIES;
    }

    private ArzInventoryButtonTypes(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        ArzInventoryButtonTypes[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static ArzInventoryButtonTypes valueOf(String str) {
        return (ArzInventoryButtonTypes) Enum.valueOf(ArzInventoryButtonTypes.class, str);
    }

    public static ArzInventoryButtonTypes[] values() {
        return (ArzInventoryButtonTypes[]) $VALUES.clone();
    }
}
