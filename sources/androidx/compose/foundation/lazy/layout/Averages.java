package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
/* compiled from: LazyLayoutPrefetchState.kt */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004H\u0002J\u0006\u0010\u000f\u001a\u00020\u0000J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0014"}, d2 = {"Landroidx/compose/foundation/lazy/layout/Averages;", "", "()V", "compositionTimeNanos", "", "getCompositionTimeNanos", "()J", "setCompositionTimeNanos", "(J)V", "measureTimeNanos", "getMeasureTimeNanos", "setMeasureTimeNanos", "calculateAverageTime", "new", "current", "copy", "saveCompositionTimeNanos", "", "timeNanos", "saveMeasureTimeNanos", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
final class Averages {
    private long compositionTimeNanos;
    private long measureTimeNanos;

    public final long getCompositionTimeNanos() {
        return this.compositionTimeNanos;
    }

    public final void setCompositionTimeNanos(long j) {
        this.compositionTimeNanos = j;
    }

    public final long getMeasureTimeNanos() {
        return this.measureTimeNanos;
    }

    public final void setMeasureTimeNanos(long j) {
        this.measureTimeNanos = j;
    }

    public final void saveCompositionTimeNanos(long j) {
        this.compositionTimeNanos = calculateAverageTime(j, this.compositionTimeNanos);
    }

    public final void saveMeasureTimeNanos(long j) {
        this.measureTimeNanos = calculateAverageTime(j, this.measureTimeNanos);
    }

    public final Averages copy() {
        Averages averages = new Averages();
        averages.compositionTimeNanos = this.compositionTimeNanos;
        averages.measureTimeNanos = this.measureTimeNanos;
        return averages;
    }

    private final long calculateAverageTime(long j, long j2) {
        if (j2 == 0) {
            return j;
        }
        long j3 = 4;
        return ((j2 / j3) * 3) + (j / j3);
    }
}
