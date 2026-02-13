package io.appmetrica.analytics.impl;

import okhttp3.internal.connection.RealConnection;
/* loaded from: classes5.dex */
public final class Qk {

    /* renamed from: a  reason: collision with root package name */
    public final xo f754a;

    public Qk(xo xoVar) {
        this.f754a = xoVar;
    }

    public final long a() {
        long optLong;
        xo xoVar = this.f754a;
        synchronized (xoVar) {
            optLong = xoVar.f1312a.a().optLong("session_id", -1L);
        }
        long j = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
        if (optLong >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
            j = 1 + optLong;
        }
        this.f754a.b(j);
        return j;
    }
}
