package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes4.dex */
public final class Mc extends C0572s5 implements InterfaceC0352jb, InterfaceC0327ib {
    public final Dg v;
    public final Hg w;
    public final C0116a7 x;
    public final C0446n3 y;

    public Mc(Context context, C0389km c0389km, C0398l5 c0398l5, J4 j4, Dg dg, C0116a7 c0116a7, AbstractC0523q5 abstractC0523q5) {
        this(context, c0398l5, c0389km, j4, new C0316i0(), new TimePassedChecker(), new Oc(context, c0398l5, j4, abstractC0523q5, c0389km, new Hc(c0116a7), Ka.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ka.j().w(), Ka.j().k(), new Bc()), dg, c0116a7);
    }

    @Override // io.appmetrica.analytics.impl.C0572s5
    public final void B() {
        this.v.a(this.w);
    }

    public final boolean C() {
        boolean optBoolean;
        zo zoVar = this.t;
        synchronized (zoVar) {
            optBoolean = zoVar.f1187a.a().optBoolean("referrer_handled", false);
        }
        return optBoolean;
    }

    @Override // io.appmetrica.analytics.impl.C0572s5, io.appmetrica.analytics.impl.InterfaceC0429mb, io.appmetrica.analytics.impl.InterfaceC0146bb
    public final synchronized void a(J4 j4) {
        super.a(j4);
        this.x.a(j4.i);
    }

    @Override // io.appmetrica.analytics.impl.C0572s5, io.appmetrica.analytics.impl.InterfaceC0146bb
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MAIN;
    }

    @Override // io.appmetrica.analytics.impl.C0572s5, io.appmetrica.analytics.impl.InterfaceC0429mb, io.appmetrica.analytics.impl.Vl
    public final void a(C0389km c0389km) {
        super.a(c0389km);
        this.y.a(c0389km);
    }

    @Override // io.appmetrica.analytics.impl.InterfaceC0327ib
    public final void a() {
        zo zoVar = this.t;
        synchronized (zoVar) {
            Ao ao = zoVar.f1187a;
            ao.a(ao.a().put("referrer_handled", true));
        }
    }

    public Mc(Context context, C0398l5 c0398l5, C0389km c0389km, J4 j4, C0316i0 c0316i0, TimePassedChecker timePassedChecker, Oc oc, Dg dg, C0116a7 c0116a7) {
        super(context, c0398l5, c0316i0, timePassedChecker, oc, j4);
        this.v = dg;
        C0626u9 j = j();
        j.a(EnumC0728yb.EVENT_TYPE_REGULAR, new Zg(j.b()));
        this.w = oc.b(this);
        this.x = c0116a7;
        C0446n3 a2 = oc.a(this);
        this.y = a2;
        a2.a(c0389km, j4.m);
    }
}
