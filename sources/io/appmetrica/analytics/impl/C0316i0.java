package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.i0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0316i0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f897a = new HashMap();

    public final synchronized C0290h0 a(C0398l5 c0398l5, PublicLogger publicLogger, C0433mf c0433mf) {
        C0290h0 c0290h0;
        c0290h0 = (C0290h0) this.f897a.get(c0398l5.toString());
        if (c0290h0 == null) {
            C0264g0 d = c0433mf.d();
            c0290h0 = new C0290h0(d.f862a, d.b, new C0688wl(publicLogger, "[App Environment]"));
            this.f897a.put(c0398l5.toString(), c0290h0);
        }
        return c0290h0;
    }

    public final synchronized void a(C0264g0 c0264g0, C0433mf c0433mf) {
        c0433mf.a(c0264g0).b();
    }
}
