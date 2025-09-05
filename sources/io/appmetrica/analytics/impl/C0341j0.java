package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.j0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0341j0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f926a = new HashMap();

    public final synchronized C0316i0 a(C0476o5 c0476o5, PublicLogger publicLogger, C0537qf c0537qf) {
        C0316i0 c0316i0;
        c0316i0 = (C0316i0) this.f926a.get(c0476o5.toString());
        if (c0316i0 == null) {
            C0290h0 d = c0537qf.d();
            c0316i0 = new C0316i0(d.f898a, d.b, new Al(publicLogger, "[App Environment]"));
            this.f926a.put(c0476o5.toString(), c0316i0);
        }
        return c0316i0;
    }

    public final synchronized void a(C0290h0 c0290h0, C0537qf c0537qf) {
        c0537qf.a(c0290h0).b();
    }
}
