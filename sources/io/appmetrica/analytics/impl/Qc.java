package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
import io.appmetrica.analytics.internal.CounterConfigurationReporterType;
/* loaded from: classes5.dex */
public final class Qc extends C0447n5 {
    public final W6 w;

    public Qc(Context context, Hm hm, C0266g5 c0266g5, F4 f4, W6 w6, AbstractC0395l5 abstractC0395l5) {
        this(context, c0266g5, f4, new C0416m0(), new TimePassedChecker(), new Sc(context, c0266g5, f4, abstractC0395l5, hm, new Mc(w6), Na.k().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Na.k().w(), Na.k().l(), new Gc()), w6);
    }

    @Override // io.appmetrica.analytics.impl.C0447n5, io.appmetrica.analytics.impl.InterfaceC0453nb, io.appmetrica.analytics.impl.InterfaceC0272gb
    public final synchronized void a(F4 f4) {
        super.a(f4);
        this.w.a(f4.i);
    }

    @Override // io.appmetrica.analytics.impl.C0447n5, io.appmetrica.analytics.impl.InterfaceC0272gb
    public final CounterConfigurationReporterType b() {
        return CounterConfigurationReporterType.MAIN;
    }

    public Qc(Context context, C0266g5 c0266g5, F4 f4, C0416m0 c0416m0, TimePassedChecker timePassedChecker, Sc sc, W6 w6) {
        super(context, c0266g5, c0416m0, timePassedChecker, sc, f4);
        C0554r9 k = k();
        k.a(Db.EVENT_TYPE_REGULAR, new Xg(k.a()));
        this.w = w6;
        Na.k().x().onMainReporterCreated(new Xk(this, f4));
    }
}
