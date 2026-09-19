package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.m0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0415m0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1089a = new HashMap();

    public final synchronized C0389l0 a(C0265g5 c0265g5, PublicLogger publicLogger, C0689wf c0689wf) {
        C0389l0 c0389l0;
        c0389l0 = (C0389l0) this.f1089a.get(c0265g5.toString());
        if (c0389l0 == null) {
            C0363k0 d = c0689wf.d();
            c0389l0 = new C0389l0(d.f1061a, d.b, new Wl(publicLogger, "[App Environment]"));
            this.f1089a.put(c0265g5.toString(), c0389l0);
        }
        return c0389l0;
    }

    public final synchronized void a(C0363k0 c0363k0, C0689wf c0689wf) {
        c0689wf.a(c0363k0);
    }
}
