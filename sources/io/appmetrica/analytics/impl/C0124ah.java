package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;
/* renamed from: io.appmetrica.analytics.impl.ah  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0124ah implements RemoteConfigMetaInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f888a;
    public final long b;

    public C0124ah(long j, long j2) {
        this.f888a = j;
        this.b = j2;
    }

    public final long a() {
        return this.f888a;
    }

    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0124ah) {
            C0124ah c0124ah = (C0124ah) obj;
            return this.f888a == c0124ah.f888a && this.b == c0124ah.b;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getFirstSendTime() {
        return this.f888a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getLastUpdateTime() {
        return this.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.f888a) * 31);
    }

    public final String toString() {
        return "RemoteConfigMetaInfoModel(firstSendTime=" + this.f888a + ", lastUpdateTime=" + this.b + ')';
    }

    public final C0124ah a(long j, long j2) {
        return new C0124ah(j, j2);
    }

    public static C0124ah a(C0124ah c0124ah, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = c0124ah.f888a;
        }
        if ((i & 2) != 0) {
            j2 = c0124ah.b;
        }
        c0124ah.getClass();
        return new C0124ah(j, j2);
    }
}
