package kotlinx.datetime;

import java.time.Month;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.LocalTime;
import kotlinx.datetime.format.DateTimeFormat;
/* compiled from: LocalTime.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a$\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006\u001a(\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\t\u001a\u00060\nj\u0002`\u000b2\b\b\u0002\u0010\b\u001a\u00020\u0006\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\r\u001a\u0018\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\f\u0010\u0010\u001a\u00020\u0002*\u00020\u000fH\u0007¨\u0006\u0011"}, d2 = {"getIsoTimeFormat", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalTime;", "atDate", "Lkotlinx/datetime/LocalDateTime;", "year", "", "monthNumber", "dayOfMonth", "month", "Ljava/time/Month;", "Lkotlinx/datetime/Month;", "date", "Lkotlinx/datetime/LocalDate;", "format", "", "toLocalTime", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocalTimeKt {
    public static final String format(LocalTime localTime, DateTimeFormat<LocalTime> format) {
        Intrinsics.checkNotNullParameter(localTime, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return format.format(localTime);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Removed to support more idiomatic code. See https://github.com/Kotlin/kotlinx-datetime/issues/339", replaceWith = @ReplaceWith(expression = "LocalTime.parse(this)", imports = {}))
    public static final LocalTime toLocalTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return LocalTime.Companion.parse$default(LocalTime.Companion, str, null, 2, null);
    }

    public static /* synthetic */ LocalDateTime atDate$default(LocalTime localTime, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        return atDate(localTime, i, i2, i3);
    }

    public static final LocalDateTime atDate(LocalTime localTime, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(localTime, "<this>");
        return new LocalDateTime(i, i2, i3, localTime.getHour(), localTime.getMinute(), localTime.getSecond(), localTime.getNanosecond());
    }

    public static /* synthetic */ LocalDateTime atDate$default(LocalTime localTime, int i, Month month, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return atDate(localTime, i, month, i2);
    }

    public static final LocalDateTime atDate(LocalTime localTime, int i, Month month, int i2) {
        Intrinsics.checkNotNullParameter(localTime, "<this>");
        Intrinsics.checkNotNullParameter(month, "month");
        return new LocalDateTime(i, month, i2, localTime.getHour(), localTime.getMinute(), localTime.getSecond(), localTime.getNanosecond());
    }

    public static final LocalDateTime atDate(LocalTime localTime, LocalDate date) {
        Intrinsics.checkNotNullParameter(localTime, "<this>");
        Intrinsics.checkNotNullParameter(date, "date");
        return new LocalDateTime(date, localTime);
    }

    public static final DateTimeFormat<LocalTime> getIsoTimeFormat() {
        return LocalTime.Formats.INSTANCE.getISO();
    }
}
