package kotlinx.datetime;

import java.time.DayOfWeek;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DayOfWeek.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0006\u001a\u00060\u0002j\u0002`\u00032\u0006\u0010\u0000\u001a\u00020\u0001\"\u0019\u0010\u0000\u001a\u00020\u0001*\u00060\u0002j\u0002`\u00038F¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"isoDayNumber", "", "Ljava/time/DayOfWeek;", "Lkotlinx/datetime/DayOfWeek;", "getIsoDayNumber", "(Ljava/time/DayOfWeek;)I", "DayOfWeek", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DayOfWeekKt {

    /* compiled from: DayOfWeek.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public /* synthetic */ class EntriesMappings {
        public static final /* synthetic */ EnumEntries<DayOfWeek> entries$0 = EnumEntriesKt.enumEntries(DayOfWeek.values());
    }

    public static final int getIsoDayNumber(DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "<this>");
        return dayOfWeek.ordinal() + 1;
    }

    public static final DayOfWeek DayOfWeek(int i) {
        if (1 > i || i >= 8) {
            throw new IllegalArgumentException(("Expected ISO day-of-week number in 1..7, got " + i).toString());
        }
        return (DayOfWeek) EntriesMappings.entries$0.get(i - 1);
    }
}
