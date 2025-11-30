package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.k0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0360k0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f965a = new HashMap();

    public final synchronized C0334j0 a(R4 r4, PublicLogger publicLogger, Xe xe) {
        C0334j0 c0334j0;
        c0334j0 = (C0334j0) this.f965a.get(r4.toString());
        if (c0334j0 == null) {
            C0309i0 d = xe.d();
            c0334j0 = new C0334j0(d.f931a, d.b, new C0581sl(publicLogger, "[App Environment]"));
            this.f965a.put(r4.toString(), c0334j0);
        }
        return c0334j0;
    }

    public final synchronized void a(C0309i0 c0309i0, Xe xe) {
        xe.a(c0309i0).b();
    }
}
