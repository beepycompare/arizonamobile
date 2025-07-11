package kotlinx.datetime;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
@Metadata(d1 = {"kotlinx/datetime/MonthKt__MonthJvmKt", "kotlinx/datetime/MonthKt__MonthKt"}, k = 4, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MonthKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This overload is only kept for binary compatibility")
    public static final /* synthetic */ java.time.Month Month(int i) {
        java.time.Month javaMonth;
        javaMonth = ConvertersKt.toJavaMonth(m10091Month(i));
        return javaMonth;
    }

    /* renamed from: Month  reason: collision with other method in class */
    public static final Month m10091Month(int i) {
        return MonthKt__MonthKt.Month(i);
    }

    public static final int getNumber(java.time.Month month) {
        return MonthKt__MonthJvmKt.getNumber(month);
    }

    public static final int getNumber(Month month) {
        return MonthKt__MonthKt.getNumber(month);
    }
}
