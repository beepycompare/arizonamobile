package io.appmetrica.analytics.locationapi.internal;

import androidx.media3.exoplayer.upstream.CmcdData;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r¨\u0006\u0014"}, d2 = {"Lio/appmetrica/analytics/locationapi/internal/CacheArguments;", "", "", "toString", "other", "", "equals", "", "hashCode", "", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "J", "getRefreshPeriod", "()J", "refreshPeriod", "b", "getOutdatedTimeInterval", "outdatedTimeInterval", "<init>", "(JJ)V", "location-api_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class CacheArguments {

    /* renamed from: a  reason: collision with root package name */
    private final long f1199a;
    private final long b;

    public CacheArguments() {
        this(0L, 0L, 3, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (Intrinsics.areEqual(CacheArguments.class, obj != null ? obj.getClass() : null)) {
            if (obj != null) {
                CacheArguments cacheArguments = (CacheArguments) obj;
                return this.f1199a == cacheArguments.f1199a && this.b == cacheArguments.b;
            }
            throw new NullPointerException("null cannot be cast to non-null type io.appmetrica.analytics.locationapi.internal.CacheArguments");
        }
        return false;
    }

    public final long getOutdatedTimeInterval() {
        return this.b;
    }

    public final long getRefreshPeriod() {
        return this.f1199a;
    }

    public int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.f1199a) * 31);
    }

    public String toString() {
        return "CacheArguments(refreshPeriod=" + this.f1199a + ", outdatedTimeInterval=" + this.b + ')';
    }

    public CacheArguments(long j, long j2) {
        this.f1199a = j;
        this.b = j2;
    }

    public /* synthetic */ CacheArguments(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? TimeUnit.SECONDS.toMillis(10L) : j, (i & 2) != 0 ? TimeUnit.MINUTES.toMillis(2L) : j2);
    }
}
