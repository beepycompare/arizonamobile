package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
/* loaded from: classes4.dex */
public final class Zh extends C0651v5 {
    public final String w;
    public final C0194d7 x;

    public Zh(Context context, C0476o5 c0476o5, M4 m4, C0194d7 c0194d7, C0493om c0493om, AbstractC0601t5 abstractC0601t5, S9 s9) {
        this(context, c0476o5, new C0341j0(), new TimePassedChecker(), new A5(context, c0476o5, m4, abstractC0601t5, c0493om, new Uh(c0194d7), Na.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Na.j().k(), s9), c0194d7, m4);
    }

    @Override // io.appmetrica.analytics.impl.C0651v5, io.appmetrica.analytics.impl.InterfaceC0508pb, io.appmetrica.analytics.impl.InterfaceC0223eb
    public final synchronized void a(M4 m4) {
        super.a(m4);
        this.x.a(this.w, m4.i);
    }

    public Zh(Context context, C0476o5 c0476o5, C0341j0 c0341j0, TimePassedChecker timePassedChecker, A5 a5, C0194d7 c0194d7, M4 m4) {
        super(context, c0476o5, c0341j0, timePassedChecker, a5, m4);
        this.w = c0476o5.b();
        this.x = c0194d7;
    }
}
