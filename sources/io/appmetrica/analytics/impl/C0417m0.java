package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.m0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0417m0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1086a = new HashMap();

    public final synchronized C0391l0 a(C0267g5 c0267g5, PublicLogger publicLogger, C0691wf c0691wf) {
        C0391l0 c0391l0;
        c0391l0 = (C0391l0) this.f1086a.get(c0267g5.toString());
        if (c0391l0 == null) {
            C0365k0 d = c0691wf.d();
            c0391l0 = new C0391l0(d.f1058a, d.b, new Wl(publicLogger, "[App Environment]"));
            this.f1086a.put(c0267g5.toString(), c0391l0);
        }
        return c0391l0;
    }

    public final synchronized void a(C0365k0 c0365k0, C0691wf c0691wf) {
        c0691wf.a(c0365k0);
    }
}
