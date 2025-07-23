package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes4.dex */
public final class Kc extends C0574s5 implements InterfaceC0307hb, InterfaceC0282gb {
    public final C0735yg v;
    public final Cg w;
    public final Z6 x;
    public final C0448n3 y;

    public Kc(Context context, C0267fm c0267fm, C0400l5 c0400l5, J4 j4, C0735yg c0735yg, Z6 z6, AbstractC0525q5 abstractC0525q5) {
        this(context, c0400l5, c0267fm, j4, new C0321i0(), new TimePassedChecker(), new Mc(context, c0400l5, j4, abstractC0525q5, c0267fm, new Fc(z6), Ia.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ia.j().w(), Ia.j().k(), new C0756zc()), c0735yg, z6);
    }

    @Override // io.appmetrica.analytics.impl.C0574s5
    public final void B() {
        this.v.a(this.w);
    }

    public final boolean C() {
        boolean optBoolean;
        uo uoVar = this.t;
        synchronized (uoVar) {
            optBoolean = uoVar.f1091a.a().optBoolean("referrer_handled", false);
        }
        return optBoolean;
    }

    @Override // io.appmetrica.analytics.impl.C0574s5, io.appmetrica.analytics.impl.InterfaceC0381kb, io.appmetrica.analytics.impl.Za
    public final synchronized void a(J4 j4) {
        super.a(j4);
        this.x.a(j4.i);
    }

    @Override // io.appmetrica.analytics.impl.C0574s5, io.appmetrica.analytics.impl.Za
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MAIN;
    }

    @Override // io.appmetrica.analytics.impl.C0574s5, io.appmetrica.analytics.impl.InterfaceC0381kb, io.appmetrica.analytics.impl.Ql
    public final void a(C0267fm c0267fm) {
        super.a(c0267fm);
        this.y.a(c0267fm);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0282gb
    public final void a() {
        uo uoVar = this.t;
        synchronized (uoVar) {
            vo voVar = uoVar.f1091a;
            voVar.a(voVar.a().put("referrer_handled", true));
        }
    }

    public Kc(Context context, C0400l5 c0400l5, C0267fm c0267fm, J4 j4, C0321i0 c0321i0, TimePassedChecker timePassedChecker, Mc mc, C0735yg c0735yg, Z6 z6) {
        super(context, c0400l5, c0321i0, timePassedChecker, mc, j4);
        this.v = c0735yg;
        C0578s9 j = j();
        j.a(EnumC0680wb.EVENT_TYPE_REGULAR, new Ug(j.b()));
        this.w = mc.b(this);
        this.x = z6;
        C0448n3 a2 = mc.a(this);
        this.y = a2;
        a2.a(c0267fm, j4.m);
    }
}
