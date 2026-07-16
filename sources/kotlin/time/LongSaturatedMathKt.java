package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
/* compiled from: longSaturatedMath.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\u001a)\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0004\b\u0007\u0010\b\u001a)\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0004\b\u000b\u0010\f\u001a)\u0010\r\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0082\u0080\u0004¢\u0006\u0004\b\u000e\u0010\b\u001a\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0010\u001a'\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0080\u0080\u0004¢\u0006\u0002\u0010\u0014\u001a'\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0080\u0080\u0004¢\u0006\u0002\u0010\u0014\u001a'\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0014\u001a\u000e\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\u0080\u0088\u0004¨\u0006\u001d"}, d2 = {"saturatingAdd", "", "value", "unit", "Lkotlin/time/DurationUnit;", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "checkInfiniteSumDefined", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "infinityOfSign", "(J)J", "saturatingDiff", "valueNs", "origin", "(JJLkotlin/time/DurationUnit;)J", "saturatingOriginsDiff", "origin1", "origin2", "saturatingFiniteDiff", "value1", "value2", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LongSaturatedMathKt {
    public static final boolean isSaturated(long j) {
        return ((j - 1) | 1) == Long.MAX_VALUE;
    }

    /* renamed from: saturatingAdd-NuflL3o  reason: not valid java name */
    public static final long m11382saturatingAddNuflL3o(long j, DurationUnit unit, long j2) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        long m11314toLongimpl = Duration.m11314toLongimpl(j2, unit);
        if (((j - 1) | 1) == Long.MAX_VALUE) {
            return m11381checkInfiniteSumDefinedPjuGub4(j, j2, m11314toLongimpl);
        }
        if (((m11314toLongimpl - 1) | 1) == Long.MAX_VALUE) {
            return m11383saturatingAddInHalvesNuflL3o(j, unit, j2);
        }
        long j3 = j + m11314toLongimpl;
        return ((j ^ j3) & (m11314toLongimpl ^ j3)) < 0 ? j < 0 ? Long.MIN_VALUE : Long.MAX_VALUE : j3;
    }

    /* renamed from: checkInfiniteSumDefined-PjuGub4  reason: not valid java name */
    private static final long m11381checkInfiniteSumDefinedPjuGub4(long j, long j2, long j3) {
        if (!Duration.m11300isInfiniteimpl(j2) || (j ^ j3) >= 0) {
            return j;
        }
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    /* renamed from: saturatingAddInHalves-NuflL3o  reason: not valid java name */
    private static final long m11383saturatingAddInHalvesNuflL3o(long j, DurationUnit durationUnit, long j2) {
        long m11278divUwyO8pc = Duration.m11278divUwyO8pc(j2, 2);
        long m11314toLongimpl = Duration.m11314toLongimpl(m11278divUwyO8pc, durationUnit);
        return (1 | (m11314toLongimpl - 1)) == Long.MAX_VALUE ? m11314toLongimpl : m11382saturatingAddNuflL3o(m11382saturatingAddNuflL3o(j, durationUnit, m11278divUwyO8pc), durationUnit, Duration.m11303minusLRDsOJo(j2, m11278divUwyO8pc));
    }

    private static final long infinityOfSign(long j) {
        return j < 0 ? Duration.Companion.m11369getNEG_INFINITEUwyO8pc$kotlin_stdlib() : Duration.Companion.m11367getINFINITEUwyO8pc();
    }

    public static final long saturatingDiff(long j, long j2, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if ((1 | (j2 - 1)) == Long.MAX_VALUE) {
            return Duration.m11319unaryMinusUwyO8pc(infinityOfSign(j2));
        }
        return saturatingFiniteDiff(j, j2, unit);
    }

    public static final long saturatingOriginsDiff(long j, long j2, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (((j2 - 1) | 1) == Long.MAX_VALUE) {
            if (j == j2) {
                return Duration.Companion.m11370getZEROUwyO8pc();
            }
            return Duration.m11319unaryMinusUwyO8pc(infinityOfSign(j2));
        } else if ((1 | (j - 1)) == Long.MAX_VALUE) {
            return infinityOfSign(j);
        } else {
            return saturatingFiniteDiff(j, j2, unit);
        }
    }

    private static final long saturatingFiniteDiff(long j, long j2, DurationUnit durationUnit) {
        long j3 = j - j2;
        if (((j3 ^ j) & (~(j3 ^ j2))) < 0) {
            if (durationUnit.compareTo(DurationUnit.MILLISECONDS) < 0) {
                long convertDurationUnit = DurationUnitKt.convertDurationUnit(1L, DurationUnit.MILLISECONDS, durationUnit);
                long j4 = (j % convertDurationUnit) - (j2 % convertDurationUnit);
                Duration.Companion companion = Duration.Companion;
                return Duration.m11304plusLRDsOJo(DurationKt.toDuration((j / convertDurationUnit) - (j2 / convertDurationUnit), DurationUnit.MILLISECONDS), DurationKt.toDuration(j4, durationUnit));
            }
            return Duration.m11319unaryMinusUwyO8pc(infinityOfSign(j3));
        }
        return DurationKt.toDuration(j3, durationUnit);
    }
}
