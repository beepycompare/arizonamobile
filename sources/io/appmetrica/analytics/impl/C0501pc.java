package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.pc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0501pc extends X4 implements Ma, La {
    public final C0405lg w;
    public final C0505pg x;
    public final E6 y;

    public C0501pc(Context context, C0257fm c0257fm, Q4 q4, C0468o4 c0468o4, C0405lg c0405lg, E6 e6, V4 v4) {
        this(context, q4, c0468o4, new C0364k0(), new TimePassedChecker(), new C0550rc(context, q4, c0468o4, v4, c0257fm, new C0376kc(e6), C0449na.k().w().c(), PackageManagerUtils.getAppVersionCodeInt(context), C0449na.k().w(), C0449na.k().l(), new C0221ec()), c0405lg, e6);
    }

    @Override // io.appmetrica.analytics.impl.X4
    public final void C() {
        this.w.a(this.x);
    }

    public final boolean D() {
        boolean optBoolean;
        xo xoVar = this.t;
        synchronized (xoVar) {
            optBoolean = xoVar.f1312a.a().optBoolean("referrer_handled", false);
        }
        return optBoolean;
    }

    @Override // io.appmetrica.analytics.impl.X4, io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Ea
    public final synchronized void a(C0468o4 c0468o4) {
        super.a(c0468o4);
        this.y.a(c0468o4.i);
    }

    @Override // io.appmetrica.analytics.impl.X4, io.appmetrica.analytics.impl.Ea
    public final CounterConfigurationReporterType c() {
        return CounterConfigurationReporterType.MAIN;
    }

    @Override // io.appmetrica.analytics.impl.La
    public final void a() {
        xo xoVar = this.t;
        synchronized (xoVar) {
            yo yoVar = xoVar.f1312a;
            yoVar.a(yoVar.a().put("referrer_handled", true));
        }
    }

    public C0501pc(Context context, Q4 q4, C0468o4 c0468o4, C0364k0 c0364k0, TimePassedChecker timePassedChecker, C0550rc c0550rc, C0405lg c0405lg, E6 e6) {
        super(context, q4, c0364k0, timePassedChecker, c0550rc, c0468o4);
        this.w = c0405lg;
        X8 k = k();
        k.a(EnumC0143bb.EVENT_TYPE_REGULAR, new Hg(k.b()));
        this.x = c0550rc.a(this);
        this.y = e6;
        C0449na.k().x().onMainReporterCreated(new C0658vk(this, c0468o4));
    }
}
