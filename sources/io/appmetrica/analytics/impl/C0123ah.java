package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;
/* renamed from: io.appmetrica.analytics.impl.ah  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0123ah implements RemoteConfigMetaInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f890a;
    public final long b;

    public C0123ah(long j, long j2) {
        this.f890a = j;
        this.b = j2;
    }

    public final long a() {
        return this.f890a;
    }

    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0123ah) {
            C0123ah c0123ah = (C0123ah) obj;
            return this.f890a == c0123ah.f890a && this.b == c0123ah.b;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getFirstSendTime() {
        return this.f890a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getLastUpdateTime() {
        return this.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.f890a) * 31);
    }

    public final String toString() {
        return "RemoteConfigMetaInfoModel(firstSendTime=" + this.f890a + ", lastUpdateTime=" + this.b + ')';
    }

    public final C0123ah a(long j, long j2) {
        return new C0123ah(j, j2);
    }

    public static C0123ah a(C0123ah c0123ah, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = c0123ah.f890a;
        }
        if ((i & 2) != 0) {
            j2 = c0123ah.b;
        }
        c0123ah.getClass();
        return new C0123ah(j, j2);
    }
}
