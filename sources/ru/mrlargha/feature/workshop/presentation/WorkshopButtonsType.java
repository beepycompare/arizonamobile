package ru.mrlargha.feature.workshop.presentation;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: WorkshopResponse.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/feature/workshop/presentation/WorkshopButtonsType;", "", "<init>", "(Ljava/lang/String;I)V", "COST_CREATE", "CREATE", "NONE", "workshop"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class WorkshopButtonsType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ WorkshopButtonsType[] $VALUES;
    public static final WorkshopButtonsType COST_CREATE = new WorkshopButtonsType("COST_CREATE", 0);
    public static final WorkshopButtonsType CREATE = new WorkshopButtonsType("CREATE", 1);
    public static final WorkshopButtonsType NONE = new WorkshopButtonsType("NONE", 2);

    private static final /* synthetic */ WorkshopButtonsType[] $values() {
        return new WorkshopButtonsType[]{COST_CREATE, CREATE, NONE};
    }

    public static EnumEntries<WorkshopButtonsType> getEntries() {
        return $ENTRIES;
    }

    public static WorkshopButtonsType valueOf(String str) {
        return (WorkshopButtonsType) Enum.valueOf(WorkshopButtonsType.class, str);
    }

    public static WorkshopButtonsType[] values() {
        return (WorkshopButtonsType[]) $VALUES.clone();
    }

    private WorkshopButtonsType(String str, int i) {
    }

    static {
        WorkshopButtonsType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
