package kotlinx.datetime;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.LocalDate;
import kotlinx.datetime.format.DateTimeFormat;
/* compiled from: LocalDate.kt */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0000\u001a.\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b\u001a\u0018\u0010\f\u001a\u00020\r*\u00020\u00022\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001\u001a\u001a\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012\u001a\u0015\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0086\u0002\u001a\u0014\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0007\u001a\u0015\u0010\u000e\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0086\u0002\u001a\f\u0010\u0016\u001a\u00020\u0002*\u00020\rH\u0007¨\u0006\u0017"}, d2 = {"getIsoDateFormat", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/LocalDate;", "atTime", "Lkotlinx/datetime/LocalDateTime;", "hour", "", "minute", "second", "nanosecond", "time", "Lkotlinx/datetime/LocalTime;", "format", "", "minus", "value", "", "unit", "Lkotlinx/datetime/DateTimeUnit$DateBased;", TypedValues.CycleType.S_WAVE_PERIOD, "Lkotlinx/datetime/DatePeriod;", "other", "toLocalDate", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocalDateKt {
    public static final String format(LocalDate localDate, DateTimeFormat<LocalDate> format) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return format.format(localDate);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Removed to support more idiomatic code. See https://github.com/Kotlin/kotlinx-datetime/issues/339", replaceWith = @ReplaceWith(expression = "LocalDate.parse(this)", imports = {}))
    public static final LocalDate toLocalDate(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return LocalDate.Companion.parse$default(LocalDate.Companion, str, null, 2, null);
    }

    public static /* synthetic */ LocalDateTime atTime$default(LocalDate localDate, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = 0;
        }
        if ((i5 & 8) != 0) {
            i4 = 0;
        }
        return atTime(localDate, i, i2, i3, i4);
    }

    public static final LocalDateTime atTime(LocalDate localDate, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        return new LocalDateTime(localDate.getYear(), localDate.getMonthNumber(), localDate.getDayOfMonth(), i, i2, i3, i4);
    }

    public static final LocalDateTime atTime(LocalDate localDate, LocalTime time) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(time, "time");
        return new LocalDateTime(localDate, time);
    }

    public static final LocalDate minus(LocalDate localDate, DatePeriod period) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(period, "period");
        if (period.getDays() != Integer.MIN_VALUE && period.getMonths() != Integer.MIN_VALUE) {
            return LocalDateJvmKt.plus(localDate, new DatePeriod(-period.getYears(), -period.getMonths(), -period.getDays()));
        }
        return LocalDateJvmKt.minus(LocalDateJvmKt.minus(LocalDateJvmKt.minus(localDate, period.getYears(), DateTimeUnit.Companion.getYEAR()), period.getMonths(), DateTimeUnit.Companion.getMONTH()), period.getDays(), DateTimeUnit.Companion.getDAY());
    }

    public static final DatePeriod minus(LocalDate localDate, LocalDate other) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return LocalDateJvmKt.periodUntil(other, localDate);
    }

    @Deprecated(message = "Use the minus overload with an explicit number of units", replaceWith = @ReplaceWith(expression = "this.minus(1, unit)", imports = {}))
    public static final LocalDate minus(LocalDate localDate, DateTimeUnit.DateBased unit) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return LocalDateJvmKt.plus(localDate, -1, unit);
    }

    public static final LocalDate minus(LocalDate localDate, long j, DateTimeUnit.DateBased unit) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return LocalDateJvmKt.plus(localDate, -j, unit);
    }

    public static final DateTimeFormat<LocalDate> getIsoDateFormat() {
        return LocalDate.Formats.INSTANCE.getISO();
    }
}
