package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
/* loaded from: classes5.dex */
public final class Dh extends X4 {
    public final String w;
    public final E6 x;

    public Dh(Context context, Q4 q4, C0467o4 c0467o4, E6 e6, C0256fm c0256fm, V4 v4, InterfaceC0571s9 interfaceC0571s9) {
        this(context, q4, new C0363k0(), new TimePassedChecker(), new C0162c5(context, q4, c0467o4, v4, c0256fm, new C0729yh(e6), C0448na.k().w().c(), PackageManagerUtils.getAppVersionCodeInt(context), C0448na.k().l(), interfaceC0571s9), e6, c0467o4);
    }

    @Override // io.appmetrica.analytics.impl.X4, io.appmetrica.analytics.impl.Pa, io.appmetrica.analytics.impl.Ea
    public final synchronized void a(C0467o4 c0467o4) {
        super.a(c0467o4);
        this.x.a(this.w, c0467o4.i);
    }

    public Dh(Context context, Q4 q4, C0363k0 c0363k0, TimePassedChecker timePassedChecker, C0162c5 c0162c5, E6 e6, C0467o4 c0467o4) {
        super(context, q4, c0363k0, timePassedChecker, c0162c5, c0467o4);
        this.w = q4.b();
        this.x = e6;
    }
}
