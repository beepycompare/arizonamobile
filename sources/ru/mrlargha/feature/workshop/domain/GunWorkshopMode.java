package ru.mrlargha.feature.workshop.domain;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: GunWorkshopRules.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/mrlargha/feature/workshop/domain/GunWorkshopMode;", "", "<init>", "(Ljava/lang/String;I)V", "ATTACHMENT", "WEAPON", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class GunWorkshopMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ GunWorkshopMode[] $VALUES;
    public static final GunWorkshopMode ATTACHMENT = new GunWorkshopMode("ATTACHMENT", 0);
    public static final GunWorkshopMode WEAPON = new GunWorkshopMode("WEAPON", 1);

    private static final /* synthetic */ GunWorkshopMode[] $values() {
        return new GunWorkshopMode[]{ATTACHMENT, WEAPON};
    }

    public static EnumEntries<GunWorkshopMode> getEntries() {
        return $ENTRIES;
    }

    public static GunWorkshopMode valueOf(String str) {
        return (GunWorkshopMode) Enum.valueOf(GunWorkshopMode.class, str);
    }

    public static GunWorkshopMode[] values() {
        return (GunWorkshopMode[]) $VALUES.clone();
    }

    private GunWorkshopMode(String str, int i) {
    }

    static {
        GunWorkshopMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
