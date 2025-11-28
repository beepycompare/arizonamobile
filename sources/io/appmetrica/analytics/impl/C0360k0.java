package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.k0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0360k0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f963a = new HashMap();

    public final synchronized C0334j0 a(X4 x4, PublicLogger publicLogger, C0143bf c0143bf) {
        C0334j0 c0334j0;
        c0334j0 = (C0334j0) this.f963a.get(x4.toString());
        if (c0334j0 == null) {
            C0309i0 d = c0143bf.d();
            c0334j0 = new C0334j0(d.f920a, d.b, new C0656vl(publicLogger, "[App Environment]"));
            this.f963a.put(x4.toString(), c0334j0);
        }
        return c0334j0;
    }

    public final synchronized void a(C0309i0 c0309i0, C0143bf c0143bf) {
        c0143bf.a(c0309i0).b();
    }
}
