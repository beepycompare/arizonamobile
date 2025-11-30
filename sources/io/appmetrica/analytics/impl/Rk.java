package io.appmetrica.analytics.impl;

import okhttp3.internal.connection.RealConnection;
/* loaded from: classes5.dex */
public final class Rk {

    /* renamed from: a  reason: collision with root package name */
    public final yo f665a;

    public Rk(yo yoVar) {
        this.f665a = yoVar;
    }

    public final long a() {
        long optLong;
        yo yoVar = this.f665a;
        synchronized (yoVar) {
            optLong = yoVar.f1225a.a().optLong("session_id", -1L);
        }
        long j = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
        if (optLong >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
            j = 1 + optLong;
        }
        this.f665a.b(j);
        return j;
    }
}
