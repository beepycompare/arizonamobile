package kotlinx.datetime;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.Instant;
import kotlinx.datetime.format.DateTimeComponents;
import kotlinx.datetime.format.DateTimeComponentsKt;
import kotlinx.datetime.format.DateTimeFormat;
import kotlinx.datetime.internal.MathKt;
/* compiled from: Instant.kt */
@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u001a\u0010\b\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f\u001a\"\u0010\r\u001a\u00020\u000e*\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u001a\u001a\u0010\u0013\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016\u001a\"\u0010\u0013\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f\u001a\u001a\u0010\u0013\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u0016\u001a\u001a\u0010\u0013\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\f\u001a\u001c\u0010\u0013\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a\u0014\u0010\u0013\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\"\u0010\u0013\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f\u001a\u001a\u0010\u0013\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016\u001a\u001a\u0010\u0013\u001a\u00020\u0019*\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f\u001a\u001a\u0010\u001a\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f\u001a\u001a\u0010\u001b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0016\u001a\u0014\u0010\u001b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0007\u001a\f\u0010\u001c\u001a\u00020\u0005*\u00020\u000eH\u0007\u001a\u001a\u0010\u001d\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016\u001a\u001a\u0010\u001e\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\f\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0006\"\u0015\u0010\u0007\u001a\u00020\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0006¨\u0006\u001f"}, d2 = {"DISTANT_FUTURE_SECONDS", "", "DISTANT_PAST_SECONDS", "isDistantFuture", "", "Lkotlinx/datetime/Instant;", "(Lkotlinx/datetime/Instant;)Z", "isDistantPast", "daysUntil", "", "other", RemoteConfigConstants.RequestFieldKey.TIME_ZONE, "Lkotlinx/datetime/TimeZone;", "format", "", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", TypedValues.CycleType.S_WAVE_OFFSET, "Lkotlinx/datetime/UtcOffset;", "minus", "value", "unit", "Lkotlinx/datetime/DateTimeUnit$TimeBased;", "Lkotlinx/datetime/DateTimeUnit;", TypedValues.CycleType.S_WAVE_PERIOD, "Lkotlinx/datetime/DateTimePeriod;", "monthsUntil", "plus", "toInstant", "until", "yearsUntil", "kotlinx-datetime"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class InstantKt {
    public static final long DISTANT_FUTURE_SECONDS = 3093527980800L;
    public static final long DISTANT_PAST_SECONDS = -3217862419201L;

    public static final boolean isDistantPast(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return instant.compareTo(Instant.Companion.getDISTANT_PAST()) <= 0;
    }

    public static final boolean isDistantFuture(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return instant.compareTo(Instant.Companion.getDISTANT_FUTURE()) >= 0;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Removed to support more idiomatic code. See https://github.com/Kotlin/kotlinx-datetime/issues/339", replaceWith = @ReplaceWith(expression = "Instant.parse(this)", imports = {}))
    public static final Instant toInstant(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return Instant.Companion.parse$default(Instant.Companion, str, null, 2, null);
    }

    public static final Instant minus(Instant instant, DateTimePeriod period, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(period, "period");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        if (period.getTotalNanoseconds$kotlinx_datetime() != Long.MIN_VALUE) {
            return InstantJvmKt.plus(instant, DateTimePeriodKt.buildDateTimePeriod(-period.getTotalMonths$kotlinx_datetime(), -period.getDays(), -period.getTotalNanoseconds$kotlinx_datetime()), timeZone);
        }
        return plus(InstantJvmKt.plus(instant, DateTimePeriodKt.buildDateTimePeriod(-period.getTotalMonths$kotlinx_datetime(), -period.getDays(), -(period.getTotalNanoseconds$kotlinx_datetime() + 1)), timeZone), 1, DateTimeUnit.Companion.getNANOSECOND());
    }

    public static final long until(Instant instant, Instant other, DateTimeUnit.TimeBased unit) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        try {
            return MathKt.multiplyAddAndDivide(other.getEpochSeconds() - instant.getEpochSeconds(), C.NANOS_PER_SECOND, other.getNanosecondsOfSecond() - instant.getNanosecondsOfSecond(), unit.getNanoseconds());
        } catch (ArithmeticException unused) {
            return instant.compareTo(other) < 0 ? Long.MAX_VALUE : Long.MIN_VALUE;
        }
    }

    public static final int daysUntil(Instant instant, Instant other, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return MathKt.clampToInt(InstantJvmKt.until(instant, other, DateTimeUnit.Companion.getDAY(), timeZone));
    }

    public static final int monthsUntil(Instant instant, Instant other, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return MathKt.clampToInt(InstantJvmKt.until(instant, other, DateTimeUnit.Companion.getMONTH(), timeZone));
    }

    public static final int yearsUntil(Instant instant, Instant other, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return MathKt.clampToInt(InstantJvmKt.until(instant, other, DateTimeUnit.Companion.getYEAR(), timeZone));
    }

    public static final DateTimePeriod minus(Instant instant, Instant other, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return InstantJvmKt.periodUntil(other, instant, timeZone);
    }

    @Deprecated(message = "Use the minus overload with an explicit number of units", replaceWith = @ReplaceWith(expression = "this.minus(1, unit, timeZone)", imports = {}))
    public static final Instant minus(Instant instant, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return InstantJvmKt.plus(instant, -1, unit, timeZone);
    }

    @Deprecated(message = "Use the plus overload with an explicit number of units", replaceWith = @ReplaceWith(expression = "this.plus(1, unit)", imports = {}))
    public static final Instant plus(Instant instant, DateTimeUnit.TimeBased unit) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return InstantJvmKt.plus(instant, 1L, unit);
    }

    @Deprecated(message = "Use the minus overload with an explicit number of units", replaceWith = @ReplaceWith(expression = "this.minus(1, unit)", imports = {}))
    public static final Instant minus(Instant instant, DateTimeUnit.TimeBased unit) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return InstantJvmKt.plus(instant, -1L, unit);
    }

    public static final Instant plus(Instant instant, int i, DateTimeUnit.TimeBased unit) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return InstantJvmKt.plus(instant, i, unit);
    }

    public static final Instant minus(Instant instant, int i, DateTimeUnit.TimeBased unit) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return minus(instant, i, unit);
    }

    public static final Instant minus(Instant instant, long j, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        if (j != Long.MIN_VALUE) {
            return InstantJvmKt.plus(instant, -j, unit, timeZone);
        }
        return InstantJvmKt.plus(InstantJvmKt.plus(instant, -(j + 1), unit, timeZone), 1, unit, timeZone);
    }

    public static final Instant minus(Instant instant, long j, DateTimeUnit.TimeBased unit) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (j != Long.MIN_VALUE) {
            return InstantJvmKt.plus(instant, -j, unit);
        }
        return plus(InstantJvmKt.plus(instant, -(j + 1), unit), 1, unit);
    }

    public static final long minus(Instant instant, Instant other, DateTimeUnit unit, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        return InstantJvmKt.until(other, instant, unit, timeZone);
    }

    public static final long minus(Instant instant, Instant other, DateTimeUnit.TimeBased unit) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(unit, "unit");
        return until(other, instant, unit);
    }

    public static /* synthetic */ String format$default(Instant instant, DateTimeFormat dateTimeFormat, UtcOffset utcOffset, int i, Object obj) {
        if ((i & 2) != 0) {
            utcOffset = UtcOffset.Companion.getZERO();
        }
        return format(instant, dateTimeFormat, utcOffset);
    }

    public static final String format(final Instant instant, DateTimeFormat<DateTimeComponents> format, final UtcOffset offset) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(offset, "offset");
        return DateTimeComponentsKt.format(format, new Function1<DateTimeComponents, Unit>() { // from class: kotlinx.datetime.InstantKt$format$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DateTimeComponents dateTimeComponents) {
                invoke2(dateTimeComponents);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(DateTimeComponents format2) {
                Intrinsics.checkNotNullParameter(format2, "$this$format");
                format2.setDateTimeOffset(Instant.this, offset);
            }
        });
    }
}
