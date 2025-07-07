package kotlinx.datetime;

import androidx.collection.SieveCacheKt;
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
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.internal.DivRemResult;
import kotlinx.datetime.internal.MathJvmKt;
import kotlinx.datetime.internal.MathKt;
/* compiled from: Instant.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0002\u001a\"\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004\u001a\u001a\u0010\u000b\u001a\u00020\f*\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004\u001a\"\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004\u001a\"\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004\u001a\u001a\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0010\u001a\u001a\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0004\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0007\u001a\"\u0010\u0012\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004¨\u0006\u0013"}, d2 = {"atZone", "Ljava/time/ZonedDateTime;", "Lkotlinx/datetime/Instant;", "zone", "Lkotlinx/datetime/TimeZone;", "minus", "value", "", "unit", "Lkotlinx/datetime/DateTimeUnit;", RemoteConfigConstants.RequestFieldKey.TIME_ZONE, "periodUntil", "Lkotlinx/datetime/DateTimePeriod;", "other", "plus", "", "Lkotlinx/datetime/DateTimeUnit$TimeBased;", TypedValues.CycleType.S_WAVE_PERIOD, "until", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InstantJvmKt {
    private static final ZonedDateTime atZone(Instant instant, TimeZone timeZone) {
        try {
            ZonedDateTime atZone = instant.getValue$kotlinx_datetime().atZone(timeZone.getZoneId$kotlinx_datetime());
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
            ZonedDateTime atZone = atZone(instant, timeZone);
            if (period.getTotalMonths$kotlinx_datetime() != 0) {
                atZone = atZone.plusMonths(period.getTotalMonths$kotlinx_datetime());
            }
            if (period.getDays() != 0) {
                atZone = atZone.plusDays(period.getDays());
            }
            if (period.getTotalNanoseconds$kotlinx_datetime() != 0) {
                atZone = atZone.plusNanos(period.getTotalNanoseconds$kotlinx_datetime());
            }
            return new Instant(atZone.toInstant());
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }

    @Deprecated(message = "Use the plus overload with an explicit number of units", replaceWith = @ReplaceWith(expression = "this.plus(1, unit, timeZone)", imports = {}))
    public static final Instant plus(Instant instant, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return plus(instant, 1L, unit, timeZone);
    }

    public static final Instant plus(Instant instant, int i, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return plus(instant, i, unit, timeZone);
    }

    public static final Instant minus(Instant instant, int i, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return plus(instant, -i, unit, timeZone);
    }

    public static final Instant plus(Instant instant, long j, DateTimeUnit unit, TimeZone timeZone) {
        java.time.Instant instant2;
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            ZonedDateTime atZone = atZone(instant, timeZone);
            if (unit instanceof DateTimeUnit.TimeBased) {
                instant2 = plus(instant, j, (DateTimeUnit.TimeBased) unit).getValue$kotlinx_datetime();
                instant2.atZone(timeZone.getZoneId$kotlinx_datetime());
            } else if (unit instanceof DateTimeUnit.DayBased) {
                instant2 = atZone.plusDays(MathJvmKt.safeMultiply(j, ((DateTimeUnit.DayBased) unit).getDays())).toInstant();
            } else if (unit instanceof DateTimeUnit.MonthBased) {
                instant2 = atZone.plusMonths(MathJvmKt.safeMultiply(j, ((DateTimeUnit.MonthBased) unit).getMonths())).toInstant();
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return new Instant(instant2);
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
            java.time.Instant plusNanos = instant.getValue$kotlinx_datetime().plusSeconds(multiplyAndDivide.component1()).plusNanos(multiplyAndDivide.component2());
            Intrinsics.checkNotNullExpressionValue(plusNanos, "plusNanos(...)");
            return new Instant(plusNanos);
        } catch (Exception e2) {
            e = e2;
            Exception exc = e;
            if ((exc instanceof DateTimeException) || (exc instanceof ArithmeticException)) {
                return j2 > 0 ? Instant.Companion.getMAX$kotlinx_datetime() : Instant.Companion.getMIN$kotlinx_datetime();
            }
            throw exc;
        }
    }

    public static final DateTimePeriod periodUntil(Instant instant, Instant other, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        ZonedDateTime atZone = atZone(instant, timeZone);
        ZonedDateTime atZone2 = atZone(other, timeZone);
        long until = atZone.until(atZone2, ChronoUnit.MONTHS);
        ZonedDateTime plusMonths = atZone.plusMonths(until);
        Intrinsics.checkNotNullExpressionValue(plusMonths, "plusMonths(...)");
        long until2 = plusMonths.until(atZone2, ChronoUnit.DAYS);
        ZonedDateTime plusDays = plusMonths.plusDays(until2);
        Intrinsics.checkNotNullExpressionValue(plusDays, "plusDays(...)");
        long until3 = plusDays.until(atZone2, ChronoUnit.NANOS);
        if (until > SieveCacheKt.NodeLinkMask || until < SieveCacheKt.NodeMetaAndPreviousMask) {
            throw new DateTimeArithmeticException("The number of months between " + instant + " and " + other + " does not fit in an Int");
        }
        return DateTimePeriodKt.buildDateTimePeriod((int) until, (int) until2, until3);
    }

    public static final long until(Instant instant, Instant other, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        try {
            ZonedDateTime atZone = atZone(instant, timeZone);
            ZonedDateTime atZone2 = atZone(other, timeZone);
            if (unit instanceof DateTimeUnit.TimeBased) {
                return InstantKt.until(instant, other, (DateTimeUnit.TimeBased) unit);
            }
            if (unit instanceof DateTimeUnit.DayBased) {
                return atZone.until(atZone2, ChronoUnit.DAYS) / ((DateTimeUnit.DayBased) unit).getDays();
            }
            if (unit instanceof DateTimeUnit.MonthBased) {
                return atZone.until(atZone2, ChronoUnit.MONTHS) / ((DateTimeUnit.MonthBased) unit).getMonths();
            }
            throw new NoWhenBranchMatchedException();
        } catch (ArithmeticException unused) {
            return instant.getValue$kotlinx_datetime().compareTo(other.getValue$kotlinx_datetime()) < 0 ? Long.MAX_VALUE : Long.MIN_VALUE;
        } catch (DateTimeException e) {
            throw new DateTimeArithmeticException(e);
        }
    }
}
