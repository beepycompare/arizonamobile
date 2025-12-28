package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.k0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0359k0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1063a = new HashMap();

    public final synchronized C0333j0 a(R4 r4, PublicLogger publicLogger, Xe xe) {
        C0333j0 c0333j0;
        c0333j0 = (C0333j0) this.f1063a.get(r4.toString());
        if (c0333j0 == null) {
            C0308i0 d = xe.d();
            c0333j0 = new C0333j0(d.f1029a, d.b, new C0580sl(publicLogger, "[App Environment]"));
            this.f1063a.put(r4.toString(), c0333j0);
        }
        return c0333j0;
    }

    public final synchronized void a(C0308i0 c0308i0, Xe xe) {
        xe.a(c0308i0).b();
    }
}
