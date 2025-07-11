package kotlinx.datetime;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.time.DateTimeException;
import java.time.temporal.ChronoUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.internal.MathKt;
/* compiled from: LocalDate.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0007\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0001\u001a\u001c\u0010\u000b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0001\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\n\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t\u001a\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\fH\u0002\u001a\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0013H\u0086\u0002\u001a\u0012\u0010\u0014\u001a\u00020\u0013*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u001a\u0010\u0016\u001a\u00020\f*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t\u001a!\u0010\u0017\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0001¢\u0006\u0002\b\u0016\u001a\u0012\u0010\u0018\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u0012\u0010\u0019\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001\u001a\u0012\u0010\u001a\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0001\"\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"LocalDate", "Lkotlinx/datetime/LocalDate;", "year", "", "month", "Ljava/time/Month;", "dayOfMonth", "plus", "unit", "Lkotlinx/datetime/DateTimeUnit$DateBased;", "value", "minus", "", "minEpochDay", "maxEpochDay", "ofEpochDayChecked", "Ljava/time/LocalDate;", "epochDay", TypedValues.CycleType.S_WAVE_PERIOD, "Lkotlinx/datetime/DatePeriod;", "periodUntil", "other", "until", "untilJvm", "daysUntil", "monthsUntil", "yearsUntil", "kotlinx-datetime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocalDateJvmKt {
    private static final long minEpochDay = java.time.LocalDate.MIN.toEpochDay();
    private static final long maxEpochDay = java.time.LocalDate.MAX.toEpochDay();

    @Deprecated(level = DeprecationLevel.WARNING, message = "Use the constructor that accepts a 'day'", replaceWith = @ReplaceWith(expression = "LocalDate(year = year, month = month.toKotlinMonth(), day = dayOfMonth)", imports = {}))
    public static final LocalDate LocalDate(int i, java.time.Month month, int i2) {
        Intrinsics.checkNotNullParameter(month, "month");
        return new LocalDate(i, ConvertersKt.toKotlinMonth(month), i2);
    }

    @Deprecated(message = "Use the plus overload with an explicit number of units", replaceWith = @ReplaceWith(expression = "this.plus(1, unit)", imports = {}))
    public static final LocalDate plus(LocalDate localDate, DateTimeUnit.DateBased unit) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return plus(localDate, 1L, unit);
    }

    public static final LocalDate plus(LocalDate localDate, int i, DateTimeUnit.DateBased unit) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return plus(localDate, i, unit);
    }

    public static final LocalDate minus(LocalDate localDate, int i, DateTimeUnit.DateBased unit) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return plus(localDate, -i, unit);
    }

    public static final LocalDate plus(LocalDate localDate, long j, DateTimeUnit.DateBased unit) {
        java.time.LocalDate plusMonths;
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        try {
            if (unit instanceof DateTimeUnit.DayBased) {
                plusMonths = ofEpochDayChecked(MathJvmKt.safeAdd(localDate.getValue$kotlinx_datetime().toEpochDay(), MathJvmKt.safeMultiply(j, ((DateTimeUnit.DayBased) unit).getDays())));
            } else if (!(unit instanceof DateTimeUnit.MonthBased)) {
                throw new NoWhenBranchMatchedException();
            } else {
                plusMonths = localDate.getValue$kotlinx_datetime().plusMonths(MathJvmKt.safeMultiply(j, ((DateTimeUnit.MonthBased) unit).getMonths()));
            }
            return new LocalDate(plusMonths);
        } catch (Exception e) {
            if ((e instanceof DateTimeException) || (e instanceof ArithmeticException)) {
                throw new DateTimeArithmeticException("The result of adding " + j + " of " + unit + " to " + localDate + " is out of LocalDate range.", e);
            }
            throw e;
        }
    }

    private static final java.time.LocalDate ofEpochDayChecked(long j) {
        long j2 = minEpochDay;
        if (j > maxEpochDay || j2 > j) {
            throw new DateTimeException("The resulting day " + j + " is out of supported LocalDate range.");
        }
        java.time.LocalDate ofEpochDay = java.time.LocalDate.ofEpochDay(j);
        Intrinsics.checkNotNullExpressionValue(ofEpochDay, "ofEpochDay(...)");
        return ofEpochDay;
    }

    public static final LocalDate plus(LocalDate localDate, DatePeriod period) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(period, "period");
        try {
            java.time.LocalDate value$kotlinx_datetime = localDate.getValue$kotlinx_datetime();
            if (period.getTotalMonths$kotlinx_datetime() != 0) {
                value$kotlinx_datetime = value$kotlinx_datetime.plusMonths(period.getTotalMonths$kotlinx_datetime());
            }
            if (period.getDays() != 0) {
                value$kotlinx_datetime = value$kotlinx_datetime.plusDays(period.getDays());
            }
            return new LocalDate(value$kotlinx_datetime);
        } catch (DateTimeException unused) {
            throw new DateTimeArithmeticException("The result of adding " + localDate.getValue$kotlinx_datetime() + " to " + localDate + " is out of LocalDate range.");
        }
    }

    public static final DatePeriod periodUntil(LocalDate localDate, LocalDate other) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        java.time.LocalDate value$kotlinx_datetime = localDate.getValue$kotlinx_datetime();
        java.time.LocalDate value$kotlinx_datetime2 = other.getValue$kotlinx_datetime();
        long until = value$kotlinx_datetime.until(value$kotlinx_datetime2, ChronoUnit.MONTHS);
        java.time.LocalDate plusMonths = value$kotlinx_datetime.plusMonths(until);
        Intrinsics.checkNotNullExpressionValue(plusMonths, "plusMonths(...)");
        return new DatePeriod(until, (int) plusMonths.until(value$kotlinx_datetime2, ChronoUnit.DAYS));
    }

    /* renamed from: until  reason: collision with other method in class */
    public static final long m10088until(LocalDate localDate, LocalDate other, DateTimeUnit.DateBased unit) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit instanceof DateTimeUnit.MonthBased) {
            return localDate.getValue$kotlinx_datetime().until(other.getValue$kotlinx_datetime(), ChronoUnit.MONTHS) / ((DateTimeUnit.MonthBased) unit).getMonths();
        }
        if (unit instanceof DateTimeUnit.DayBased) {
            return localDate.getValue$kotlinx_datetime().until(other.getValue$kotlinx_datetime(), ChronoUnit.DAYS) / ((DateTimeUnit.DayBased) unit).getDays();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int until(LocalDate localDate, LocalDate other, DateTimeUnit.DateBased unit) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return MathKt.clampToInt(m10088until(localDate, other, unit));
    }

    public static final int daysUntil(LocalDate localDate, LocalDate other) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return MathKt.clampToInt(localDate.getValue$kotlinx_datetime().until(other.getValue$kotlinx_datetime(), ChronoUnit.DAYS));
    }

    public static final int monthsUntil(LocalDate localDate, LocalDate other) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return MathKt.clampToInt(localDate.getValue$kotlinx_datetime().until(other.getValue$kotlinx_datetime(), ChronoUnit.MONTHS));
    }

    public static final int yearsUntil(LocalDate localDate, LocalDate other) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return (int) localDate.getValue$kotlinx_datetime().until(other.getValue$kotlinx_datetime(), ChronoUnit.YEARS);
    }
}
