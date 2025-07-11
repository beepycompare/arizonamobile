package kotlinx.datetime;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DayOfWeekJvm.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0000\u001a\u00020\u0001H\u0007\"\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"isoDayNumber", "", "Ljava/time/DayOfWeek;", "getIsoDayNumber$annotations", "(Ljava/time/DayOfWeek;)V", "getIsoDayNumber", "(Ljava/time/DayOfWeek;)I", "DayOfWeek", "kotlinx-datetime"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "kotlinx/datetime/DayOfWeekKt")
/* loaded from: classes5.dex */
final /* synthetic */ class DayOfWeekKt__DayOfWeekJvmKt {
    @Deprecated(message = "Use kotlinx.datetime.DayOfWeek", replaceWith = @ReplaceWith(expression = "toKotlinDayOfWeek().isoDayNumber", imports = {}))
    public static /* synthetic */ void getIsoDayNumber$annotations(java.time.DayOfWeek dayOfWeek) {
    }

    public static final int getIsoDayNumber(java.time.DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "<this>");
        return DayOfWeekKt.getIsoDayNumber(ConvertersKt.toKotlinDayOfWeek(dayOfWeek));
    }
}
