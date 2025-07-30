package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;
/* loaded from: classes4.dex */
public final class Xg implements RemoteConfigMetaInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f720a;
    public final long b;

    public Xg(long j, long j2) {
        this.f720a = j;
        this.b = j2;
    }

    public final Xg a(long j, long j2) {
        return new Xg(j, j2);
    }

    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Xg) {
            Xg xg = (Xg) obj;
            return this.f720a == xg.f720a && this.b == xg.b;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getFirstSendTime() {
        return this.f720a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getLastUpdateTime() {
        return this.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.f720a) * 31);
    }

    public final String toString() {
        return "RemoteConfigMetaInfoModel(firstSendTime=" + this.f720a + ", lastUpdateTime=" + this.b + ')';
    }

    public final long a() {
        return this.f720a;
    }

    public static Xg a(Xg xg, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = xg.f720a;
        }
        if ((i & 2) != 0) {
            j2 = xg.b;
        }
        xg.getClass();
        return new Xg(j, j2);
    }
}
