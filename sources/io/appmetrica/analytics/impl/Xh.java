package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
/* loaded from: classes5.dex */
public final class Xh extends C0447n5 {
    public final String w;
    public final W6 x;

    public Xh(Context context, C0266g5 c0266g5, F4 f4, W6 w6, Hm hm, AbstractC0395l5 abstractC0395l5, M9 m9) {
        this(context, c0266g5, new C0416m0(), new TimePassedChecker(), new C0576s5(context, c0266g5, f4, abstractC0395l5, hm, new Sh(w6), Na.k().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Na.k().l(), m9), w6, f4);
    }

    @Override // io.appmetrica.analytics.impl.C0447n5, io.appmetrica.analytics.impl.InterfaceC0453nb, io.appmetrica.analytics.impl.InterfaceC0272gb
    public final synchronized void a(F4 f4) {
        super.a(f4);
        this.x.a(this.w, f4.i);
    }

    public Xh(Context context, C0266g5 c0266g5, C0416m0 c0416m0, TimePassedChecker timePassedChecker, C0576s5 c0576s5, W6 w6, F4 f4) {
        super(context, c0266g5, c0416m0, timePassedChecker, c0576s5, f4);
        this.w = c0266g5.b();
        this.x = w6;
    }
}
