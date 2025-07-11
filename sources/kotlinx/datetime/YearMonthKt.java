package kotlinx.datetime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.YearMonth;
import kotlinx.datetime.format.DateTimeFormat;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.internal.MathKt;
/* compiled from: YearMonth.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003\u001a\u0012\u0010\b\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\t\u001a\u00020\n\u001a\u0012\u0010\u000b\u001a\u00020\n*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002\u001a\u0012\u0010\r\u001a\u00020\n*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0002\u001a\u001a\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0011\u001a\n\u0010\u0012\u001a\u00020\u0002*\u00020\u0002\u001a\n\u0010\u0013\u001a\u00020\u0002*\u00020\u0002\u001a\n\u0010\u0014\u001a\u00020\u0002*\u00020\u0002\u001a\n\u0010\u0015\u001a\u00020\u0002*\u00020\u0002\u001a\u001a\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u001a\u0010\u0018\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u001a\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u001a\u0010\u0018\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0014\u0010\u001c\u001a\u00020\u0002*\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u000fH\u0000\"\u0015\u0010\u0004\u001a\u00020\u0002*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0018\u0010\u0019\u001a\u00020\u000f*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u0018\u0010\u001e\u001a\u00020\u0002*\u00020\u001d8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u0018\u0010!\u001a\u00020\u0002*\u00020\u001d8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010 ¨\u0006#"}, d2 = {"format", "", "Lkotlinx/datetime/YearMonth;", "Lkotlinx/datetime/format/DateTimeFormat;", "yearMonth", "Lkotlinx/datetime/LocalDate;", "getYearMonth", "(Lkotlinx/datetime/LocalDate;)Lkotlinx/datetime/YearMonth;", "onDay", "day", "", "yearsUntil", "other", "monthsUntil", "until", "", "unit", "Lkotlinx/datetime/DateTimeUnit$MonthBased;", "plusYear", "minusYear", "plusMonth", "minusMonth", "plus", "value", "minus", "prolepticMonth", "getProlepticMonth", "(Lkotlinx/datetime/YearMonth;)J", "fromProlepticMonth", "Lkotlinx/datetime/YearMonth$Companion;", "MAX", "getMAX", "(Lkotlinx/datetime/YearMonth$Companion;)Lkotlinx/datetime/YearMonth;", "MIN", "getMIN", "kotlinx-datetime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class YearMonthKt {
    public static final String format(YearMonth yearMonth, DateTimeFormat<YearMonth> format) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return format.format(yearMonth);
    }

    public static final YearMonth getYearMonth(LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        return new YearMonth(localDate.getYear(), localDate.m10086getMonth());
    }

    public static final LocalDate onDay(YearMonth yearMonth, int i) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        return new LocalDate(yearMonth.getYear(), yearMonth.getMonth(), i);
    }

    public static final int yearsUntil(YearMonth yearMonth, YearMonth other) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return (int) ((getProlepticMonth(other) - getProlepticMonth(yearMonth)) / 12);
    }

    public static final int monthsUntil(YearMonth yearMonth, YearMonth other) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return MathKt.clampToInt(getProlepticMonth(other) - getProlepticMonth(yearMonth));
    }

    public static final long until(YearMonth yearMonth, YearMonth other, DateTimeUnit.MonthBased unit) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (getProlepticMonth(other) - getProlepticMonth(yearMonth)) / unit.getMonths();
    }

    public static final YearMonth plusYear(YearMonth yearMonth) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        return plus(yearMonth, 1, DateTimeUnit.Companion.getYEAR());
    }

    public static final YearMonth minusYear(YearMonth yearMonth) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        return minus(yearMonth, 1, DateTimeUnit.Companion.getYEAR());
    }

    public static final YearMonth plusMonth(YearMonth yearMonth) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        return plus(yearMonth, 1, DateTimeUnit.Companion.getMONTH());
    }

    public static final YearMonth minusMonth(YearMonth yearMonth) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        return minus(yearMonth, 1, DateTimeUnit.Companion.getMONTH());
    }

    public static final YearMonth plus(YearMonth yearMonth, int i, DateTimeUnit.MonthBased unit) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return plus(yearMonth, i, unit);
    }

    public static final YearMonth minus(YearMonth yearMonth, int i, DateTimeUnit.MonthBased unit) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return minus(yearMonth, i, unit);
    }

    public static final YearMonth plus(YearMonth yearMonth, long j, DateTimeUnit.MonthBased unit) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        try {
            long safeMultiply = MathJvmKt.safeMultiply(j, unit.getMonths());
            return safeMultiply == 0 ? yearMonth : fromProlepticMonth(YearMonth.Companion, MathJvmKt.safeAdd(getProlepticMonth(yearMonth), safeMultiply));
        } catch (ArithmeticException e) {
            throw new DateTimeArithmeticException("Arithmetic overflow when adding " + j + " of " + unit + " to " + yearMonth, e);
        } catch (IllegalArgumentException e2) {
            throw new DateTimeArithmeticException("Boundaries of YearMonth exceeded when adding " + j + " of " + unit + " to " + yearMonth, e2);
        }
    }

    public static final YearMonth minus(YearMonth yearMonth, long j, DateTimeUnit.MonthBased unit) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return j != Long.MIN_VALUE ? plus(yearMonth, -j, unit) : plus(plus(yearMonth, Long.MAX_VALUE, unit), 1, unit);
    }

    public static final long getProlepticMonth(YearMonth yearMonth) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        return (yearMonth.getYear() * 12) + (yearMonth.getMonthNumber$kotlinx_datetime() - 1);
    }

    public static final YearMonth fromProlepticMonth(YearMonth.Companion companion, long j) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        long j2 = 12;
        long j3 = j / j2;
        if ((j ^ j2) < 0 && j3 * j2 != j) {
            j3--;
        }
        int year = LocalDate.Companion.getMIN$kotlinx_datetime().getYear();
        if (j3 > LocalDate.Companion.getMAX$kotlinx_datetime().getYear() || year > j3) {
            throw new IllegalArgumentException(("Year " + j3 + " is out of range: " + LocalDate.Companion.getMIN$kotlinx_datetime().getYear() + ".." + LocalDate.Companion.getMAX$kotlinx_datetime().getYear()).toString());
        }
        long j4 = j % j2;
        return new YearMonth((int) j3, ((int) (j4 + (j2 & (((j4 ^ j2) & ((-j4) | j4)) >> 63)))) + 1);
    }

    public static final YearMonth getMAX(YearMonth.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return getYearMonth(LocalDate.Companion.getMAX$kotlinx_datetime());
    }

    public static final YearMonth getMIN(YearMonth.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return getYearMonth(LocalDate.Companion.getMIN$kotlinx_datetime());
    }
}
