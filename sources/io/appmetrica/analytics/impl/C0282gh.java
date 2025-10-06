package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;
/* renamed from: io.appmetrica.analytics.impl.gh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0282gh implements RemoteConfigMetaInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f898a;
    public final long b;

    public C0282gh(long j, long j2) {
        this.f898a = j;
        this.b = j2;
    }

    public final C0282gh a(long j, long j2) {
        return new C0282gh(j, j2);
    }

    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0282gh) {
            C0282gh c0282gh = (C0282gh) obj;
            return this.f898a == c0282gh.f898a && this.b == c0282gh.b;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getFirstSendTime() {
        return this.f898a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getLastUpdateTime() {
        return this.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.f898a) * 31);
    }

    public final String toString() {
        return "RemoteConfigMetaInfoModel(firstSendTime=" + this.f898a + ", lastUpdateTime=" + this.b + ')';
    }

    public final long a() {
        return this.f898a;
    }

    public static C0282gh a(C0282gh c0282gh, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = c0282gh.f898a;
        }
        if ((i & 2) != 0) {
            j2 = c0282gh.b;
        }
        c0282gh.getClass();
        return new C0282gh(j, j2);
    }
}
