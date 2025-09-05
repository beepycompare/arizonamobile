package io.appmetrica.analytics.impl;

import okhttp3.internal.connection.RealConnection;
/* renamed from: io.appmetrica.analytics.impl.al  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0130al {

    /* renamed from: a  reason: collision with root package name */
    public final Do f793a;

    public C0130al(Do r1) {
        this.f793a = r1;
    }

    public final long a() {
        long optLong;
        Do r0 = this.f793a;
        synchronized (r0) {
            optLong = r0.f413a.a().optLong("session_id", -1L);
        }
        long j = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
        if (optLong >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
            j = 1 + optLong;
        }
        this.f793a.c(j);
        return j;
    }
}
