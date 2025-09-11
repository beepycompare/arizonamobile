package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;
/* renamed from: io.appmetrica.analytics.impl.gh  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0281gh implements RemoteConfigMetaInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f897a;
    public final long b;

    public C0281gh(long j, long j2) {
        this.f897a = j;
        this.b = j2;
    }

    public final C0281gh a(long j, long j2) {
        return new C0281gh(j, j2);
    }

    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0281gh) {
            C0281gh c0281gh = (C0281gh) obj;
            return this.f897a == c0281gh.f897a && this.b == c0281gh.b;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getFirstSendTime() {
        return this.f897a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getLastUpdateTime() {
        return this.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.f897a) * 31);
    }

    public final String toString() {
        return "RemoteConfigMetaInfoModel(firstSendTime=" + this.f897a + ", lastUpdateTime=" + this.b + ')';
    }

    public final long a() {
        return this.f897a;
    }

    public static C0281gh a(C0281gh c0281gh, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = c0281gh.f897a;
        }
        if ((i & 2) != 0) {
            j2 = c0281gh.b;
        }
        c0281gh.getClass();
        return new C0281gh(j, j2);
    }
}
