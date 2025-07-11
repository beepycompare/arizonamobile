package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes4.dex */
public final class Ic extends C0572s5 implements InterfaceC0255fb, InterfaceC0230eb {
    public final C0683wg v;
    public final Ag w;
    public final W6 x;
    public final C0446n3 y;

    public Ic(Context context, C0190cm c0190cm, C0398l5 c0398l5, J4 j4, C0683wg c0683wg, W6 w6, AbstractC0523q5 abstractC0523q5) {
        this(context, c0398l5, c0190cm, j4, new C0319i0(), new TimePassedChecker(), new Kc(context, c0398l5, j4, abstractC0523q5, c0190cm, new Dc(w6), Ga.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ga.j().w(), Ga.j().k(), new C0704xc()), c0683wg, w6);
    }

    @Override // io.appmetrica.analytics.impl.C0572s5
    public final void B() {
        this.v.a(this.w);
    }

    public final boolean C() {
        boolean optBoolean;
        ro roVar = this.t;
        synchronized (roVar) {
            optBoolean = roVar.f1034a.a().optBoolean("referrer_handled", false);
        }
        return optBoolean;
    }

    @Override // io.appmetrica.analytics.impl.C0572s5, io.appmetrica.analytics.impl.InterfaceC0330ib, io.appmetrica.analytics.impl.Xa
    public final synchronized void a(J4 j4) {
        super.a(j4);
        this.x.a(j4.i);
    }

    @Override // io.appmetrica.analytics.impl.C0572s5, io.appmetrica.analytics.impl.Xa
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MAIN;
    }

    @Override // io.appmetrica.analytics.impl.C0572s5, io.appmetrica.analytics.impl.InterfaceC0330ib, io.appmetrica.analytics.impl.Nl
    public final void a(C0190cm c0190cm) {
        super.a(c0190cm);
        this.y.a(c0190cm);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0230eb
    public final void a() {
        ro roVar = this.t;
        synchronized (roVar) {
            so soVar = roVar.f1034a;
            soVar.a(soVar.a().put("referrer_handled", true));
        }
    }

    public Ic(Context context, C0398l5 c0398l5, C0190cm c0190cm, J4 j4, C0319i0 c0319i0, TimePassedChecker timePassedChecker, Kc kc, C0683wg c0683wg, W6 w6) {
        super(context, c0398l5, c0319i0, timePassedChecker, kc, j4);
        this.v = c0683wg;
        C0502p9 j = j();
        j.a(EnumC0628ub.EVENT_TYPE_REGULAR, new Sg(j.b()));
        this.w = kc.b(this);
        this.x = w6;
        C0446n3 a2 = kc.a(this);
        this.y = a2;
        a2.a(c0190cm, j4.m);
    }
}
