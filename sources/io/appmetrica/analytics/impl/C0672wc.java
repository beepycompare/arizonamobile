package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.wc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0672wc extends C0210e5 implements Ta, Sa {
    public final C0527qg w;
    public final C0626ug x;
    public final L6 y;

    public C0672wc(Context context, C0356jm c0356jm, X4 x4, C0639v4 c0639v4, C0527qg c0527qg, L6 l6, AbstractC0159c5 abstractC0159c5) {
        this(context, x4, c0639v4, new C0360k0(), new TimePassedChecker(), new C0722yc(context, x4, c0639v4, abstractC0159c5, c0356jm, new C0547rc(l6), C0620ua.k().x().d(), PackageManagerUtils.getAppVersionCodeInt(context), C0620ua.k().x(), C0620ua.k().l(), new C0398lc()), c0527qg, l6);
    }

    @Override // io.appmetrica.analytics.impl.C0210e5
    public final void C() {
        this.w.a(this.x);
    }

    public final boolean D() {
        boolean optBoolean;
        zo zoVar = this.t;
        synchronized (zoVar) {
            optBoolean = zoVar.f1238a.a().optBoolean("referrer_handled", false);
        }
        return optBoolean;
    }

    @Override // io.appmetrica.analytics.impl.C0210e5, io.appmetrica.analytics.impl.Wa, io.appmetrica.analytics.impl.La
    public final synchronized void a(C0639v4 c0639v4) {
        super.a(c0639v4);
        this.y.a(c0639v4.i);
    }

    @Override // io.appmetrica.analytics.impl.C0210e5, io.appmetrica.analytics.impl.La
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MAIN;
    }

    @Override // io.appmetrica.analytics.impl.Sa
    public final void a() {
        zo zoVar = this.t;
        synchronized (zoVar) {
            Ao ao = zoVar.f1238a;
            ao.a(ao.a().put("referrer_handled", true));
        }
    }

    public C0672wc(Context context, X4 x4, C0639v4 c0639v4, C0360k0 c0360k0, TimePassedChecker timePassedChecker, C0722yc c0722yc, C0527qg c0527qg, L6 l6) {
        super(context, x4, c0360k0, timePassedChecker, c0722yc, c0639v4);
        this.w = c0527qg;
        C0214e9 k = k();
        k.a(EnumC0320ib.EVENT_TYPE_REGULAR, new Mg(k.b()));
        this.x = c0722yc.a(this);
        this.y = l6;
        C0620ua.k().y().onMainReporterCreated(new Ak(this, c0639v4));
    }
}
