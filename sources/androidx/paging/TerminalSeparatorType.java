package androidx.paging;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Separators.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/paging/TerminalSeparatorType;", "", "<init>", "(Ljava/lang/String;I)V", "FULLY_COMPLETE", "SOURCE_COMPLETE", "paging-common"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TerminalSeparatorType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TerminalSeparatorType[] $VALUES;
    public static final TerminalSeparatorType FULLY_COMPLETE = new TerminalSeparatorType("FULLY_COMPLETE", 0);
    public static final TerminalSeparatorType SOURCE_COMPLETE = new TerminalSeparatorType("SOURCE_COMPLETE", 1);

    private static final /* synthetic */ TerminalSeparatorType[] $values() {
        return new TerminalSeparatorType[]{FULLY_COMPLETE, SOURCE_COMPLETE};
    }

    public static EnumEntries<TerminalSeparatorType> getEntries() {
        return $ENTRIES;
    }

    public static TerminalSeparatorType valueOf(String str) {
        return (TerminalSeparatorType) Enum.valueOf(TerminalSeparatorType.class, str);
    }

    public static TerminalSeparatorType[] values() {
        return (TerminalSeparatorType[]) $VALUES.clone();
    }

    private TerminalSeparatorType(String str, int i) {
    }

    static {
        TerminalSeparatorType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
