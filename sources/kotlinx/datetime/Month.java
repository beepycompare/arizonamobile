package kotlinx.datetime;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: Month.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lkotlinx/datetime/Month;", "", "<init>", "(Ljava/lang/String;I)V", "JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER", "kotlinx-datetime"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Month {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Month[] $VALUES;
    public static final Month JANUARY = new Month("JANUARY", 0);
    public static final Month FEBRUARY = new Month("FEBRUARY", 1);
    public static final Month MARCH = new Month("MARCH", 2);
    public static final Month APRIL = new Month("APRIL", 3);
    public static final Month MAY = new Month("MAY", 4);
    public static final Month JUNE = new Month("JUNE", 5);
    public static final Month JULY = new Month("JULY", 6);
    public static final Month AUGUST = new Month("AUGUST", 7);
    public static final Month SEPTEMBER = new Month("SEPTEMBER", 8);
    public static final Month OCTOBER = new Month("OCTOBER", 9);
    public static final Month NOVEMBER = new Month("NOVEMBER", 10);
    public static final Month DECEMBER = new Month("DECEMBER", 11);

    private static final /* synthetic */ Month[] $values() {
        return new Month[]{JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER};
    }

    public static EnumEntries<Month> getEntries() {
        return $ENTRIES;
    }

    private Month(String str, int i) {
    }

    static {
        Month[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    public static Month valueOf(String str) {
        return (Month) Enum.valueOf(Month.class, str);
    }

    public static Month[] values() {
        return (Month[]) $VALUES.clone();
    }
}
