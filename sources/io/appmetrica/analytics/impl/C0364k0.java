package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.k0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0364k0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1071a = new HashMap();

    public final synchronized C0338j0 a(Q4 q4, PublicLogger publicLogger, We we) {
        C0338j0 c0338j0;
        c0338j0 = (C0338j0) this.f1071a.get(q4.toString());
        if (c0338j0 == null) {
            C0313i0 d = we.d();
            c0338j0 = new C0338j0(d.f1035a, d.b, new C0559rl(publicLogger, "[App Environment]"));
            this.f1071a.put(q4.toString(), c0338j0);
        }
        return c0338j0;
    }

    public final synchronized void a(C0313i0 c0313i0, We we) {
        we.a(c0313i0).b();
    }
}
