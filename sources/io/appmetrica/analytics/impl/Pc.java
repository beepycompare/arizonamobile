package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes4.dex */
public final class Pc extends C0651v5 implements InterfaceC0430mb, InterfaceC0404lb {
    public final Hg w;
    public final Lg x;
    public final C0194d7 y;
    public final C0525q3 z;

    public Pc(Context context, C0493om c0493om, C0476o5 c0476o5, M4 m4, Hg hg, C0194d7 c0194d7, AbstractC0601t5 abstractC0601t5) {
        this(context, c0476o5, c0493om, m4, new C0341j0(), new TimePassedChecker(), new Rc(context, c0476o5, m4, abstractC0601t5, c0493om, new Kc(c0194d7), Na.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Na.j().w(), Na.j().k(), new Ec()), hg, c0194d7);
    }

    @Override // io.appmetrica.analytics.impl.C0651v5
    public final void C() {
        this.w.a(this.x);
    }

    public final boolean D() {
        boolean optBoolean;
        Do r0 = this.t;
        synchronized (r0) {
            optBoolean = r0.f417a.a().optBoolean("referrer_handled", false);
        }
        return optBoolean;
    }

    @Override // io.appmetrica.analytics.impl.C0651v5, io.appmetrica.analytics.impl.InterfaceC0508pb, io.appmetrica.analytics.impl.InterfaceC0223eb
    public final synchronized void a(M4 m4) {
        super.a(m4);
        this.y.a(m4.i);
    }

    @Override // io.appmetrica.analytics.impl.C0651v5, io.appmetrica.analytics.impl.InterfaceC0223eb
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MAIN;
    }

    @Override // io.appmetrica.analytics.impl.C0651v5, io.appmetrica.analytics.impl.InterfaceC0508pb, io.appmetrica.analytics.impl.Zl
    public final void a(C0493om c0493om) {
        super.a(c0493om);
        this.z.a(c0493om);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0404lb
    public final void a() {
        Do r0 = this.t;
        synchronized (r0) {
            Eo eo = r0.f417a;
            eo.a(eo.a().put("referrer_handled", true));
        }
    }

    public Pc(Context context, C0476o5 c0476o5, C0493om c0493om, M4 m4, C0341j0 c0341j0, TimePassedChecker timePassedChecker, Rc rc, Hg hg, C0194d7 c0194d7) {
        super(context, c0476o5, c0341j0, timePassedChecker, rc, m4);
        this.w = hg;
        C0705x9 k = k();
        k.a(Bb.EVENT_TYPE_REGULAR, new C0204dh(k.b()));
        this.x = rc.b(this);
        this.y = c0194d7;
        C0525q3 a2 = rc.a(this);
        this.z = a2;
        a2.a(c0493om, m4.m);
    }
}
