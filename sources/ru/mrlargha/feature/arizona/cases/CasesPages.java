package ru.mrlargha.feature.arizona.cases;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CasesResponse.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lru/mrlargha/feature/arizona/cases/CasesPages;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN", "OPEN", "LOADING", "cases"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesPages {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CasesPages[] $VALUES;
    public static final CasesPages MAIN = new CasesPages("MAIN", 0);
    public static final CasesPages OPEN = new CasesPages("OPEN", 1);
    public static final CasesPages LOADING = new CasesPages("LOADING", 2);

    private static final /* synthetic */ CasesPages[] $values() {
        return new CasesPages[]{MAIN, OPEN, LOADING};
    }

    public static EnumEntries<CasesPages> getEntries() {
        return $ENTRIES;
    }

    public static CasesPages valueOf(String str) {
        return (CasesPages) Enum.valueOf(CasesPages.class, str);
    }

    public static CasesPages[] values() {
        return (CasesPages[]) $VALUES.clone();
    }

    private CasesPages(String str, int i) {
    }

    static {
        CasesPages[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
