package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.j0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0342j0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f931a = new HashMap();

    public final synchronized C0317i0 a(C0477o5 c0477o5, PublicLogger publicLogger, C0538qf c0538qf) {
        C0317i0 c0317i0;
        c0317i0 = (C0317i0) this.f931a.get(c0477o5.toString());
        if (c0317i0 == null) {
            C0291h0 d = c0538qf.d();
            c0317i0 = new C0317i0(d.f903a, d.b, new Al(publicLogger, "[App Environment]"));
            this.f931a.put(c0477o5.toString(), c0317i0);
        }
        return c0317i0;
    }

    public final synchronized void a(C0291h0 c0291h0, C0538qf c0538qf) {
        c0538qf.a(c0291h0).b();
    }
}
