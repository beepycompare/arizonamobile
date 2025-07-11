package kotlinx.datetime;

import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Converters.kt */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0002*\u00020\u0001\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0006\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0005\u001a\n\u0010\b\u001a\u00020\t*\u00020\n\u001a\n\u0010\u000b\u001a\u00020\n*\u00020\t\u001a\n\u0010\f\u001a\u00020\r*\u00020\u000e\u001a\n\u0010\u000f\u001a\u00020\u000e*\u00020\r\u001a\n\u0010\u0010\u001a\u00020\u0011*\u00020\u0012\u001a\n\u0010\u0013\u001a\u00020\u0012*\u00020\u0011\u001a\n\u0010\u0014\u001a\u00020\u0015*\u00020\u0016\u001a\n\u0010\u0017\u001a\u00020\u0016*\u00020\u0015\u001a\f\u0010\u0018\u001a\u00020\u0016*\u00020\u0015H\u0007\u001a\n\u0010\u0014\u001a\u00020\u0015*\u00020\u0019\u001a\n\u0010\u001a\u001a\u00020\u0019*\u00020\u0015\u001a\n\u0010\u001b\u001a\u00020\u001c*\u00020\u001d\u001a\n\u0010\u001e\u001a\u00020\u001d*\u00020\u001c\u001a\n\u0010\u001f\u001a\u00020 *\u00020!\u001a\n\u0010\"\u001a\u00020!*\u00020 \u001a\n\u0010#\u001a\u00020$*\u00020%\u001a\n\u0010&\u001a\u00020%*\u00020$¨\u0006'"}, d2 = {"toJavaLocalDateTime", "Ljava/time/LocalDateTime;", "Lkotlinx/datetime/LocalDateTime;", "toKotlinLocalDateTime", "toJavaLocalTime", "Ljava/time/LocalTime;", "Lkotlinx/datetime/LocalTime;", "toKotlinLocalTime", "toJavaLocalDate", "Ljava/time/LocalDate;", "Lkotlinx/datetime/LocalDate;", "toKotlinLocalDate", "toJavaPeriod", "Ljava/time/Period;", "Lkotlinx/datetime/DatePeriod;", "toKotlinDatePeriod", "toJavaZoneId", "Ljava/time/ZoneId;", "Lkotlinx/datetime/TimeZone;", "toKotlinTimeZone", "toJavaZoneOffset", "Ljava/time/ZoneOffset;", "Lkotlinx/datetime/FixedOffsetTimeZone;", "toKotlinFixedOffsetTimeZone", "toKotlinZoneOffset", "Lkotlinx/datetime/UtcOffset;", "toKotlinUtcOffset", "toJavaMonth", "Ljava/time/Month;", "Lkotlinx/datetime/Month;", "toKotlinMonth", "toJavaDayOfWeek", "Ljava/time/DayOfWeek;", "Lkotlinx/datetime/DayOfWeek;", "toKotlinDayOfWeek", "toJavaYearMonth", "Ljava/time/YearMonth;", "Lkotlinx/datetime/YearMonth;", "toKotlinYearMonth", "kotlinx-datetime"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConvertersKt {
    public static final java.time.LocalDateTime toJavaLocalDateTime(LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        return localDateTime.getValue$kotlinx_datetime();
    }

    public static final LocalDateTime toKotlinLocalDateTime(java.time.LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        return new LocalDateTime(localDateTime);
    }

    public static final java.time.LocalTime toJavaLocalTime(LocalTime localTime) {
        Intrinsics.checkNotNullParameter(localTime, "<this>");
        return localTime.getValue$kotlinx_datetime();
    }

    public static final LocalTime toKotlinLocalTime(java.time.LocalTime localTime) {
        Intrinsics.checkNotNullParameter(localTime, "<this>");
        return new LocalTime(localTime);
    }

    public static final java.time.LocalDate toJavaLocalDate(LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        return localDate.getValue$kotlinx_datetime();
    }

    public static final LocalDate toKotlinLocalDate(java.time.LocalDate localDate) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        return new LocalDate(localDate);
    }

    public static final Period toJavaPeriod(DatePeriod datePeriod) {
        Intrinsics.checkNotNullParameter(datePeriod, "<this>");
        Period of = Period.of(datePeriod.getYears(), datePeriod.getMonths(), datePeriod.getDays());
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        return of;
    }

    public static final DatePeriod toKotlinDatePeriod(Period period) {
        Intrinsics.checkNotNullParameter(period, "<this>");
        return new DatePeriod(period.getYears(), period.getMonths(), period.getDays());
    }

    public static final ZoneId toJavaZoneId(TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(timeZone, "<this>");
        return timeZone.getZoneId$kotlinx_datetime();
    }

    public static final TimeZone toKotlinTimeZone(ZoneId zoneId) {
        Intrinsics.checkNotNullParameter(zoneId, "<this>");
        return TimeZone.Companion.ofZone$kotlinx_datetime(zoneId);
    }

    public static final ZoneOffset toJavaZoneOffset(FixedOffsetTimeZone fixedOffsetTimeZone) {
        Intrinsics.checkNotNullParameter(fixedOffsetTimeZone, "<this>");
        return fixedOffsetTimeZone.getOffset().getZoneOffset$kotlinx_datetime();
    }

    public static final FixedOffsetTimeZone toKotlinFixedOffsetTimeZone(ZoneOffset zoneOffset) {
        Intrinsics.checkNotNullParameter(zoneOffset, "<this>");
        return new FixedOffsetTimeZone(new UtcOffset(zoneOffset));
    }

    @Deprecated(message = "Use toKotlinFixedOffsetTimeZone() instead.", replaceWith = @ReplaceWith(expression = "this.toKotlinFixedOffsetTimeZone()", imports = {}))
    public static final FixedOffsetTimeZone toKotlinZoneOffset(ZoneOffset zoneOffset) {
        Intrinsics.checkNotNullParameter(zoneOffset, "<this>");
        return toKotlinFixedOffsetTimeZone(zoneOffset);
    }

    public static final ZoneOffset toJavaZoneOffset(UtcOffset utcOffset) {
        Intrinsics.checkNotNullParameter(utcOffset, "<this>");
        return utcOffset.getZoneOffset$kotlinx_datetime();
    }

    public static final UtcOffset toKotlinUtcOffset(ZoneOffset zoneOffset) {
        Intrinsics.checkNotNullParameter(zoneOffset, "<this>");
        return new UtcOffset(zoneOffset);
    }

    public static final java.time.Month toJavaMonth(Month month) {
        Intrinsics.checkNotNullParameter(month, "<this>");
        java.time.Month of = java.time.Month.of(MonthKt.getNumber(month));
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        return of;
    }

    public static final Month toKotlinMonth(java.time.Month month) {
        Intrinsics.checkNotNullParameter(month, "<this>");
        return (Month) Month.getEntries().get(month.getValue() - 1);
    }

    public static final java.time.DayOfWeek toJavaDayOfWeek(DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "<this>");
        java.time.DayOfWeek of = java.time.DayOfWeek.of(DayOfWeekKt.getIsoDayNumber(dayOfWeek));
        Intrinsics.checkNotNullExpressionValue(of, "of(...)");
        return of;
    }

    public static final DayOfWeek toKotlinDayOfWeek(java.time.DayOfWeek dayOfWeek) {
        Intrinsics.checkNotNullParameter(dayOfWeek, "<this>");
        return (DayOfWeek) DayOfWeek.getEntries().get(dayOfWeek.getValue() - 1);
    }

    public static final java.time.YearMonth toJavaYearMonth(YearMonth yearMonth) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        return yearMonth.getValue$kotlinx_datetime();
    }

    public static final YearMonth toKotlinYearMonth(java.time.YearMonth yearMonth) {
        Intrinsics.checkNotNullParameter(yearMonth, "<this>");
        return new YearMonth(yearMonth);
    }
}
