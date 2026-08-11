package ru.mrlargha.feature.workshop.domain;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: GunWorkshopRules.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/feature/workshop/domain/GunWorkshopSlotRole;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN", "SHARPENING", "RESOURCE", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class GunWorkshopSlotRole {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GunWorkshopSlotRole[] $VALUES;
    public static final GunWorkshopSlotRole MAIN = new GunWorkshopSlotRole("MAIN", 0);
    public static final GunWorkshopSlotRole SHARPENING = new GunWorkshopSlotRole("SHARPENING", 1);
    public static final GunWorkshopSlotRole RESOURCE = new GunWorkshopSlotRole("RESOURCE", 2);

    private static final /* synthetic */ GunWorkshopSlotRole[] $values() {
        return new GunWorkshopSlotRole[]{MAIN, SHARPENING, RESOURCE};
    }

    public static EnumEntries<GunWorkshopSlotRole> getEntries() {
        return $ENTRIES;
    }

    public static GunWorkshopSlotRole valueOf(String str) {
        return (GunWorkshopSlotRole) Enum.valueOf(GunWorkshopSlotRole.class, str);
    }

    public static GunWorkshopSlotRole[] values() {
        return (GunWorkshopSlotRole[]) $VALUES.clone();
    }

    private GunWorkshopSlotRole(String str, int i) {
    }

    static {
        GunWorkshopSlotRole[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
