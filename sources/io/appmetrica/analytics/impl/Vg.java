package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;
/* loaded from: classes4.dex */
public final class Vg implements RemoteConfigMetaInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f675a;
    public final long b;

    public Vg(long j, long j2) {
        this.f675a = j;
        this.b = j2;
    }

    public final Vg a(long j, long j2) {
        return new Vg(j, j2);
    }

    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Vg) {
            Vg vg = (Vg) obj;
            return this.f675a == vg.f675a && this.b == vg.b;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getFirstSendTime() {
        return this.f675a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getLastUpdateTime() {
        return this.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.f675a) * 31);
    }

    public final String toString() {
        return "RemoteConfigMetaInfoModel(firstSendTime=" + this.f675a + ", lastUpdateTime=" + this.b + ')';
    }

    public final long a() {
        return this.f675a;
    }

    public static Vg a(Vg vg, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = vg.f675a;
        }
        if ((i & 2) != 0) {
            j2 = vg.b;
        }
        vg.getClass();
        return new Vg(j, j2);
    }
}
