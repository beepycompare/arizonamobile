package kotlinx.datetime.format;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DateTimeFormat.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lkotlinx/datetime/format/Padding;", "", "<init>", "(Ljava/lang/String;I)V", "NONE", "ZERO", "SPACE", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Padding {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Padding[] $VALUES;
    public static final Padding NONE = new Padding("NONE", 0);
    public static final Padding ZERO = new Padding("ZERO", 1);
    public static final Padding SPACE = new Padding("SPACE", 2);

    private static final /* synthetic */ Padding[] $values() {
        return new Padding[]{NONE, ZERO, SPACE};
    }

    public static EnumEntries<Padding> getEntries() {
        return $ENTRIES;
    }

    private Padding(String str, int i) {
    }

    static {
        Padding[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static Padding valueOf(String str) {
        return (Padding) Enum.valueOf(Padding.class, str);
    }

    public static Padding[] values() {
        return (Padding[]) $VALUES.clone();
    }
}
