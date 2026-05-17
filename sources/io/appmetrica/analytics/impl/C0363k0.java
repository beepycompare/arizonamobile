package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.k0  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0363k0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f1076a = new HashMap();

    public final synchronized C0337j0 a(Q4 q4, PublicLogger publicLogger, We we) {
        C0337j0 c0337j0;
        c0337j0 = (C0337j0) this.f1076a.get(q4.toString());
        if (c0337j0 == null) {
            C0312i0 d = we.d();
            c0337j0 = new C0337j0(d.f1040a, d.b, new C0558rl(publicLogger, "[App Environment]"));
            this.f1076a.put(q4.toString(), c0337j0);
        }
        return c0337j0;
    }

    public final synchronized void a(C0312i0 c0312i0, We we) {
        we.a(c0312i0).b();
    }
}
