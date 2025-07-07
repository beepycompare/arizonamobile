package kotlinx.datetime;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.time.DateTimeException;
import java.time.ZoneId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TimeZoneJvm.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\t2\u0006\u0010\f\u001a\u00020\u0006\u001a\u0012\u0010\r\u001a\u00020\u0006*\u00020\u000e2\u0006\u0010\b\u001a\u00020\t\u001a\u0012\u0010\r\u001a\u00020\u0006*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b\u001a\u0012\u0010\u0010\u001a\u00020\u000e*\u00020\u00062\u0006\u0010\b\u001a\u00020\t\u001a\u0014\u0010\u0010\u001a\u00020\u000e*\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000bH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0011"}, d2 = {"isFixedOffset", "", "Ljava/time/ZoneId;", "isFixedOffset$TimeZoneKt__TimeZoneJvmKt", "(Ljava/time/ZoneId;)Z", "atStartOfDayIn", "Lkotlinx/datetime/Instant;", "Lkotlinx/datetime/LocalDate;", RemoteConfigConstants.RequestFieldKey.TIME_ZONE, "Lkotlinx/datetime/TimeZone;", "offsetAt", "Lkotlinx/datetime/UtcOffset;", "instant", "toInstant", "Lkotlinx/datetime/LocalDateTime;", TypedValues.CycleType.S_WAVE_OFFSET, "toLocalDateTime", "kotlinx-datetime"}, k = 5, mv = {1, 9, 0}, xi = 48, xs = "kotlinx/datetime/TimeZoneKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class TimeZoneKt__TimeZoneJvmKt {
    public static final boolean isFixedOffset$TimeZoneKt__TimeZoneJvmKt(ZoneId zoneId) {
        try {
            return zoneId.getRules().isFixedOffset();
        } catch (ArrayIndexOutOfBoundsException unused) {
            return false;
        }
    }

    public static final UtcOffset offsetAt(TimeZone timeZone, Instant instant) {
        Intrinsics.checkNotNullParameter(timeZone, "<this>");
        Intrinsics.checkNotNullParameter(instant, "instant");
        return new UtcOffset(timeZone.getZoneId$kotlinx_datetime().getRules().getOffset(instant.getValue$kotlinx_datetime()));
    }

    public static final LocalDateTime toLocalDateTime(Instant instant, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            return new LocalDateTime(java.time.LocalDateTime.ofInstant(instant.getValue$kotlinx_datetime(), timeZone.getZoneId$kotlinx_datetime()));
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    public static final LocalDateTime toLocalDateTime(Instant instant, UtcOffset offset) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(offset, "offset");
        try {
            return new LocalDateTime(java.time.LocalDateTime.ofInstant(instant.getValue$kotlinx_datetime(), offset.getZoneOffset$kotlinx_datetime()));
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    public static final Instant toInstant(LocalDateTime localDateTime, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return new Instant(localDateTime.getValue$kotlinx_datetime().atZone(timeZone.getZoneId$kotlinx_datetime()).toInstant());
    }

    public static final Instant toInstant(LocalDateTime localDateTime, UtcOffset offset) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(offset, "offset");
        return new Instant(localDateTime.getValue$kotlinx_datetime().toInstant(offset.getZoneOffset$kotlinx_datetime()));
    }

    public static final Instant atStartOfDayIn(LocalDate localDate, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return new Instant(localDate.getValue$kotlinx_datetime().atStartOfDay(timeZone.getZoneId$kotlinx_datetime()).toInstant());
    }
}
