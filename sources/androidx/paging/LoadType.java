package androidx.paging;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: LoadType.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/paging/LoadType;", "", "<init>", "(Ljava/lang/String;I)V", "REFRESH", "PREPEND", "APPEND", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LoadType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LoadType[] $VALUES;
    public static final LoadType REFRESH = new LoadType("REFRESH", 0);
    public static final LoadType PREPEND = new LoadType("PREPEND", 1);
    public static final LoadType APPEND = new LoadType("APPEND", 2);

    private static final /* synthetic */ LoadType[] $values() {
        return new LoadType[]{REFRESH, PREPEND, APPEND};
    }

    public static EnumEntries<LoadType> getEntries() {
        return $ENTRIES;
    }

    public static LoadType valueOf(String str) {
        return (LoadType) Enum.valueOf(LoadType.class, str);
    }

    public static LoadType[] values() {
        return (LoadType[]) $VALUES.clone();
    }

    private LoadType(String str, int i) {
    }

    static {
        LoadType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
