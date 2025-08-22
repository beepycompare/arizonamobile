package io.appmetrica.analytics.impl;

import okhttp3.internal.connection.RealConnection;
/* loaded from: classes4.dex */
public final class Wk {

    /* renamed from: a  reason: collision with root package name */
    public final zo f713a;

    public Wk(zo zoVar) {
        this.f713a = zoVar;
    }

    public final long a() {
        long optLong;
        zo zoVar = this.f713a;
        synchronized (zoVar) {
            optLong = zoVar.f1187a.a().optLong("session_id", -1L);
        }
        long j = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
        if (optLong >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
            j = 1 + optLong;
        }
        this.f713a.c(j);
        return j;
    }
}
