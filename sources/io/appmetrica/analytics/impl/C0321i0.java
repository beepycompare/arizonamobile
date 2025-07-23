package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.i0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0321i0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f892a = new HashMap();

    public final synchronized C0296h0 a(C0400l5 c0400l5, PublicLogger publicLogger, C0385kf c0385kf) {
        C0296h0 c0296h0;
        c0296h0 = (C0296h0) this.f892a.get(c0400l5.toString());
        if (c0296h0 == null) {
            C0271g0 d = c0385kf.d();
            c0296h0 = new C0296h0(d.f855a, d.b, new C0565rl(publicLogger, "[App Environment]"));
            this.f892a.put(c0400l5.toString(), c0296h0);
        }
        return c0296h0;
    }

    public final synchronized void a(C0271g0 c0271g0, C0385kf c0385kf) {
        c0385kf.a(c0271g0).b();
    }
}
