package kotlinx.datetime;

import kotlin.Metadata;
@Metadata(d1 = {"kotlinx/datetime/TimeZoneKt__TimeZoneJvmKt", "kotlinx/datetime/TimeZoneKt__TimeZoneKt"}, k = 4, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class TimeZoneKt {
    public static final Instant atStartOfDayIn(LocalDate localDate, TimeZone timeZone) {
        return TimeZoneKt__TimeZoneJvmKt.atStartOfDayIn(localDate, timeZone);
    }

    public static final UtcOffset offsetAt(TimeZone timeZone, Instant instant) {
        return TimeZoneKt__TimeZoneJvmKt.offsetAt(timeZone, instant);
    }

    public static final UtcOffset offsetIn(Instant instant, TimeZone timeZone) {
        return TimeZoneKt__TimeZoneKt.offsetIn(instant, timeZone);
    }

    public static final Instant toInstant(LocalDateTime localDateTime, TimeZone timeZone) {
        return TimeZoneKt__TimeZoneJvmKt.toInstant(localDateTime, timeZone);
    }

    public static final Instant toInstant(LocalDateTime localDateTime, UtcOffset utcOffset) {
        return TimeZoneKt__TimeZoneJvmKt.toInstant(localDateTime, utcOffset);
    }

    public static final LocalDateTime toLocalDateTime(Instant instant, TimeZone timeZone) {
        return TimeZoneKt__TimeZoneJvmKt.toLocalDateTime(instant, timeZone);
    }

    public static final LocalDateTime toLocalDateTime(Instant instant, UtcOffset utcOffset) {
        return TimeZoneKt__TimeZoneJvmKt.toLocalDateTime(instant, utcOffset);
    }
}
