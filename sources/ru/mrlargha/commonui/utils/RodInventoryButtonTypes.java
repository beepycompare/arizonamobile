package ru.mrlargha.commonui.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Constants.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0017\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lru/mrlargha/commonui/utils/RodInventoryButtonTypes;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "BUTTON_INVENTORY", "BUTTON_CAR_INVENTORY", "BUTTON_SECURITY", "BUTTON_TRASH", "BUTTON_TRUNK", "BUTTON_HOUSE", "BUTTON_DRAWER", "BUTTON_SHIP", "BUTTON_CAMPER", "BUTTON_BANK_VAULT", "BUTTON_FRACTION_WAREHOUSE", "BUTTON_FAMILY_WAREHOUSE", "BUTTON_GARDENING_BARN", "BUTTON_GARAGE", "BUTTON_CARS", "BUTTON_BIZ", "BUTTON_HOUSES", "BUTTON_TRAILER", "CommonUI_release_web"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RodInventoryButtonTypes {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RodInventoryButtonTypes[] $VALUES;
    private final int value;
    public static final RodInventoryButtonTypes BUTTON_INVENTORY = new RodInventoryButtonTypes("BUTTON_INVENTORY", 0, 1);
    public static final RodInventoryButtonTypes BUTTON_CAR_INVENTORY = new RodInventoryButtonTypes("BUTTON_CAR_INVENTORY", 1, 2);
    public static final RodInventoryButtonTypes BUTTON_SECURITY = new RodInventoryButtonTypes("BUTTON_SECURITY", 2, 4);
    public static final RodInventoryButtonTypes BUTTON_TRASH = new RodInventoryButtonTypes("BUTTON_TRASH", 3, 8);
    public static final RodInventoryButtonTypes BUTTON_TRUNK = new RodInventoryButtonTypes("BUTTON_TRUNK", 4, 16);
    public static final RodInventoryButtonTypes BUTTON_HOUSE = new RodInventoryButtonTypes("BUTTON_HOUSE", 5, 32);
    public static final RodInventoryButtonTypes BUTTON_DRAWER = new RodInventoryButtonTypes("BUTTON_DRAWER", 6, 64);
    public static final RodInventoryButtonTypes BUTTON_SHIP = new RodInventoryButtonTypes("BUTTON_SHIP", 7, 128);
    public static final RodInventoryButtonTypes BUTTON_CAMPER = new RodInventoryButtonTypes("BUTTON_CAMPER", 8, 256);
    public static final RodInventoryButtonTypes BUTTON_BANK_VAULT = new RodInventoryButtonTypes("BUTTON_BANK_VAULT", 9, 512);
    public static final RodInventoryButtonTypes BUTTON_FRACTION_WAREHOUSE = new RodInventoryButtonTypes("BUTTON_FRACTION_WAREHOUSE", 10, 1024);
    public static final RodInventoryButtonTypes BUTTON_FAMILY_WAREHOUSE = new RodInventoryButtonTypes("BUTTON_FAMILY_WAREHOUSE", 11, 2048);
    public static final RodInventoryButtonTypes BUTTON_GARDENING_BARN = new RodInventoryButtonTypes("BUTTON_GARDENING_BARN", 12, 4096);
    public static final RodInventoryButtonTypes BUTTON_GARAGE = new RodInventoryButtonTypes("BUTTON_GARAGE", 13, 8192);
    public static final RodInventoryButtonTypes BUTTON_CARS = new RodInventoryButtonTypes("BUTTON_CARS", 14, 16384);
    public static final RodInventoryButtonTypes BUTTON_BIZ = new RodInventoryButtonTypes("BUTTON_BIZ", 15, 32768);
    public static final RodInventoryButtonTypes BUTTON_HOUSES = new RodInventoryButtonTypes("BUTTON_HOUSES", 16, 65536);
    public static final RodInventoryButtonTypes BUTTON_TRAILER = new RodInventoryButtonTypes("BUTTON_TRAILER", 17, 131072);

    private static final /* synthetic */ RodInventoryButtonTypes[] $values() {
        return new RodInventoryButtonTypes[]{BUTTON_INVENTORY, BUTTON_CAR_INVENTORY, BUTTON_SECURITY, BUTTON_TRASH, BUTTON_TRUNK, BUTTON_HOUSE, BUTTON_DRAWER, BUTTON_SHIP, BUTTON_CAMPER, BUTTON_BANK_VAULT, BUTTON_FRACTION_WAREHOUSE, BUTTON_FAMILY_WAREHOUSE, BUTTON_GARDENING_BARN, BUTTON_GARAGE, BUTTON_CARS, BUTTON_BIZ, BUTTON_HOUSES, BUTTON_TRAILER};
    }

    public static EnumEntries<RodInventoryButtonTypes> getEntries() {
        return $ENTRIES;
    }

    public static RodInventoryButtonTypes valueOf(String str) {
        return (RodInventoryButtonTypes) Enum.valueOf(RodInventoryButtonTypes.class, str);
    }

    public static RodInventoryButtonTypes[] values() {
        return (RodInventoryButtonTypes[]) $VALUES.clone();
    }

    private RodInventoryButtonTypes(String str, int i, int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        RodInventoryButtonTypes[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
