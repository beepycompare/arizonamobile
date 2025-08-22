package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo;
/* renamed from: io.appmetrica.analytics.impl.ch  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0178ch implements RemoteConfigMetaInfo {

    /* renamed from: a  reason: collision with root package name */
    public final long f813a;
    public final long b;

    public C0178ch(long j, long j2) {
        this.f813a = j;
        this.b = j2;
    }

    public final C0178ch a(long j, long j2) {
        return new C0178ch(j, j2);
    }

    public final long b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0178ch) {
            C0178ch c0178ch = (C0178ch) obj;
            return this.f813a == c0178ch.f813a && this.b == c0178ch.b;
        }
        return false;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getFirstSendTime() {
        return this.f813a;
    }

    @Override // io.appmetrica.analytics.modulesapi.internal.service.RemoteConfigMetaInfo
    public final long getLastUpdateTime() {
        return this.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (Long.hashCode(this.f813a) * 31);
    }

    public final String toString() {
        return "RemoteConfigMetaInfoModel(firstSendTime=" + this.f813a + ", lastUpdateTime=" + this.b + ')';
    }

    public final long a() {
        return this.f813a;
    }

    public static C0178ch a(C0178ch c0178ch, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = c0178ch.f813a;
        }
        if ((i & 2) != 0) {
            j2 = c0178ch.b;
        }
        c0178ch.getClass();
        return new C0178ch(j, j2);
    }
}
