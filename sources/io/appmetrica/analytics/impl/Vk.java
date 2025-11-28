package io.appmetrica.analytics.impl;

import okhttp3.internal.connection.RealConnection;
/* loaded from: classes5.dex */
public final class Vk {

    /* renamed from: a  reason: collision with root package name */
    public final zo f736a;

    public Vk(zo zoVar) {
        this.f736a = zoVar;
    }

    public final long a() {
        long optLong;
        zo zoVar = this.f736a;
        synchronized (zoVar) {
            optLong = zoVar.f1238a.a().optLong("session_id", -1L);
        }
        long j = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
        if (optLong >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
            j = 1 + optLong;
        }
        this.f736a.c(j);
        return j;
    }
}
