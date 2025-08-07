package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes4.dex */
public final class Kc extends C0575s5 implements InterfaceC0308hb, InterfaceC0283gb {
    public final C0736yg v;
    public final Cg w;
    public final Z6 x;
    public final C0449n3 y;

    public Kc(Context context, C0268fm c0268fm, C0401l5 c0401l5, J4 j4, C0736yg c0736yg, Z6 z6, AbstractC0526q5 abstractC0526q5) {
        this(context, c0401l5, c0268fm, j4, new C0322i0(), new TimePassedChecker(), new Mc(context, c0401l5, j4, abstractC0526q5, c0268fm, new Fc(z6), Ia.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ia.j().w(), Ia.j().k(), new C0757zc()), c0736yg, z6);
    }

    @Override // io.appmetrica.analytics.impl.C0575s5
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

    @Override // io.appmetrica.analytics.impl.C0575s5, io.appmetrica.analytics.impl.InterfaceC0382kb, io.appmetrica.analytics.impl.Za
    public final synchronized void a(J4 j4) {
        super.a(j4);
        this.x.a(j4.i);
    }

    @Override // io.appmetrica.analytics.impl.C0575s5, io.appmetrica.analytics.impl.Za
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MAIN;
    }

    @Override // io.appmetrica.analytics.impl.C0575s5, io.appmetrica.analytics.impl.InterfaceC0382kb, io.appmetrica.analytics.impl.Ql
    public final void a(C0268fm c0268fm) {
        super.a(c0268fm);
        this.y.a(c0268fm);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0283gb
    public final void a() {
        uo uoVar = this.t;
        synchronized (uoVar) {
            vo voVar = uoVar.f1091a;
            voVar.a(voVar.a().put("referrer_handled", true));
        }
    }

    public Kc(Context context, C0401l5 c0401l5, C0268fm c0268fm, J4 j4, C0322i0 c0322i0, TimePassedChecker timePassedChecker, Mc mc, C0736yg c0736yg, Z6 z6) {
        super(context, c0401l5, c0322i0, timePassedChecker, mc, j4);
        this.v = c0736yg;
        C0579s9 j = j();
        j.a(EnumC0681wb.EVENT_TYPE_REGULAR, new Ug(j.b()));
        this.w = mc.b(this);
        this.x = z6;
        C0449n3 a2 = mc.a(this);
        this.y = a2;
        a2.a(c0268fm, j4.m);
    }
}
