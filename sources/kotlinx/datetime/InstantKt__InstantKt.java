package kotlinx.datetime;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.media3.common.C;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Instant;
import kotlinx.datetime.DateTimeUnit;
import kotlinx.datetime.format.DateTimeComponents;
import kotlinx.datetime.format.DateTimeComponentsKt;
import kotlinx.datetime.format.DateTimeFormat;
import kotlinx.datetime.internal.MathKt;
/* compiled from: Instant.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u001a\u001a\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f\u001a\u001a\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u001a\u0010\u0012\u001a\u00020\u0013*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f\u001a\u001a\u0010\u0014\u001a\u00020\u0013*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f\u001a\u001a\u0010\u0015\u001a\u00020\u0013*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f\u001a\u001a\u0010\b\u001a\u00020\n*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f\u001a\u001c\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\fH\u0007\u001a\u0014\u0010\u0017\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\u001a\u0010\u0017\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u001a\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011\u001a\"\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f\u001a\u001a\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\"\u0010\b\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f\u001a\u001a\u0010\b\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011\u001a\"\u0010\u0005\u001a\u00020\u0019*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u001b\"\u000e\u0010\u001c\u001a\u00020\u000eX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001d\u001a\u00020\u000eX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"parse", "Lkotlin/time/Instant;", "Lkotlin/time/Instant$Companion;", "input", "", "format", "Lkotlinx/datetime/format/DateTimeFormat;", "Lkotlinx/datetime/format/DateTimeComponents;", "minus", TypedValues.CycleType.S_WAVE_PERIOD, "Lkotlinx/datetime/DateTimePeriod;", RemoteConfigConstants.RequestFieldKey.TIME_ZONE, "Lkotlinx/datetime/TimeZone;", "until", "", "other", "unit", "Lkotlinx/datetime/DateTimeUnit$TimeBased;", "daysUntil", "", "monthsUntil", "yearsUntil", "Lkotlinx/datetime/DateTimeUnit;", "plus", "value", "", TypedValues.CycleType.S_WAVE_OFFSET, "Lkotlinx/datetime/UtcOffset;", "DISTANT_PAST_SECONDS", "DISTANT_FUTURE_SECONDS", "kotlinx-datetime"}, k = 5, mv = {2, 1, 0}, xi = 48, xs = "kotlinx/datetime/InstantKt")
/* loaded from: classes5.dex */
public final /* synthetic */ class InstantKt__InstantKt {
    public static final Instant parse(Instant.Companion companion, CharSequence input, DateTimeFormat<DateTimeComponents> format) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(format, "format");
        try {
            return DateTimeComponents.toInstantUsingOffset$default(format.parse(input), null, 1, null);
        } catch (IllegalArgumentException e) {
            throw new DateTimeFormatException("Failed to parse an instant from '" + ((Object) input) + '\'', e);
        }
    }

    public static final Instant minus(Instant instant, DateTimePeriod period, TimeZone timeZone) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(period, "period");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        if (period.getTotalNanoseconds$kotlinx_datetime() != Long.MIN_VALUE) {
            return InstantJvmKt.plus(instant, DateTimePeriodKt.buildDateTimePeriod(-period.getTotalMonths$kotlinx_datetime(), -period.getDays(), -period.getTotalNanoseconds$kotlinx_datetime()), timeZone);
        }
        return InstantKt.plus(InstantJvmKt.plus(instant, DateTimePeriodKt.buildDateTimePeriod(-period.getTotalMonths$kotlinx_datetime(), -period.getDays(), -(period.getTotalNanoseconds$kotlinx_datetime() + 1)), timeZone), 1, DateTimeUnit.Companion.getNANOSECOND());
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
        return InstantKt.minus(instant, i, unit);
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
        return InstantKt.plus(InstantJvmKt.plus(instant, -(j + 1), unit), 1, unit);
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
        return InstantKt.until(other, instant, unit);
    }

    public static /* synthetic */ String format$default(Instant instant, DateTimeFormat dateTimeFormat, UtcOffset utcOffset, int i, Object obj) {
        if ((i & 2) != 0) {
            utcOffset = UtcOffset.Companion.getZERO();
        }
        return InstantKt.format(instant, dateTimeFormat, utcOffset);
    }

    public static final String format(final Instant instant, DateTimeFormat<DateTimeComponents> format, final UtcOffset offset) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(offset, "offset");
        return DateTimeComponentsKt.format(format, new Function1() { // from class: kotlinx.datetime.InstantKt__InstantKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit format$lambda$2$InstantKt__InstantKt;
                format$lambda$2$InstantKt__InstantKt = InstantKt__InstantKt.format$lambda$2$InstantKt__InstantKt(Instant.this, offset, (DateTimeComponents) obj);
                return format$lambda$2$InstantKt__InstantKt;
            }
        });
    }

    public static final Unit format$lambda$2$InstantKt__InstantKt(Instant instant, UtcOffset utcOffset, DateTimeComponents format) {
        Intrinsics.checkNotNullParameter(format, "$this$format");
        format.setDateTimeOffset(instant, utcOffset);
        return Unit.INSTANCE;
    }
}
