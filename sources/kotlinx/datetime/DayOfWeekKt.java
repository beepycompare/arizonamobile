package kotlinx.datetime;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
@Metadata(d1 = {"kotlinx/datetime/DayOfWeekKt__DayOfWeekJvmKt", "kotlinx/datetime/DayOfWeekKt__DayOfWeekKt"}, k = 4, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DayOfWeekKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is only kept for binary compatibility")
    public static final /* synthetic */ java.time.DayOfWeek DayOfWeek(int i) {
        java.time.DayOfWeek javaDayOfWeek;
        javaDayOfWeek = ConvertersKt.toJavaDayOfWeek(m10081DayOfWeek(i));
        return javaDayOfWeek;
    }

    /* renamed from: DayOfWeek  reason: collision with other method in class */
    public static final DayOfWeek m10081DayOfWeek(int i) {
        return DayOfWeekKt__DayOfWeekKt.DayOfWeek(i);
    }

    public static final int getIsoDayNumber(java.time.DayOfWeek dayOfWeek) {
        return DayOfWeekKt__DayOfWeekJvmKt.getIsoDayNumber(dayOfWeek);
    }

    public static final int getIsoDayNumber(DayOfWeek dayOfWeek) {
        return DayOfWeekKt__DayOfWeekKt.getIsoDayNumber(dayOfWeek);
    }
}
