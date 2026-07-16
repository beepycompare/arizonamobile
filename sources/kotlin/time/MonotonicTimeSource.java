package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.time.TimeSource;
/* compiled from: MonoTimeSource.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u00020\u0005H\u0082\u0080\u0004J\n\u0010\u0007\u001a\u00020\bH\u0096\u0080\u0004J\u0011\u0010\t\u001a\u00020\nH\u0096\u0080\u0004¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0086\u0080\u0004¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0086\u0080\u0004¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u000eH\u0086\u0080\u0004¢\u0006\u0004\b\u0019\u0010\u0016R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000Ê\u0001\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001d¨\u0006\u001a"}, d2 = {"Lkotlin/time/MonotonicTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "<init>", "()V", "zero", "", "read", "toString", "", "markNow", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "elapsedFrom", "Lkotlin/time/Duration;", "timeMark", "elapsedFrom-6eNON_k", "(J)J", "differenceBetween", "one", "another", "differenceBetween-fRLX17w", "(JJ)J", "adjustReading", TypedValues.TransitionType.S_DURATION, "adjustReading-6QKq23U", "kotlin-stdlib", "Lkotlin/SinceKotlin;", NativeProtocol.PLATFORM_PROVIDER_VERSION_COLUMN, "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MonotonicTimeSource implements TimeSource.WithComparableMarks {
    public static final MonotonicTimeSource INSTANCE = new MonotonicTimeSource();
    private static final long zero = System.nanoTime();

    private MonotonicTimeSource() {
    }

    @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
    public /* bridge */ /* synthetic */ ComparableTimeMark markNow() {
        return TimeSource.Monotonic.ValueTimeMark.m11393boximpl(m11387markNowz9LOYto());
    }

    @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
    public /* bridge */ /* synthetic */ TimeMark markNow() {
        return TimeSource.Monotonic.ValueTimeMark.m11393boximpl(m11387markNowz9LOYto());
    }

    private final long read() {
        return System.nanoTime() - zero;
    }

    public String toString() {
        return "TimeSource(System.nanoTime())";
    }

    /* renamed from: markNow-z9LOYto  reason: not valid java name */
    public long m11387markNowz9LOYto() {
        return TimeSource.Monotonic.ValueTimeMark.m11396constructorimpl(read());
    }

    /* renamed from: elapsedFrom-6eNON_k  reason: not valid java name */
    public final long m11386elapsedFrom6eNON_k(long j) {
        return LongSaturatedMathKt.saturatingDiff(read(), j, DurationUnit.NANOSECONDS);
    }

    /* renamed from: differenceBetween-fRLX17w  reason: not valid java name */
    public final long m11385differenceBetweenfRLX17w(long j, long j2) {
        return LongSaturatedMathKt.saturatingOriginsDiff(j, j2, DurationUnit.NANOSECONDS);
    }

    /* renamed from: adjustReading-6QKq23U  reason: not valid java name */
    public final long m11384adjustReading6QKq23U(long j, long j2) {
        return TimeSource.Monotonic.ValueTimeMark.m11396constructorimpl(LongSaturatedMathKt.m11382saturatingAddNuflL3o(j, DurationUnit.NANOSECONDS, j2));
    }
}
