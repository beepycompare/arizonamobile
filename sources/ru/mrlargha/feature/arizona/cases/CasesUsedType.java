package ru.mrlargha.feature.arizona.cases;

import coil3.network.internal.UtilsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: CasesResponse.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lru/mrlargha/feature/arizona/cases/CasesUsedType;", "", "<init>", "(Ljava/lang/String;I)V", UtilsKt.HTTP_METHOD_GET, "SCHISM", "cases_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class CasesUsedType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CasesUsedType[] $VALUES;
    public static final CasesUsedType GET = new CasesUsedType(UtilsKt.HTTP_METHOD_GET, 0);
    public static final CasesUsedType SCHISM = new CasesUsedType("SCHISM", 1);

    private static final /* synthetic */ CasesUsedType[] $values() {
        return new CasesUsedType[]{GET, SCHISM};
    }

    public static EnumEntries<CasesUsedType> getEntries() {
        return $ENTRIES;
    }

    public static CasesUsedType valueOf(String str) {
        return (CasesUsedType) Enum.valueOf(CasesUsedType.class, str);
    }

    public static CasesUsedType[] values() {
        return (CasesUsedType[]) $VALUES.clone();
    }

    private CasesUsedType(String str, int i) {
    }

    static {
        CasesUsedType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
