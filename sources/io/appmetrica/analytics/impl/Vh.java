package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
/* loaded from: classes4.dex */
public final class Vh extends C0572s5 {
    public final String v;
    public final C0116a7 w;

    public Vh(Context context, C0398l5 c0398l5, J4 j4, C0116a7 c0116a7, C0389km c0389km, AbstractC0523q5 abstractC0523q5, P9 p9) {
        this(context, c0398l5, new C0316i0(), new TimePassedChecker(), new C0697x5(context, c0398l5, j4, abstractC0523q5, c0389km, new Qh(c0116a7), Ka.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ka.j().k(), p9), c0116a7, j4);
    }

    @Override // io.appmetrica.analytics.impl.C0572s5, io.appmetrica.analytics.impl.InterfaceC0429mb, io.appmetrica.analytics.impl.InterfaceC0146bb
    public final synchronized void a(J4 j4) {
        super.a(j4);
        this.w.a(this.v, j4.i);
    }

    public Vh(Context context, C0398l5 c0398l5, C0316i0 c0316i0, TimePassedChecker timePassedChecker, C0697x5 c0697x5, C0116a7 c0116a7, J4 j4) {
        super(context, c0398l5, c0316i0, timePassedChecker, c0697x5, j4);
        this.v = c0398l5.b();
        this.w = c0116a7;
    }
}
