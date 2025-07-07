package kotlinx.datetime;

import androidx.collection.SieveCacheKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.time.DateTimeException;
import java.time.temporal.ChronoUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.internal.MathKt;
/* compiled from: LocalDate.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002\u001a\u0012\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\b\u001a\u001a\u0010\n\u001a\u00020\b*\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u000e\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\b\u001a\u0012\u0010\u000f\u001a\u00020\u0010*\u00020\b2\u0006\u0010\t\u001a\u00020\b\u001a\u001a\u0010\u0011\u001a\u00020\b*\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r\u001a\u001a\u0010\u0011\u001a\u00020\b*\u00020\b2\u0006\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r\u001a\u0015\u0010\u0011\u001a\u00020\b*\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0010H\u0086\u0002\u001a\u0014\u0010\u0011\u001a\u00020\b*\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007\u001a\u001a\u0010\u0013\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u0014\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\b\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"maxEpochDay", "", "minEpochDay", "ofEpochDayChecked", "Ljava/time/LocalDate;", "epochDay", "daysUntil", "", "Lkotlinx/datetime/LocalDate;", "other", "minus", "value", "unit", "Lkotlinx/datetime/DateTimeUnit$DateBased;", "monthsUntil", "periodUntil", "Lkotlinx/datetime/DatePeriod;", "plus", TypedValues.CycleType.S_WAVE_PERIOD, "until", "yearsUntil", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LocalDateJvmKt {
    private static final long minEpochDay = java.time.LocalDate.MIN.toEpochDay();
    private static final long maxEpochDay = java.time.LocalDate.MAX.toEpochDay();

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
            } else if (unit instanceof DateTimeUnit.MonthBased) {
                plusMonths = localDate.getValue$kotlinx_datetime().plusMonths(MathJvmKt.safeMultiply(j, ((DateTimeUnit.MonthBased) unit).getMonths()));
            } else {
                throw new NoWhenBranchMatchedException();
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
        long until2 = plusMonths.until(value$kotlinx_datetime2, ChronoUnit.DAYS);
        if (until > SieveCacheKt.NodeLinkMask || until < SieveCacheKt.NodeMetaAndPreviousMask) {
            throw new DateTimeArithmeticException("The number of months between " + localDate + " and " + other + " does not fit in an Int");
        }
        return new DatePeriod((int) until, (int) until2);
    }

    public static final int until(LocalDate localDate, LocalDate other, DateTimeUnit.DateBased unit) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (unit instanceof DateTimeUnit.MonthBased) {
            return MathKt.clampToInt(localDate.getValue$kotlinx_datetime().until(other.getValue$kotlinx_datetime(), ChronoUnit.MONTHS) / ((DateTimeUnit.MonthBased) unit).getMonths());
        }
        if (unit instanceof DateTimeUnit.DayBased) {
            return MathKt.clampToInt(localDate.getValue$kotlinx_datetime().until(other.getValue$kotlinx_datetime(), ChronoUnit.DAYS) / ((DateTimeUnit.DayBased) unit).getDays());
        }
        throw new NoWhenBranchMatchedException();
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
        return MathKt.clampToInt(localDate.getValue$kotlinx_datetime().until(other.getValue$kotlinx_datetime(), ChronoUnit.YEARS));
    }
}
