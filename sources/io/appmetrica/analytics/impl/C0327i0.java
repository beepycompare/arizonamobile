package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.i0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0327i0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f870a = new HashMap();

    public final synchronized C0302h0 a(C0406l5 c0406l5, PublicLogger publicLogger, Cif cif) {
        C0302h0 c0302h0;
        c0302h0 = (C0302h0) this.f870a.get(c0406l5.toString());
        if (c0302h0 == null) {
            C0277g0 d = cif.d();
            c0302h0 = new C0302h0(d.f846a, d.b, new C0497ol(publicLogger, "[App Environment]"));
            this.f870a.put(c0406l5.toString(), c0302h0);
        }
        return c0302h0;
    }

    public final synchronized void a(C0277g0 c0277g0, Cif cif) {
        cif.a(c0277g0).b();
    }
}
