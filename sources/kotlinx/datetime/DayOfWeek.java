package kotlinx.datetime;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DayOfWeek.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lkotlinx/datetime/DayOfWeek;", "", "<init>", "(Ljava/lang/String;I)V", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DayOfWeek {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DayOfWeek[] $VALUES;
    public static final DayOfWeek MONDAY = new DayOfWeek("MONDAY", 0);
    public static final DayOfWeek TUESDAY = new DayOfWeek("TUESDAY", 1);
    public static final DayOfWeek WEDNESDAY = new DayOfWeek("WEDNESDAY", 2);
    public static final DayOfWeek THURSDAY = new DayOfWeek("THURSDAY", 3);
    public static final DayOfWeek FRIDAY = new DayOfWeek("FRIDAY", 4);
    public static final DayOfWeek SATURDAY = new DayOfWeek("SATURDAY", 5);
    public static final DayOfWeek SUNDAY = new DayOfWeek("SUNDAY", 6);

    private static final /* synthetic */ DayOfWeek[] $values() {
        return new DayOfWeek[]{MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};
    }

    public static EnumEntries<DayOfWeek> getEntries() {
        return $ENTRIES;
    }

    private DayOfWeek(String str, int i) {
    }

    static {
        DayOfWeek[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static DayOfWeek valueOf(String str) {
        return (DayOfWeek) Enum.valueOf(DayOfWeek.class, str);
    }

    public static DayOfWeek[] values() {
        return (DayOfWeek[]) $VALUES.clone();
    }
}
