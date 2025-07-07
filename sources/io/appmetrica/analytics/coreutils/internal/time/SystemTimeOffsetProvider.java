package io.appmetrica.analytics.coreutils.internal.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fB\t\b\u0016¢\u0006\u0004\b\u000e\u0010\u0010J\u0016\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\n\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0016\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0011"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/time/SystemTimeOffsetProvider;", "", "", "timestamp", "Ljava/util/concurrent/TimeUnit;", "timeUnit", "elapsedRealtimeOffsetInSeconds", "timestampInUnit", "elapsedRealtimeOffset", "systemNanoTimeOffsetInNanos", "systemNanoTimeOffsetInSeconds", "offsetInSecondsIfNotZero", "Lio/appmetrica/analytics/coreutils/internal/time/SystemTimeProvider;", "mSystemTimeProvider", "<init>", "(Lio/appmetrica/analytics/coreutils/internal/time/SystemTimeProvider;)V", "()V", "core-utils_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class SystemTimeOffsetProvider {

    /* renamed from: a  reason: collision with root package name */
    private final SystemTimeProvider f294a;

    public SystemTimeOffsetProvider(SystemTimeProvider systemTimeProvider) {
        this.f294a = systemTimeProvider;
    }

    public final long elapsedRealtimeOffset(long j, TimeUnit timeUnit) {
        return this.f294a.elapsedRealtime() - timeUnit.toMillis(j);
    }

    public final long elapsedRealtimeOffsetInSeconds(long j, TimeUnit timeUnit) {
        return TimeUnit.MILLISECONDS.toSeconds(elapsedRealtimeOffset(j, timeUnit));
    }

    public final long offsetInSecondsIfNotZero(long j, TimeUnit timeUnit) {
        if (j == 0) {
            return 0L;
        }
        return this.f294a.currentTimeSeconds() - timeUnit.toSeconds(j);
    }

    public final long systemNanoTimeOffsetInNanos(long j, TimeUnit timeUnit) {
        return this.f294a.systemNanoTime() - timeUnit.toNanos(j);
    }

    public final long systemNanoTimeOffsetInSeconds(long j, TimeUnit timeUnit) {
        return TimeUnit.NANOSECONDS.toSeconds(systemNanoTimeOffsetInNanos(j, timeUnit));
    }

    public SystemTimeOffsetProvider() {
        this(new SystemTimeProvider());
    }
}
