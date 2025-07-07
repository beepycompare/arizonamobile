package kotlinx.metadata;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Visitors.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/metadata/KmVersionRequirementVersionKind;", "", "(Ljava/lang/String;I)V", "LANGUAGE_VERSION", "COMPILER_VERSION", "API_VERSION", "UNKNOWN", "kotlinx-metadata"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KmVersionRequirementVersionKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ KmVersionRequirementVersionKind[] $VALUES;
    public static final KmVersionRequirementVersionKind LANGUAGE_VERSION = new KmVersionRequirementVersionKind("LANGUAGE_VERSION", 0);
    public static final KmVersionRequirementVersionKind COMPILER_VERSION = new KmVersionRequirementVersionKind("COMPILER_VERSION", 1);
    public static final KmVersionRequirementVersionKind API_VERSION = new KmVersionRequirementVersionKind("API_VERSION", 2);
    public static final KmVersionRequirementVersionKind UNKNOWN = new KmVersionRequirementVersionKind("UNKNOWN", 3);

    private static final /* synthetic */ KmVersionRequirementVersionKind[] $values() {
        return new KmVersionRequirementVersionKind[]{LANGUAGE_VERSION, COMPILER_VERSION, API_VERSION, UNKNOWN};
    }

    public static EnumEntries<KmVersionRequirementVersionKind> getEntries() {
        return $ENTRIES;
    }

    public static KmVersionRequirementVersionKind valueOf(String str) {
        return (KmVersionRequirementVersionKind) Enum.valueOf(KmVersionRequirementVersionKind.class, str);
    }

    public static KmVersionRequirementVersionKind[] values() {
        return (KmVersionRequirementVersionKind[]) $VALUES.clone();
    }

    private KmVersionRequirementVersionKind(String str, int i) {
    }

    static {
        KmVersionRequirementVersionKind[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }
}
