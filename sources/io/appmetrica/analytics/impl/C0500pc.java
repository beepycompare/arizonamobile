package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* renamed from: io.appmetrica.analytics.impl.pc  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0500pc extends X4 implements Ma, La {
    public final C0404lg w;
    public final C0504pg x;
    public final E6 y;

    public C0500pc(Context context, C0256fm c0256fm, Q4 q4, C0467o4 c0467o4, C0404lg c0404lg, E6 e6, V4 v4) {
        this(context, q4, c0467o4, new C0363k0(), new TimePassedChecker(), new C0549rc(context, q4, c0467o4, v4, c0256fm, new C0375kc(e6), C0448na.k().w().c(), PackageManagerUtils.getAppVersionCodeInt(context), C0448na.k().w(), C0448na.k().l(), new C0220ec()), c0404lg, e6);
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
    public final synchronized void a(C0467o4 c0467o4) {
        super.a(c0467o4);
        this.y.a(c0467o4.i);
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

    public C0500pc(Context context, Q4 q4, C0467o4 c0467o4, C0363k0 c0363k0, TimePassedChecker timePassedChecker, C0549rc c0549rc, C0404lg c0404lg, E6 e6) {
        super(context, q4, c0363k0, timePassedChecker, c0549rc, c0467o4);
        this.w = c0404lg;
        X8 k = k();
        k.a(EnumC0142bb.EVENT_TYPE_REGULAR, new Hg(k.b()));
        this.x = c0549rc.a(this);
        this.y = e6;
        C0448na.k().x().onMainReporterCreated(new C0657vk(this, c0467o4));
    }
}
