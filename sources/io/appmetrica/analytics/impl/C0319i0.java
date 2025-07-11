package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.i0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0319i0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f871a = new HashMap();

    public final synchronized C0294h0 a(C0398l5 c0398l5, PublicLogger publicLogger, Cif cif) {
        C0294h0 c0294h0;
        c0294h0 = (C0294h0) this.f871a.get(c0398l5.toString());
        if (c0294h0 == null) {
            C0269g0 d = cif.d();
            c0294h0 = new C0294h0(d.f847a, d.b, new C0489ol(publicLogger, "[App Environment]"));
            this.f871a.put(c0398l5.toString(), c0294h0);
        }
        return c0294h0;
    }

    public final synchronized void a(C0269g0 c0269g0, Cif cif) {
        cif.a(c0269g0).b();
    }
}
