package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import kotlin.Metadata;
/* compiled from: LazyLayoutPrefetchState.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0002J\u0010\u0010\u000b\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\r\u001a\u00020\f2\b\u0010\n\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u000e\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\fJ\u0018\u0010\u0011\u001a\u00020\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0010\u001a\u00020\fR\u001c\u0010\u0003\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", "", "()V", "averagesByContentType", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/foundation/lazy/layout/Averages;", "lastUsedAverage", "lastUsedContentType", "overallAverage", "getAverage", "contentType", "getCompositionTimeNanos", "", "getMeasureTimeNanos", "saveCompositionTime", "", "timeNanos", "saveMeasureTime", "foundation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PrefetchMetrics {
    public static final int $stable = 8;
    private Averages lastUsedAverage;
    private Object lastUsedContentType;
    private final Averages overallAverage = new Averages();
    private final MutableScatterMap<Object, Averages> averagesByContentType = ScatterMapKt.mutableScatterMapOf();

    private final Averages getAverage(Object obj) {
        Averages averages = this.lastUsedAverage;
        if (this.lastUsedContentType != obj || averages == null) {
            MutableScatterMap<Object, Averages> mutableScatterMap = this.averagesByContentType;
            Averages averages2 = mutableScatterMap.get(obj);
            if (averages2 == null) {
                averages2 = this.overallAverage.copy();
                mutableScatterMap.set(obj, averages2);
            }
            Averages averages3 = averages2;
            this.lastUsedContentType = obj;
            this.lastUsedAverage = averages3;
            return averages3;
        }
        return averages;
    }

    public final long getCompositionTimeNanos(Object obj) {
        return getAverage(obj).getCompositionTimeNanos();
    }

    public final long getMeasureTimeNanos(Object obj) {
        return getAverage(obj).getMeasureTimeNanos();
    }

    public final void saveCompositionTime(Object obj, long j) {
        this.overallAverage.saveCompositionTimeNanos(j);
        getAverage(obj).saveCompositionTimeNanos(j);
    }

    public final void saveMeasureTime(Object obj, long j) {
        this.overallAverage.saveMeasureTimeNanos(j);
        getAverage(obj).saveMeasureTimeNanos(j);
    }
}
