package kotlinx.datetime;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.time.DateTimeException;
import java.time.ZoneId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Instant;
import kotlin.time.jdk8.InstantConversionsJDK8Kt;
/* compiled from: TimeZoneJvm.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\t2\u0006\u0010\f\u001a\u00020\u0007\u001a\u0014\u0010\n\u001a\u00020\u000b*\u00020\t2\u0006\u0010\r\u001a\u00020\u0006H\u0000\u001a\u001c\u0010\u000e\u001a\u00020\t*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u000e\u001a\u00020\t*\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u001a\u001c\u0010\u0011\u001a\u00020\t*\u00020\u00122\u0006\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u0010\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0013"}, d2 = {"isFixedOffset", "", "Ljava/time/ZoneId;", "isFixedOffset$TimeZoneKt__TimeZoneJvmKt", "(Ljava/time/ZoneId;)Z", "offsetAt", "Lkotlinx/datetime/UtcOffset;", "Lkotlinx/datetime/TimeZone;", "instant", "Lkotlin/time/Instant;", "toLocalDateTime", "Lkotlinx/datetime/LocalDateTime;", RemoteConfigConstants.RequestFieldKey.TIME_ZONE, TypedValues.CycleType.S_WAVE_OFFSET, "toInstant", "youShallNotPass", "Lkotlinx/datetime/OverloadMarker;", "atStartOfDayIn", "Lkotlinx/datetime/LocalDate;", "kotlinx-datetime"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "kotlinx/datetime/TimeZoneKt")
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
        return new UtcOffset(timeZone.getZoneId$kotlinx_datetime().getRules().getOffset(InstantConversionsJDK8Kt.toJavaInstant(instant)));
    }

    public static final LocalDateTime toLocalDateTime(Instant instant, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            return new LocalDateTime(java.time.LocalDateTime.ofInstant(InstantConversionsJDK8Kt.toJavaInstant(instant), timeZone.getZoneId$kotlinx_datetime()));
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    public static final LocalDateTime toLocalDateTime(Instant instant, UtcOffset offset) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(offset, "offset");
        try {
            return new LocalDateTime(java.time.LocalDateTime.ofInstant(InstantConversionsJDK8Kt.toJavaInstant(instant), offset.getZoneOffset$kotlinx_datetime()));
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    public static final Instant toInstant(LocalDateTime localDateTime, TimeZone timeZone, OverloadMarker youShallNotPass) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Intrinsics.checkNotNullParameter(youShallNotPass, "youShallNotPass");
        java.time.Instant instant = localDateTime.getValue$kotlinx_datetime().atZone(timeZone.getZoneId$kotlinx_datetime()).toInstant();
        Intrinsics.checkNotNullExpressionValue(instant, "toInstant(...)");
        return InstantConversionsJDK8Kt.toKotlinInstant(instant);
    }

    public static final Instant toInstant(LocalDateTime localDateTime, UtcOffset offset, OverloadMarker youShallNotPass) {
        Intrinsics.checkNotNullParameter(localDateTime, "<this>");
        Intrinsics.checkNotNullParameter(offset, "offset");
        Intrinsics.checkNotNullParameter(youShallNotPass, "youShallNotPass");
        java.time.Instant instant = localDateTime.getValue$kotlinx_datetime().toInstant(offset.getZoneOffset$kotlinx_datetime());
        Intrinsics.checkNotNullExpressionValue(instant, "toInstant(...)");
        return InstantConversionsJDK8Kt.toKotlinInstant(instant);
    }

    public static final Instant atStartOfDayIn(LocalDate localDate, TimeZone timeZone, OverloadMarker youShallNotPass) {
        Intrinsics.checkNotNullParameter(localDate, "<this>");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Intrinsics.checkNotNullParameter(youShallNotPass, "youShallNotPass");
        java.time.Instant instant = localDate.getValue$kotlinx_datetime().atStartOfDay(timeZone.getZoneId$kotlinx_datetime()).toInstant();
        Intrinsics.checkNotNullExpressionValue(instant, "toInstant(...)");
        return InstantConversionsJDK8Kt.toKotlinInstant(instant);
    }

    public static /* synthetic */ Instant atStartOfDayIn$default(LocalDate localDate, TimeZone timeZone, OverloadMarker overloadMarker, int i, Object obj) {
        if ((i & 2) != 0) {
            overloadMarker = OverloadMarker.Companion.getINSTANCE$kotlinx_datetime();
        }
        return TimeZoneKt.atStartOfDayIn(localDate, timeZone, overloadMarker);
    }

    public static /* synthetic */ Instant toInstant$default(LocalDateTime localDateTime, TimeZone timeZone, OverloadMarker overloadMarker, int i, Object obj) {
        if ((i & 2) != 0) {
            overloadMarker = OverloadMarker.Companion.getINSTANCE$kotlinx_datetime();
        }
        return TimeZoneKt.toInstant(localDateTime, timeZone, overloadMarker);
    }

    public static /* synthetic */ Instant toInstant$default(LocalDateTime localDateTime, UtcOffset utcOffset, OverloadMarker overloadMarker, int i, Object obj) {
        if ((i & 2) != 0) {
            overloadMarker = OverloadMarker.Companion.getINSTANCE$kotlinx_datetime();
        }
        return TimeZoneKt.toInstant(localDateTime, utcOffset, overloadMarker);
    }
}
