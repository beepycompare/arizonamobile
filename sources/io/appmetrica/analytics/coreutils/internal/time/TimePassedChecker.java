package io.appmetrica.analytics.coreutils.internal.time;

import kotlin.Metadata;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0011\b\u0001\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u000e\u0010\u000fB\t\b\u0016¢\u0006\u0004\b\u000e\u0010\u0010J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005¨\u0006\u0011"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/time/TimePassedChecker;", "", "", "lastTimeSeconds", "intervalSeconds", "", "tag", "", "didTimePassSeconds", "lastTimeMillis", "intervalMillis", "didTimePassMillis", "Lio/appmetrica/analytics/coreutils/internal/time/TimeProvider;", "mTimeProvider", "<init>", "(Lio/appmetrica/analytics/coreutils/internal/time/TimeProvider;)V", "()V", "core-utils_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class TimePassedChecker {

    /* renamed from: a  reason: collision with root package name */
    private final TimeProvider f295a;

    public TimePassedChecker(TimeProvider timeProvider) {
        this.f295a = timeProvider;
    }

    public final boolean didTimePassMillis(long j, long j2, String str) {
        long currentTimeMillis = this.f295a.currentTimeMillis();
        return currentTimeMillis < j || currentTimeMillis - j >= j2;
    }

    public final boolean didTimePassSeconds(long j, long j2, String str) {
        long currentTimeSeconds = this.f295a.currentTimeSeconds();
        return currentTimeSeconds < j || currentTimeSeconds - j >= j2;
    }

    public TimePassedChecker() {
        this(new SystemTimeProvider());
    }
}
