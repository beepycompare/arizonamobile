package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.NativeProtocol;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.time.ComparableTimeMark;
import kotlin.time.TimeSource;
/* compiled from: TimeSources.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b'\u0018\u00002\u00020\u0001:\u0001\u0012B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\tH¤\u0080\u0004J\n\u0010\u000f\u001a\u00020\tH\u0082\u0080\u0004J\n\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0084\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\t8BX\u0082\u0084\n¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fÊ\u0001\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016Ê\u0001\u0010\b\u0017\u0012\f\b\u0018\u0012\b\b\fJ\u0004\b\t0\u0019¨\u0006\u0013"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "<init>", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "read", "", "zero", "getZero", "()J", "zero$delegate", "Lkotlin/Lazy;", "adjustedRead", "markNow", "Lkotlin/time/ComparableTimeMark;", "LongTimeMark", "kotlin-stdlib", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/time/ExperimentalTime;"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;
    private final Lazy zero$delegate;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract long read();

    public AbstractLongTimeSource(DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.unit = unit;
        this.zero$delegate = LazyKt.lazy(new Function0() { // from class: kotlin.time.AbstractLongTimeSource$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                long read;
                read = AbstractLongTimeSource.this.read();
                return Long.valueOf(read);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DurationUnit getUnit() {
        return this.unit;
    }

    private final long getZero() {
        return ((Number) this.zero$delegate.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long adjustedRead() {
        return read() - getZero();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TimeSources.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u00020\u0007H\u0096\u0080\u0004¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0082\u0004¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010\u0016\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0018H\u0096\u0082\u0004J\n\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004J\n\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001d"}, d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", TypedValues.CycleType.S_WAVE_OFFSET, "Lkotlin/time/Duration;", "<init>", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "plus", TypedValues.TransitionType.S_DURATION, "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "minus", "other", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "equals", "", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class LongTimeMark implements ComparableTimeMark {
        private final long offset;
        private final long startedAt;
        private final AbstractLongTimeSource timeSource;

        public /* synthetic */ LongTimeMark(long j, AbstractLongTimeSource abstractLongTimeSource, long j2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, abstractLongTimeSource, j2);
        }

        private LongTimeMark(long j, AbstractLongTimeSource timeSource, long j2) {
            Intrinsics.checkNotNullParameter(timeSource, "timeSource");
            this.startedAt = j;
            this.timeSource = timeSource;
            this.offset = j2;
        }

        @Override // kotlin.time.ComparableTimeMark, java.lang.Comparable
        public /* bridge */ int compareTo(ComparableTimeMark comparableTimeMark) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
        }

        @Override // kotlin.time.TimeMark
        public /* bridge */ boolean hasNotPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        public /* bridge */ boolean hasPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasPassedNow(this);
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* renamed from: minus-LRDsOJo */
        public /* bridge */ ComparableTimeMark mo11281minusLRDsOJo(long j) {
            return ComparableTimeMark.DefaultImpls.m11285minusLRDsOJo(this, j);
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: elapsedNow-UwyO8pc */
        public long mo11280elapsedNowUwyO8pc() {
            return Duration.m11320minusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.timeSource.adjustedRead(), this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* renamed from: plus-LRDsOJo */
        public ComparableTimeMark mo11283plusLRDsOJo(long j) {
            DurationUnit unit = this.timeSource.getUnit();
            if (Duration.m11317isInfiniteimpl(j)) {
                return new LongTimeMark(LongSaturatedMathKt.m11399saturatingAddNuflL3o(this.startedAt, unit, j), this.timeSource, Duration.Companion.m11387getZEROUwyO8pc(), null);
            }
            long m11335truncateToUwyO8pc$kotlin_stdlib = Duration.m11335truncateToUwyO8pc$kotlin_stdlib(j, unit);
            long m11321plusLRDsOJo = Duration.m11321plusLRDsOJo(Duration.m11320minusLRDsOJo(j, m11335truncateToUwyO8pc$kotlin_stdlib), this.offset);
            long m11399saturatingAddNuflL3o = LongSaturatedMathKt.m11399saturatingAddNuflL3o(this.startedAt, unit, m11335truncateToUwyO8pc$kotlin_stdlib);
            long m11335truncateToUwyO8pc$kotlin_stdlib2 = Duration.m11335truncateToUwyO8pc$kotlin_stdlib(m11321plusLRDsOJo, unit);
            long m11399saturatingAddNuflL3o2 = LongSaturatedMathKt.m11399saturatingAddNuflL3o(m11399saturatingAddNuflL3o, unit, m11335truncateToUwyO8pc$kotlin_stdlib2);
            long m11320minusLRDsOJo = Duration.m11320minusLRDsOJo(m11321plusLRDsOJo, m11335truncateToUwyO8pc$kotlin_stdlib2);
            long m11305getInWholeNanosecondsimpl = Duration.m11305getInWholeNanosecondsimpl(m11320minusLRDsOJo);
            if (m11399saturatingAddNuflL3o2 != 0 && m11305getInWholeNanosecondsimpl != 0 && (m11399saturatingAddNuflL3o2 ^ m11305getInWholeNanosecondsimpl) < 0) {
                long duration = DurationKt.toDuration(MathKt.getSign(m11305getInWholeNanosecondsimpl), unit);
                m11399saturatingAddNuflL3o2 = LongSaturatedMathKt.m11399saturatingAddNuflL3o(m11399saturatingAddNuflL3o2, unit, duration);
                m11320minusLRDsOJo = Duration.m11320minusLRDsOJo(m11320minusLRDsOJo, duration);
            }
            if ((1 | (m11399saturatingAddNuflL3o2 - 1)) == Long.MAX_VALUE) {
                m11320minusLRDsOJo = Duration.Companion.m11387getZEROUwyO8pc();
            }
            return new LongTimeMark(m11399saturatingAddNuflL3o2, this.timeSource, m11320minusLRDsOJo, null);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* renamed from: minus-UwyO8pc */
        public long mo11282minusUwyO8pc(ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (other instanceof LongTimeMark) {
                LongTimeMark longTimeMark = (LongTimeMark) other;
                if (Intrinsics.areEqual(this.timeSource, longTimeMark.timeSource)) {
                    return Duration.m11321plusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.startedAt, longTimeMark.startedAt, this.timeSource.getUnit()), Duration.m11320minusLRDsOJo(this.offset, longTimeMark.offset));
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object obj) {
            return (obj instanceof LongTimeMark) && Intrinsics.areEqual(this.timeSource, ((LongTimeMark) obj).timeSource) && Duration.m11297equalsimpl0(mo11282minusUwyO8pc((ComparableTimeMark) obj), Duration.Companion.m11387getZEROUwyO8pc());
        }

        @Override // kotlin.time.ComparableTimeMark
        public int hashCode() {
            return (Duration.m11313hashCodeimpl(this.offset) * 37) + Long.hashCode(this.startedAt);
        }

        public String toString() {
            return "LongTimeMark(" + this.startedAt + DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + ((Object) Duration.m11332toStringimpl(this.offset)) + ", " + this.timeSource + ')';
        }
    }

    @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
    public ComparableTimeMark markNow() {
        return new LongTimeMark(adjustedRead(), this, Duration.Companion.m11387getZEROUwyO8pc(), null);
    }
}
