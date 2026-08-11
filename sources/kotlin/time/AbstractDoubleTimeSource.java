package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.NativeProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.ComparableTimeMark;
import kotlin.time.TimeSource;
/* compiled from: TimeSources.kt */
@Deprecated(level = DeprecationLevel.ERROR, message = "Using AbstractDoubleTimeSource is no longer recommended, use AbstractLongTimeSource instead.")
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001:\u0001\fB\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\n\u0010\b\u001a\u00020\tH¤\u0080\u0004J\n\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0084\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007Ê\u0001\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010Ê\u0001\u0002\b\u0011Ê\u0001\u0018\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\n\b\u0015\u0012\u0006\b\n0\u00168\u0017¨\u0006\r"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "<init>", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "read", "", "markNow", "Lkotlin/time/ComparableTimeMark;", "DoubleTimeMark", "kotlin-stdlib", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.3", "Lkotlin/time/ExperimentalTime;", "Lkotlin/Deprecated;", "message", "Using AbstractDoubleTimeSource is no longer recommended, use AbstractLongTimeSource instead.", FirebaseAnalytics.Param.LEVEL, "Lkotlin/DeprecationLevel;", "ERROR"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class AbstractDoubleTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;

    protected abstract double read();

    public AbstractDoubleTimeSource(DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.unit = unit;
    }

    protected final DurationUnit getUnit() {
        return this.unit;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: TimeSources.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B!\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\r\u001a\u00020\u0007H\u0096\u0080\u0004¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0007H\u0096\u0082\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u0016\u0010\u0017J\u0014\u0010\u0018\u001a\u00020\u00192\b\u0010\u0015\u001a\u0004\u0018\u00010\u001aH\u0096\u0082\u0004J\n\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004J\n\u0010\u001d\u001a\u00020\u001eH\u0096\u0080\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u001f"}, d2 = {"Lkotlin/time/AbstractDoubleTimeSource$DoubleTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractDoubleTimeSource;", TypedValues.CycleType.S_WAVE_OFFSET, "Lkotlin/time/Duration;", "<init>", "(DLkotlin/time/AbstractDoubleTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getTimeSource$annotations", "()V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "plus", TypedValues.TransitionType.S_DURATION, "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "minus", "other", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "equals", "", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class DoubleTimeMark implements ComparableTimeMark {
        private final long offset;
        private final double startedAt;
        private final AbstractDoubleTimeSource timeSource;

        public /* synthetic */ DoubleTimeMark(double d, AbstractDoubleTimeSource abstractDoubleTimeSource, long j, DefaultConstructorMarker defaultConstructorMarker) {
            this(d, abstractDoubleTimeSource, j);
        }

        private static /* synthetic */ void getTimeSource$annotations() {
        }

        private DoubleTimeMark(double d, AbstractDoubleTimeSource timeSource, long j) {
            Intrinsics.checkNotNullParameter(timeSource, "timeSource");
            this.startedAt = d;
            this.timeSource = timeSource;
            this.offset = j;
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
        /* renamed from: minus-LRDsOJo  reason: not valid java name */
        public /* bridge */ ComparableTimeMark mo11281minusLRDsOJo(long j) {
            return ComparableTimeMark.DefaultImpls.m11285minusLRDsOJo(this, j);
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: elapsedNow-UwyO8pc  reason: not valid java name */
        public long mo11280elapsedNowUwyO8pc() {
            return Duration.m11320minusLRDsOJo(DurationKt.toDuration(this.timeSource.read() - this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* renamed from: plus-LRDsOJo  reason: not valid java name */
        public ComparableTimeMark mo11283plusLRDsOJo(long j) {
            return new DoubleTimeMark(this.startedAt, this.timeSource, Duration.m11321plusLRDsOJo(this.offset, j), null);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* renamed from: minus-UwyO8pc  reason: not valid java name */
        public long mo11282minusUwyO8pc(ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if (other instanceof DoubleTimeMark) {
                DoubleTimeMark doubleTimeMark = (DoubleTimeMark) other;
                if (Intrinsics.areEqual(this.timeSource, doubleTimeMark.timeSource)) {
                    if (Duration.m11297equalsimpl0(this.offset, doubleTimeMark.offset) && Duration.m11317isInfiniteimpl(this.offset)) {
                        return Duration.Companion.m11387getZEROUwyO8pc();
                    }
                    long m11320minusLRDsOJo = Duration.m11320minusLRDsOJo(this.offset, doubleTimeMark.offset);
                    long duration = DurationKt.toDuration(this.startedAt - doubleTimeMark.startedAt, this.timeSource.getUnit());
                    return Duration.m11297equalsimpl0(duration, Duration.m11336unaryMinusUwyO8pc(m11320minusLRDsOJo)) ? Duration.Companion.m11387getZEROUwyO8pc() : Duration.m11321plusLRDsOJo(duration, m11320minusLRDsOJo);
                }
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object obj) {
            return (obj instanceof DoubleTimeMark) && Intrinsics.areEqual(this.timeSource, ((DoubleTimeMark) obj).timeSource) && Duration.m11297equalsimpl0(mo11282minusUwyO8pc((ComparableTimeMark) obj), Duration.Companion.m11387getZEROUwyO8pc());
        }

        @Override // kotlin.time.ComparableTimeMark
        public int hashCode() {
            return Duration.m11313hashCodeimpl(Duration.m11321plusLRDsOJo(DurationKt.toDuration(this.startedAt, this.timeSource.getUnit()), this.offset));
        }

        public String toString() {
            return "DoubleTimeMark(" + this.startedAt + DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + ((Object) Duration.m11332toStringimpl(this.offset)) + ", " + this.timeSource + ')';
        }
    }

    @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
    public ComparableTimeMark markNow() {
        return new DoubleTimeMark(read(), this, Duration.Companion.m11387getZEROUwyO8pc(), null);
    }
}
