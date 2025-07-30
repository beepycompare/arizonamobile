package io.appmetrica.analytics.impl;

import okhttp3.internal.connection.RealConnection;
/* loaded from: classes4.dex */
public final class Rk {

    /* renamed from: a  reason: collision with root package name */
    public final uo f627a;

    public Rk(uo uoVar) {
        this.f627a = uoVar;
    }

    public final long a() {
        long optLong;
        uo uoVar = this.f627a;
        synchronized (uoVar) {
            optLong = uoVar.f1092a.a().optLong("session_id", -1L);
        }
        long j = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
        if (optLong >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
            j = 1 + optLong;
        }
        this.f627a.c(j);
        return j;
    }
}
