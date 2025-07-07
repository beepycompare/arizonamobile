package kotlinx.datetime;

import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Converters.kt */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\b\u001a\n\u0010\t\u001a\u00020\n*\u00020\u000b\u001a\n\u0010\f\u001a\u00020\r*\u00020\u000e\u001a\n\u0010\u000f\u001a\u00020\u0010*\u00020\u0011\u001a\n\u0010\u0012\u001a\u00020\u0013*\u00020\u0014\u001a\n\u0010\u0012\u001a\u00020\u0013*\u00020\u0015\u001a\n\u0010\u0016\u001a\u00020\u000e*\u00020\r\u001a\n\u0010\u0017\u001a\u00020\u0014*\u00020\u0013\u001a\n\u0010\u0018\u001a\u00020\u0002*\u00020\u0001\u001a\n\u0010\u0019\u001a\u00020\u0005*\u00020\u0004\u001a\n\u0010\u001a\u001a\u00020\b*\u00020\u0007\u001a\n\u0010\u001b\u001a\u00020\u000b*\u00020\n\u001a\n\u0010\u001c\u001a\u00020\u0011*\u00020\u0010\u001a\n\u0010\u001d\u001a\u00020\u0015*\u00020\u0013\u001a\f\u0010\u001e\u001a\u00020\u0014*\u00020\u0013H\u0007¨\u0006\u001f"}, d2 = {"toJavaInstant", "Ljava/time/Instant;", "Lkotlinx/datetime/Instant;", "toJavaLocalDate", "Ljava/time/LocalDate;", "Lkotlinx/datetime/LocalDate;", "toJavaLocalDateTime", "Ljava/time/LocalDateTime;", "Lkotlinx/datetime/LocalDateTime;", "toJavaLocalTime", "Ljava/time/LocalTime;", "Lkotlinx/datetime/LocalTime;", "toJavaPeriod", "Ljava/time/Period;", "Lkotlinx/datetime/DatePeriod;", "toJavaZoneId", "Ljava/time/ZoneId;", "Lkotlinx/datetime/TimeZone;", "toJavaZoneOffset", "Ljava/time/ZoneOffset;", "Lkotlinx/datetime/FixedOffsetTimeZone;", "Lkotlinx/datetime/UtcOffset;", "toKotlinDatePeriod", "toKotlinFixedOffsetTimeZone", "toKotlinInstant", "toKotlinLocalDate", "toKotlinLocalDateTime", "toKotlinLocalTime", "toKotlinTimeZone", "toKotlinUtcOffset", "toKotlinZoneOffset", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ConvertersKt {
    public static final java.time.Instant toJavaInstant(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return instant.getValue$kotlinx_datetime();
    }

    public static final Instant toKotlinInstant(java.time.Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return new Instant(instant);
    }

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
}
