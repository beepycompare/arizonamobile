package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;
/* loaded from: classes5.dex */
public final class Kg implements RemoteConfigMetaInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f664a;
    public final long b;

    public Kg(long j, long j2) {
        this.f664a = j;
        this.b = j2;
    }

    public final Kg a(long j, long j2) {
        return new Kg(j, j2);
    }

    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Kg) {
            Kg kg = (Kg) obj;
            return this.f664a == kg.f664a && this.b == kg.b;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getFirstSendTime() {
        return this.f664a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getLastUpdateTime() {
        return this.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.f664a) * 31);
    }

    public final String toString() {
        return "RemoteConfigMetaInfoModel(firstSendTime=" + this.f664a + ", lastUpdateTime=" + this.b + ')';
    }

    public final long a() {
        return this.f664a;
    }

    public static Kg a(Kg kg, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = kg.f664a;
        }
        if ((i & 2) != 0) {
            j2 = kg.b;
        }
        kg.getClass();
        return new Kg(j, j2);
    }
}
