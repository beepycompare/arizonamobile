package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.logger.appmetrica.internal.PublicLogger;
import java.util.HashMap;
/* renamed from: io.appmetrica.analytics.impl.i0  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0322i0 {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f892a = new HashMap();

    public final synchronized C0297h0 a(C0401l5 c0401l5, PublicLogger publicLogger, C0386kf c0386kf) {
        C0297h0 c0297h0;
        c0297h0 = (C0297h0) this.f892a.get(c0401l5.toString());
        if (c0297h0 == null) {
            C0272g0 d = c0386kf.d();
            c0297h0 = new C0297h0(d.f855a, d.b, new C0566rl(publicLogger, "[App Environment]"));
            this.f892a.put(c0401l5.toString(), c0297h0);
        }
        return c0297h0;
    }

    public final synchronized void a(C0272g0 c0272g0, C0386kf c0386kf) {
        c0386kf.a(c0272g0).b();
    }
}
