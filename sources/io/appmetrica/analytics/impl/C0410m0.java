package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.m0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0410m0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1092a = new HashMap();

    public final synchronized C0384l0 a(C0260g5 c0260g5, PublicLogger publicLogger, C0684wf c0684wf) {
        C0384l0 c0384l0;
        c0384l0 = (C0384l0) this.f1092a.get(c0260g5.toString());
        if (c0384l0 == null) {
            C0358k0 d = c0684wf.d();
            c0384l0 = new C0384l0(d.f1064a, d.b, new Wl(publicLogger, "[App Environment]"));
            this.f1092a.put(c0260g5.toString(), c0384l0);
        }
        return c0384l0;
    }

    public final synchronized void a(C0358k0 c0358k0, C0684wf c0684wf) {
        c0684wf.a(c0358k0);
    }
}
