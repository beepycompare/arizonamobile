package io.appmetrica.analytics.impl;

import okhttp3.internal.connection.RealConnection;
/* renamed from: io.appmetrica.analytics.impl.ul  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0644ul {

    /* renamed from: a  reason: collision with root package name */
    public final ap f1238a;

    public C0644ul(ap apVar) {
        this.f1238a = apVar;
    }

    public final long a() {
        long optLong;
        ap apVar = this.f1238a;
        synchronized (apVar) {
            optLong = apVar.f896a.a().optLong("session_id", -1L);
        }
        long j = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
        if (optLong >= RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
            j = 1 + optLong;
        }
        this.f1238a.b(j);
        return j;
    }
}
