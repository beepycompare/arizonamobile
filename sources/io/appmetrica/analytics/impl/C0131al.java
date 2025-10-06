package io.appmetrica.analytics.impl;

import okhttp3.internal.connection.RealConnection;
/* renamed from: io.appmetrica.analytics.impl.al  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0131al {

    /* renamed from: a  reason: collision with root package name */
    public final Do f798a;

    public C0131al(Do r1) {
        this.f798a = r1;
    }

    public final long a() {
        long optLong;
        Do r0 = this.f798a;
        synchronized (r0) {
            optLong = r0.f418a.a().optLong("session_id", -1L);
        }
        long j = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
        if (optLong >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
            j = 1 + optLong;
        }
        this.f798a.c(j);
        return j;
    }
}
