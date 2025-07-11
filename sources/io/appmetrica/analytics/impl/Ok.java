package io.appmetrica.analytics.impl;

import okhttp3.internal.connection.RealConnection;
/* loaded from: classes4.dex */
public final class Ok {

    /* renamed from: a  reason: collision with root package name */
    public final ro f569a;

    public Ok(ro roVar) {
        this.f569a = roVar;
    }

    public final long a() {
        long optLong;
        ro roVar = this.f569a;
        synchronized (roVar) {
            optLong = roVar.f1034a.a().optLong("session_id", -1L);
        }
        long j = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
        if (optLong >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
            j = 1 + optLong;
        }
        this.f569a.c(j);
        return j;
    }
}
