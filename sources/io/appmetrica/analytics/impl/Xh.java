package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
/* loaded from: classes5.dex */
public final class Xh extends C0448n5 {
    public final String w;
    public final W6 x;

    public Xh(Context context, C0267g5 c0267g5, F4 f4, W6 w6, Hm hm, AbstractC0396l5 abstractC0396l5, M9 m9) {
        this(context, c0267g5, new C0417m0(), new TimePassedChecker(), new C0577s5(context, c0267g5, f4, abstractC0396l5, hm, new Sh(w6), Na.k().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Na.k().l(), m9), w6, f4);
    }

    @Override // io.appmetrica.analytics.impl.C0448n5, io.appmetrica.analytics.impl.InterfaceC0454nb, io.appmetrica.analytics.impl.InterfaceC0273gb
    public final synchronized void a(F4 f4) {
        super.a(f4);
        this.x.a(this.w, f4.i);
    }

    public Xh(Context context, C0267g5 c0267g5, C0417m0 c0417m0, TimePassedChecker timePassedChecker, C0577s5 c0577s5, W6 w6, F4 f4) {
        super(context, c0267g5, c0417m0, timePassedChecker, c0577s5, f4);
        this.w = c0267g5.b();
        this.x = w6;
    }
}
