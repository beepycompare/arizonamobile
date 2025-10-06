package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes4.dex */
public final class Pc extends C0652v5 implements InterfaceC0431mb, InterfaceC0405lb {
    public final Hg w;
    public final Lg x;
    public final C0195d7 y;
    public final C0526q3 z;

    public Pc(Context context, C0494om c0494om, C0477o5 c0477o5, M4 m4, Hg hg, C0195d7 c0195d7, AbstractC0602t5 abstractC0602t5) {
        this(context, c0477o5, c0494om, m4, new C0342j0(), new TimePassedChecker(), new Rc(context, c0477o5, m4, abstractC0602t5, c0494om, new Kc(c0195d7), Na.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Na.j().w(), Na.j().k(), new Ec()), hg, c0195d7);
    }

    @Override // io.appmetrica.analytics.impl.C0652v5
    public final void C() {
        this.w.a(this.x);
    }

    public final boolean D() {
        boolean optBoolean;
        Do r0 = this.t;
        synchronized (r0) {
            optBoolean = r0.f418a.a().optBoolean("referrer_handled", false);
        }
        return optBoolean;
    }

    @Override // io.appmetrica.analytics.impl.C0652v5, io.appmetrica.analytics.impl.InterfaceC0509pb, io.appmetrica.analytics.impl.InterfaceC0224eb
    public final synchronized void a(M4 m4) {
        super.a(m4);
        this.y.a(m4.i);
    }

    @Override // io.appmetrica.analytics.impl.C0652v5, io.appmetrica.analytics.impl.InterfaceC0224eb
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MAIN;
    }

    @Override // io.appmetrica.analytics.impl.C0652v5, io.appmetrica.analytics.impl.InterfaceC0509pb, io.appmetrica.analytics.impl.Zl
    public final void a(C0494om c0494om) {
        super.a(c0494om);
        this.z.a(c0494om);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0405lb
    public final void a() {
        Do r0 = this.t;
        synchronized (r0) {
            Eo eo = r0.f418a;
            eo.a(eo.a().put("referrer_handled", true));
        }
    }

    public Pc(Context context, C0477o5 c0477o5, C0494om c0494om, M4 m4, C0342j0 c0342j0, TimePassedChecker timePassedChecker, Rc rc, Hg hg, C0195d7 c0195d7) {
        super(context, c0477o5, c0342j0, timePassedChecker, rc, m4);
        this.w = hg;
        C0706x9 k = k();
        k.a(Bb.EVENT_TYPE_REGULAR, new C0205dh(k.b()));
        this.x = rc.b(this);
        this.y = c0195d7;
        C0526q3 a2 = rc.a(this);
        this.z = a2;
        a2.a(c0494om, m4.m);
    }
}
