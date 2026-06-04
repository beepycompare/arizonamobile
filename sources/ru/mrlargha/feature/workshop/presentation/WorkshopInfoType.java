package ru.mrlargha.feature.workshop.presentation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WorkshopResponse.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopInfoType;", "", "<init>", "(Ljava/lang/String;I)V", "INFO", "INFO_LOADING", "COLOR_LIST", "CHANCE_COST", "NONE", "workshop"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WorkshopInfoType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WorkshopInfoType[] $VALUES;
    public static final WorkshopInfoType INFO = new WorkshopInfoType("INFO", 0);
    public static final WorkshopInfoType INFO_LOADING = new WorkshopInfoType("INFO_LOADING", 1);
    public static final WorkshopInfoType COLOR_LIST = new WorkshopInfoType("COLOR_LIST", 2);
    public static final WorkshopInfoType CHANCE_COST = new WorkshopInfoType("CHANCE_COST", 3);
    public static final WorkshopInfoType NONE = new WorkshopInfoType("NONE", 4);

    private static final /* synthetic */ WorkshopInfoType[] $values() {
        return new WorkshopInfoType[]{INFO, INFO_LOADING, COLOR_LIST, CHANCE_COST, NONE};
    }

    public static EnumEntries<WorkshopInfoType> getEntries() {
        return $ENTRIES;
    }

    public static WorkshopInfoType valueOf(String str) {
        return (WorkshopInfoType) Enum.valueOf(WorkshopInfoType.class, str);
    }

    public static WorkshopInfoType[] values() {
        return (WorkshopInfoType[]) $VALUES.clone();
    }

    private WorkshopInfoType(String str, int i) {
    }

    static {
        WorkshopInfoType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
