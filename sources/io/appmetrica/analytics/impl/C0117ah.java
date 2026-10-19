package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;
/* renamed from: io.appmetrica.analytics.impl.ah  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0117ah implements RemoteConfigMetaInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f893a;
    public final long b;

    public C0117ah(long j, long j2) {
        this.f893a = j;
        this.b = j2;
    }

    public final long a() {
        return this.f893a;
    }

    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0117ah) {
            C0117ah c0117ah = (C0117ah) obj;
            return this.f893a == c0117ah.f893a && this.b == c0117ah.b;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getFirstSendTime() {
        return this.f893a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getLastUpdateTime() {
        return this.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.f893a) * 31);
    }

    public final String toString() {
        return "RemoteConfigMetaInfoModel(firstSendTime=" + this.f893a + ", lastUpdateTime=" + this.b + ')';
    }

    public final C0117ah a(long j, long j2) {
        return new C0117ah(j, j2);
    }

    public static C0117ah a(C0117ah c0117ah, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = c0117ah.f893a;
        }
        if ((i & 2) != 0) {
            j2 = c0117ah.b;
        }
        c0117ah.getClass();
        return new C0117ah(j, j2);
    }
}
