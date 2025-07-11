package io.appmetrica.analytics.coreutils.internal.services;

import androidx.media3.exoplayer.upstream.CmcdData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002HÆ\u0003J\t\u0010\u0004\u001a\u00020\u0002HÆ\u0003J\u001d\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001J\t\u0010\t\u001a\u00020\bHÖ\u0001J\t\u0010\u000b\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0010\u001a\u0004\b\u0014\u0010\u0012¨\u0006\u0017"}, d2 = {"Lio/appmetrica/analytics/coreutils/internal/services/UtilityServiceConfiguration;", "", "", "component1", "component2", "initialConfigTime", "lastUpdateConfigTime", "copy", "", "toString", "", "hashCode", "other", "", "equals", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "J", "getInitialConfigTime", "()J", "b", "getLastUpdateConfigTime", "<init>", "(JJ)V", "core-utils_release"}, k = 1, mv = {1, 6, 0})
/* loaded from: classes4.dex */
public final class UtilityServiceConfiguration {

    /* renamed from: a  reason: collision with root package name */
    private final long f284a;
    private final long b;

    public UtilityServiceConfiguration() {
        this(0L, 0L, 3, null);
    }

    public static /* synthetic */ UtilityServiceConfiguration copy$default(UtilityServiceConfiguration utilityServiceConfiguration, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = utilityServiceConfiguration.f284a;
        }
        if ((i & 2) != 0) {
            j2 = utilityServiceConfiguration.b;
        }
        return utilityServiceConfiguration.copy(j, j2);
    }

    public final long component1() {
        return this.f284a;
    }

    public final long component2() {
        return this.b;
    }

    public final UtilityServiceConfiguration copy(long j, long j2) {
        return new UtilityServiceConfiguration(j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UtilityServiceConfiguration) {
            UtilityServiceConfiguration utilityServiceConfiguration = (UtilityServiceConfiguration) obj;
            return this.f284a == utilityServiceConfiguration.f284a && this.b == utilityServiceConfiguration.b;
        }
        return false;
    }

    public final long getInitialConfigTime() {
        return this.f284a;
    }

    public final long getLastUpdateConfigTime() {
        return this.b;
    }

    public int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.f284a) * 31);
    }

    public String toString() {
        return "UtilityServiceConfiguration(initialConfigTime=" + this.f284a + ", lastUpdateConfigTime=" + this.b + ')';
    }

    public UtilityServiceConfiguration(long j, long j2) {
        this.f284a = j;
        this.b = j2;
    }

    public /* synthetic */ UtilityServiceConfiguration(long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? 0L : j2);
    }
}
