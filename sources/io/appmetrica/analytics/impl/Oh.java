package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
/* loaded from: classes4.dex */
public final class Oh extends C0572s5 {
    public final String v;
    public final W6 w;

    public Oh(Context context, C0398l5 c0398l5, J4 j4, W6 w6, C0190cm c0190cm, AbstractC0523q5 abstractC0523q5, K9 k9) {
        this(context, c0398l5, new C0319i0(), new TimePassedChecker(), new C0697x5(context, c0398l5, j4, abstractC0523q5, c0190cm, new Jh(w6), Ga.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ga.j().k(), k9), w6, j4);
    }

    @Override // io.appmetrica.analytics.impl.C0572s5, io.appmetrica.analytics.impl.InterfaceC0330ib, io.appmetrica.analytics.impl.Xa
    public final synchronized void a(J4 j4) {
        super.a(j4);
        this.w.a(this.v, j4.i);
    }

    public Oh(Context context, C0398l5 c0398l5, C0319i0 c0319i0, TimePassedChecker timePassedChecker, C0697x5 c0697x5, W6 w6, J4 j4) {
        super(context, c0398l5, c0319i0, timePassedChecker, c0697x5, j4);
        this.v = c0398l5.b();
        this.w = w6;
    }
}
