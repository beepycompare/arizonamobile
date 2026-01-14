package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
/* loaded from: classes5.dex */
public final class Dh extends X4 {
    public final String w;
    public final E6 x;

    public Dh(Context context, Q4 q4, C0468o4 c0468o4, E6 e6, C0257fm c0257fm, V4 v4, InterfaceC0572s9 interfaceC0572s9) {
        this(context, q4, new C0364k0(), new TimePassedChecker(), new C0163c5(context, q4, c0468o4, v4, c0257fm, new C0730yh(e6), C0449na.k().w().c(), PackageManagerUtils.getAppVersionCodeInt(context), C0449na.k().l(), interfaceC0572s9), e6, c0468o4);
    }

    @Override // io.appmetrica.analytics.impl.X4, io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Ea
    public final synchronized void a(C0468o4 c0468o4) {
        super.a(c0468o4);
        this.x.a(this.w, c0468o4.i);
    }

    public Dh(Context context, Q4 q4, C0364k0 c0364k0, TimePassedChecker timePassedChecker, C0163c5 c0163c5, E6 e6, C0468o4 c0468o4) {
        super(context, q4, c0364k0, timePassedChecker, c0163c5, c0468o4);
        this.w = q4.b();
        this.x = e6;
    }
}
