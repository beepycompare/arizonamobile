package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes4.dex */
public final class Ic extends C0580s5 implements InterfaceC0263fb, InterfaceC0238eb {
    public final C0691wg v;
    public final Ag w;
    public final W6 x;
    public final C0454n3 y;

    public Ic(Context context, C0198cm c0198cm, C0406l5 c0406l5, J4 j4, C0691wg c0691wg, W6 w6, AbstractC0531q5 abstractC0531q5) {
        this(context, c0406l5, c0198cm, j4, new C0327i0(), new TimePassedChecker(), new Kc(context, c0406l5, j4, abstractC0531q5, c0198cm, new Dc(w6), Ga.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ga.j().w(), Ga.j().k(), new C0712xc()), c0691wg, w6);
    }

    @Override // io.appmetrica.analytics.impl.C0580s5
    public final void B() {
        this.v.a(this.w);
    }

    public final boolean C() {
        boolean optBoolean;
        ro roVar = this.t;
        synchronized (roVar) {
            optBoolean = roVar.f1033a.a().optBoolean("referrer_handled", false);
        }
        return optBoolean;
    }

    @Override // io.appmetrica.analytics.impl.C0580s5, io.appmetrica.analytics.impl.InterfaceC0338ib, io.appmetrica.analytics.impl.Xa
    public final synchronized void a(J4 j4) {
        super.a(j4);
        this.x.a(j4.i);
    }

    @Override // io.appmetrica.analytics.impl.C0580s5, io.appmetrica.analytics.impl.Xa
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MAIN;
    }

    @Override // io.appmetrica.analytics.impl.C0580s5, io.appmetrica.analytics.impl.InterfaceC0338ib, io.appmetrica.analytics.impl.Nl
    public final void a(C0198cm c0198cm) {
        super.a(c0198cm);
        this.y.a(c0198cm);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0238eb
    public final void a() {
        ro roVar = this.t;
        synchronized (roVar) {
            so soVar = roVar.f1033a;
            soVar.a(soVar.a().put("referrer_handled", true));
        }
    }

    public Ic(Context context, C0406l5 c0406l5, C0198cm c0198cm, J4 j4, C0327i0 c0327i0, TimePassedChecker timePassedChecker, Kc kc, C0691wg c0691wg, W6 w6) {
        super(context, c0406l5, c0327i0, timePassedChecker, kc, j4);
        this.v = c0691wg;
        C0510p9 j = j();
        j.a(EnumC0636ub.EVENT_TYPE_REGULAR, new Sg(j.b()));
        this.w = kc.b(this);
        this.x = w6;
        C0454n3 a2 = kc.a(this);
        this.y = a2;
        a2.a(c0198cm, j4.m);
    }
}
