package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;
/* loaded from: classes5.dex */
public final class Lg implements RemoteConfigMetaInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f571a;
    public final long b;

    public Lg(long j, long j2) {
        this.f571a = j;
        this.b = j2;
    }

    public final Lg a(long j, long j2) {
        return new Lg(j, j2);
    }

    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Lg) {
            Lg lg = (Lg) obj;
            return this.f571a == lg.f571a && this.b == lg.b;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getFirstSendTime() {
        return this.f571a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getLastUpdateTime() {
        return this.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.f571a) * 31);
    }

    public final String toString() {
        return "RemoteConfigMetaInfoModel(firstSendTime=" + this.f571a + ", lastUpdateTime=" + this.b + ')';
    }

    public final long a() {
        return this.f571a;
    }

    public static Lg a(Lg lg, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = lg.f571a;
        }
        if ((i & 2) != 0) {
            j2 = lg.b;
        }
        lg.getClass();
        return new Lg(j, j2);
    }
}
