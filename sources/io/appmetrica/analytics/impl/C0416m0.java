package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.m0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0416m0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1089a = new HashMap();

    public final synchronized C0390l0 a(C0266g5 c0266g5, PublicLogger publicLogger, C0690wf c0690wf) {
        C0390l0 c0390l0;
        c0390l0 = (C0390l0) this.f1089a.get(c0266g5.toString());
        if (c0390l0 == null) {
            C0364k0 d = c0690wf.d();
            c0390l0 = new C0390l0(d.f1061a, d.b, new Wl(publicLogger, "[App Environment]"));
            this.f1089a.put(c0266g5.toString(), c0390l0);
        }
        return c0390l0;
    }

    public final synchronized void a(C0364k0 c0364k0, C0690wf c0690wf) {
        c0690wf.a(c0364k0);
    }
}
