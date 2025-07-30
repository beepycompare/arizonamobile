package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
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
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH$J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "<init>", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "read", "", "zero", "getZero", "()J", "zero$delegate", "Lkotlin/Lazy;", "adjustedRead", "markNow", "Lkotlin/time/ComparableTimeMark;", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
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
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0001H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001d"}, d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", TypedValues.CycleType.S_WAVE_OFFSET, "Lkotlin/time/Duration;", "<init>", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "plus", TypedValues.TransitionType.S_DURATION, "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "minus", "other", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "equals", "", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
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

        @Override // java.lang.Comparable
        public int compareTo(ComparableTimeMark comparableTimeMark) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasNotPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: minus-LRDsOJo */
        public ComparableTimeMark mo9821minusLRDsOJo(long j) {
            return ComparableTimeMark.DefaultImpls.m9825minusLRDsOJo(this, j);
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: elapsedNow-UwyO8pc */
        public long mo9820elapsedNowUwyO8pc() {
            return Duration.m9858minusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.timeSource.adjustedRead(), this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: plus-LRDsOJo */
        public ComparableTimeMark mo9823plusLRDsOJo(long j) {
            DurationUnit unit = this.timeSource.getUnit();
            if (Duration.m9855isInfiniteimpl(j)) {
                return new LongTimeMark(LongSaturatedMathKt.m9933saturatingAddNuflL3o(this.startedAt, unit, j), this.timeSource, Duration.Companion.m9921getZEROUwyO8pc(), null);
            }
            long m9873truncateToUwyO8pc$kotlin_stdlib = Duration.m9873truncateToUwyO8pc$kotlin_stdlib(j, unit);
            long m9859plusLRDsOJo = Duration.m9859plusLRDsOJo(Duration.m9858minusLRDsOJo(j, m9873truncateToUwyO8pc$kotlin_stdlib), this.offset);
            long m9933saturatingAddNuflL3o = LongSaturatedMathKt.m9933saturatingAddNuflL3o(this.startedAt, unit, m9873truncateToUwyO8pc$kotlin_stdlib);
            long m9873truncateToUwyO8pc$kotlin_stdlib2 = Duration.m9873truncateToUwyO8pc$kotlin_stdlib(m9859plusLRDsOJo, unit);
            long m9933saturatingAddNuflL3o2 = LongSaturatedMathKt.m9933saturatingAddNuflL3o(m9933saturatingAddNuflL3o, unit, m9873truncateToUwyO8pc$kotlin_stdlib2);
            long m9858minusLRDsOJo = Duration.m9858minusLRDsOJo(m9859plusLRDsOJo, m9873truncateToUwyO8pc$kotlin_stdlib2);
            long m9843getInWholeNanosecondsimpl = Duration.m9843getInWholeNanosecondsimpl(m9858minusLRDsOJo);
            if (m9933saturatingAddNuflL3o2 != 0 && m9843getInWholeNanosecondsimpl != 0 && (m9933saturatingAddNuflL3o2 ^ m9843getInWholeNanosecondsimpl) < 0) {
                long duration = DurationKt.toDuration(MathKt.getSign(m9843getInWholeNanosecondsimpl), unit);
                m9933saturatingAddNuflL3o2 = LongSaturatedMathKt.m9933saturatingAddNuflL3o(m9933saturatingAddNuflL3o2, unit, duration);
                m9858minusLRDsOJo = Duration.m9858minusLRDsOJo(m9858minusLRDsOJo, duration);
            }
            if ((1 | (m9933saturatingAddNuflL3o2 - 1)) == Long.MAX_VALUE) {
                m9858minusLRDsOJo = Duration.Companion.m9921getZEROUwyO8pc();
            }
            return new LongTimeMark(m9933saturatingAddNuflL3o2, this.timeSource, m9858minusLRDsOJo, null);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* renamed from: minus-UwyO8pc */
        public long mo9822minusUwyO8pc(ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (other instanceof LongTimeMark) {
                LongTimeMark longTimeMark = (LongTimeMark) other;
                if (Intrinsics.areEqual(this.timeSource, longTimeMark.timeSource)) {
                    return Duration.m9859plusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.startedAt, longTimeMark.startedAt, this.timeSource.getUnit()), Duration.m9858minusLRDsOJo(this.offset, longTimeMark.offset));
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object obj) {
            return (obj instanceof LongTimeMark) && Intrinsics.areEqual(this.timeSource, ((LongTimeMark) obj).timeSource) && Duration.m9835equalsimpl0(mo9822minusUwyO8pc((ComparableTimeMark) obj), Duration.Companion.m9921getZEROUwyO8pc());
        }

        @Override // kotlin.time.ComparableTimeMark
        public int hashCode() {
            return (Duration.m9851hashCodeimpl(this.offset) * 37) + Long.hashCode(this.startedAt);
        }

        public String toString() {
            return "LongTimeMark(" + this.startedAt + DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + ((Object) Duration.m9870toStringimpl(this.offset)) + ", " + this.timeSource + ')';
        }
    }

    @Override // kotlin.time.TimeSource
    public ComparableTimeMark markNow() {
        return new LongTimeMark(adjustedRead(), this, Duration.Companion.m9921getZEROUwyO8pc(), null);
    }
}
