package androidx.paging;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: FlowExt.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/paging/CombineSource;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL", "RECEIVER", "OTHER", "paging-common"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class CombineSource {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CombineSource[] $VALUES;
    public static final CombineSource INITIAL = new CombineSource("INITIAL", 0);
    public static final CombineSource RECEIVER = new CombineSource("RECEIVER", 1);
    public static final CombineSource OTHER = new CombineSource("OTHER", 2);

    private static final /* synthetic */ CombineSource[] $values() {
        return new CombineSource[]{INITIAL, RECEIVER, OTHER};
    }

    public static EnumEntries<CombineSource> getEntries() {
        return $ENTRIES;
    }

    public static CombineSource valueOf(String str) {
        return (CombineSource) Enum.valueOf(CombineSource.class, str);
    }

    public static CombineSource[] values() {
        return (CombineSource[]) $VALUES.clone();
    }

    private CombineSource(String str, int i) {
    }

    static {
        CombineSource[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
