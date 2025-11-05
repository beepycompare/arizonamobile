package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
/* loaded from: classes3.dex */
public final class Ih extends C0210e5 {
    public final String w;
    public final L6 x;

    public Ih(Context context, X4 x4, C0639v4 c0639v4, L6 l6, C0356jm c0356jm, AbstractC0159c5 abstractC0159c5, InterfaceC0744z9 interfaceC0744z9) {
        this(context, x4, new C0360k0(), new TimePassedChecker(), new C0339j5(context, x4, c0639v4, abstractC0159c5, c0356jm, new Dh(l6), C0620ua.k().x().d(), PackageManagerUtils.getAppVersionCodeInt(context), C0620ua.k().l(), interfaceC0744z9), l6, c0639v4);
    }

    @Override // io.appmetrica.analytics.impl.C0210e5, io.appmetrica.analytics.impl.Wa, io.appmetrica.analytics.impl.La
    public final synchronized void a(C0639v4 c0639v4) {
        super.a(c0639v4);
        this.x.a(this.w, c0639v4.i);
    }

    public Ih(Context context, X4 x4, C0360k0 c0360k0, TimePassedChecker timePassedChecker, C0339j5 c0339j5, L6 l6, C0639v4 c0639v4) {
        super(context, x4, c0360k0, timePassedChecker, c0339j5, c0639v4);
        this.w = x4.b();
        this.x = l6;
    }
}
