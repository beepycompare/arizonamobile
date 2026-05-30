package io.appmetrica.analytics.impl;

import okhttp3.internal.connection.RealConnection;
/* renamed from: io.appmetrica.analytics.impl.ul  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0645ul {

    /* renamed from: a  reason: collision with root package name */
    public final ap f1236a;

    public C0645ul(ap apVar) {
        this.f1236a = apVar;
    }

    public final long a() {
        long optLong;
        ap apVar = this.f1236a;
        synchronized (apVar) {
            optLong = apVar.f894a.a().optLong("session_id", -1L);
        }
        long j = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
        if (optLong >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
            j = 1 + optLong;
        }
        this.f1236a.b(j);
        return j;
    }
}
