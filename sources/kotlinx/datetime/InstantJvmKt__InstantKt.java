package kotlinx.datetime;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.time.DateTimeException;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlin.time.Instant;
import kotlin.time.jdk8.InstantConversionsJDK8Kt;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.internal.DivRemResult;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.internal.MathKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Instant.kt */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0019\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\b\u0005\u001a\u001a\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004\u001a\u001c\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004H\u0007\u001a\"\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004\u001a\"\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004\u001a\"\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004\u001a\u001a\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\f\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0010\u001a\u001a\u0010\u0011\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004\u001a\"\u0010\u0013\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004¨\u0006\u0014"}, d2 = {"atZone", "Ljava/time/ZonedDateTime;", "Lkotlin/time/Instant;", "zone", "Lkotlinx/datetime/TimeZone;", "atZone$InstantJvmKt__InstantKt", "plus", TypedValues.CycleType.S_WAVE_PERIOD, "Lkotlinx/datetime/DateTimePeriod;", RemoteConfigConstants.RequestFieldKey.TIME_ZONE, "unit", "Lkotlinx/datetime/DateTimeUnit;", "value", "", "minus", "", "Lkotlinx/datetime/DateTimeUnit$TimeBased;", "periodUntil", "other", "until", "kotlinx-datetime"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "kotlinx/datetime/InstantJvmKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class InstantJvmKt__InstantKt {
    private static final ZonedDateTime atZone$InstantJvmKt__InstantKt(Instant instant, TimeZone timeZone) {
        try {
            ZonedDateTime atZone = InstantConversionsJDK8Kt.toJavaInstant(instant).atZone(timeZone.getZoneId$kotlinx_datetime());
            Intrinsics.checkNotNull(atZone);
            return atZone;
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    public static final Instant plus(Instant instant, DateTimePeriod period, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(period, "period");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            ZonedDateTime atZone$InstantJvmKt__InstantKt = atZone$InstantJvmKt__InstantKt(instant, timeZone);
            if (period.getTotalMonths$kotlinx_datetime() != 0) {
                atZone$InstantJvmKt__InstantKt = atZone$InstantJvmKt__InstantKt.plusMonths(period.getTotalMonths$kotlinx_datetime());
            }
            if (period.getDays() != 0) {
                atZone$InstantJvmKt__InstantKt = atZone$InstantJvmKt__InstantKt.plusDays(period.getDays());
            }
            if (period.getTotalNanoseconds$kotlinx_datetime() != 0) {
                atZone$InstantJvmKt__InstantKt = atZone$InstantJvmKt__InstantKt.plusNanos(period.getTotalNanoseconds$kotlinx_datetime());
            }
            java.time.Instant instant2 = atZone$InstantJvmKt__InstantKt.toInstant();
            Intrinsics.checkNotNullExpressionValue(instant2, "toInstant(...)");
            return InstantConversionsJDK8Kt.toKotlinInstant(instant2);
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    @Deprecated(message = "Use the plus overload with an explicit number of units", replaceWith = @ReplaceWith(expression = "this.plus(1, unit, timeZone)", imports = {}))
    public static final Instant plus(Instant instant, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return InstantJvmKt.plus(instant, 1L, unit, timeZone);
    }

    public static final Instant plus(Instant instant, int i, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return InstantJvmKt.plus(instant, i, unit, timeZone);
    }

    public static final Instant minus(Instant instant, int i, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return InstantJvmKt.plus(instant, -i, unit, timeZone);
    }

    public static final Instant plus(Instant instant, long j, DateTimeUnit unit, TimeZone timeZone) {
        java.time.Instant instant2;
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            ZonedDateTime atZone$InstantJvmKt__InstantKt = atZone$InstantJvmKt__InstantKt(instant, timeZone);
            if (unit instanceof DateTimeUnit.TimeBased) {
                instant2 = InstantConversionsJDK8Kt.toJavaInstant(InstantJvmKt.plus(instant, j, (DateTimeUnit.TimeBased) unit));
                instant2.atZone(timeZone.getZoneId$kotlinx_datetime());
            } else if (unit instanceof DateTimeUnit.DayBased) {
                instant2 = atZone$InstantJvmKt__InstantKt.plusDays(MathJvmKt.safeMultiply(j, ((DateTimeUnit.DayBased) unit).getDays())).toInstant();
            } else if (!(unit instanceof DateTimeUnit.MonthBased)) {
                throw new NoWhenBranchMatchedException();
            } else {
                instant2 = atZone$InstantJvmKt__InstantKt.plusMonths(MathJvmKt.safeMultiply(j, ((DateTimeUnit.MonthBased) unit).getMonths())).toInstant();
            }
            Intrinsics.checkNotNull(instant2);
            return InstantConversionsJDK8Kt.toKotlinInstant(instant2);
        } catch (Exception e) {
            if ((e instanceof DateTimeException) || (e instanceof ArithmeticException)) {
                throw new DateTimeArithmeticException("Instant " + instant + " cannot be represented as local date when adding " + j + ' ' + unit + " to it", e);
            }
            throw e;
        }
    }

    public static final Instant plus(Instant instant, long j, DateTimeUnit.TimeBased unit) {
        long j2;
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        try {
            j2 = j;
        } catch (Exception e) {
            e = e;
            j2 = j;
        }
        try {
            DivRemResult multiplyAndDivide = MathKt.multiplyAndDivide(j2, unit.getNanoseconds(), C.NANOS_PER_SECOND);
            long component1 = multiplyAndDivide.component1();
            long component2 = multiplyAndDivide.component2();
            Duration.Companion companion = Duration.Companion;
            Instant m9923plusLRDsOJo = instant.m9923plusLRDsOJo(DurationKt.toDuration(component1, DurationUnit.SECONDS));
            Duration.Companion companion2 = Duration.Companion;
            return m9923plusLRDsOJo.m9923plusLRDsOJo(DurationKt.toDuration(component2, DurationUnit.NANOSECONDS));
        } catch (Exception e2) {
            e = e2;
            Exception exc = e;
            if ((exc instanceof DateTimeException) || (exc instanceof ArithmeticException)) {
                return Instant.Companion.fromEpochSeconds$default(Instant.Companion, j2 > 0 ? Long.MAX_VALUE : Long.MIN_VALUE, 0L, 2, null);
            }
            throw exc;
        }
    }

    public static final DateTimePeriod periodUntil(Instant instant, Instant other, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        ZonedDateTime atZone$InstantJvmKt__InstantKt = atZone$InstantJvmKt__InstantKt(instant, timeZone);
        ZonedDateTime atZone$InstantJvmKt__InstantKt2 = atZone$InstantJvmKt__InstantKt(other, timeZone);
        long until = atZone$InstantJvmKt__InstantKt.until(atZone$InstantJvmKt__InstantKt2, ChronoUnit.MONTHS);
        ZonedDateTime plusMonths = atZone$InstantJvmKt__InstantKt.plusMonths(until);
        Intrinsics.checkNotNullExpressionValue(plusMonths, "plusMonths(...)");
        long until2 = plusMonths.until(atZone$InstantJvmKt__InstantKt2, ChronoUnit.DAYS);
        ZonedDateTime plusDays = plusMonths.plusDays(until2);
        Intrinsics.checkNotNullExpressionValue(plusDays, "plusDays(...)");
        return DateTimePeriodKt.buildDateTimePeriod(until, (int) until2, plusDays.until(atZone$InstantJvmKt__InstantKt2, ChronoUnit.NANOS));
    }

    public static final long until(Instant instant, Instant other, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            ZonedDateTime atZone$InstantJvmKt__InstantKt = atZone$InstantJvmKt__InstantKt(instant, timeZone);
            ZonedDateTime atZone$InstantJvmKt__InstantKt2 = atZone$InstantJvmKt__InstantKt(other, timeZone);
            if (unit instanceof DateTimeUnit.TimeBased) {
                return InstantKt.until(instant, other, (DateTimeUnit.TimeBased) unit);
            }
            if (unit instanceof DateTimeUnit.DayBased) {
                return atZone$InstantJvmKt__InstantKt.until(atZone$InstantJvmKt__InstantKt2, ChronoUnit.DAYS) / ((DateTimeUnit.DayBased) unit).getDays();
            }
            if (unit instanceof DateTimeUnit.MonthBased) {
                return atZone$InstantJvmKt__InstantKt.until(atZone$InstantJvmKt__InstantKt2, ChronoUnit.MONTHS) / ((DateTimeUnit.MonthBased) unit).getMonths();
            }
            throw new NoWhenBranchMatchedException();
        } catch (ArithmeticException unused) {
            return instant.compareTo(other) < 0 ? Long.MAX_VALUE : Long.MIN_VALUE;
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }
}
