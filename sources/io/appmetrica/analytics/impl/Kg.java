package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;
/* loaded from: classes5.dex */
public final class Kg implements RemoteConfigMetaInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f659a;
    public final long b;

    public Kg(long j, long j2) {
        this.f659a = j;
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
            return this.f659a == kg.f659a && this.b == kg.b;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getFirstSendTime() {
        return this.f659a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getLastUpdateTime() {
        return this.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.f659a) * 31);
    }

    public final String toString() {
        return "RemoteConfigMetaInfoModel(firstSendTime=" + this.f659a + ", lastUpdateTime=" + this.b + ')';
    }

    public final long a() {
        return this.f659a;
    }

    public static Kg a(Kg kg, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = kg.f659a;
        }
        if ((i & 2) != 0) {
            j2 = kg.b;
        }
        kg.getClass();
        return new Kg(j, j2);
    }
}
