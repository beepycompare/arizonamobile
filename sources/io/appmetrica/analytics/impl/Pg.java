package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;
/* loaded from: classes3.dex */
public final class Pg implements RemoteConfigMetaInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f637a;
    public final long b;

    public Pg(long j, long j2) {
        this.f637a = j;
        this.b = j2;
    }

    public final Pg a(long j, long j2) {
        return new Pg(j, j2);
    }

    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Pg) {
            Pg pg = (Pg) obj;
            return this.f637a == pg.f637a && this.b == pg.b;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getFirstSendTime() {
        return this.f637a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getLastUpdateTime() {
        return this.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.f637a) * 31);
    }

    public final String toString() {
        return "RemoteConfigMetaInfoModel(firstSendTime=" + this.f637a + ", lastUpdateTime=" + this.b + ')';
    }

    public final long a() {
        return this.f637a;
    }

    public static Pg a(Pg pg, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = pg.f637a;
        }
        if ((i & 2) != 0) {
            j2 = pg.b;
        }
        pg.getClass();
        return new Pg(j, j2);
    }
}
