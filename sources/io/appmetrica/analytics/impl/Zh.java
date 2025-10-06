package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
/* loaded from: classes4.dex */
public final class Zh extends C0652v5 {
    public final String w;
    public final C0195d7 x;

    public Zh(Context context, C0477o5 c0477o5, M4 m4, C0195d7 c0195d7, C0494om c0494om, AbstractC0602t5 abstractC0602t5, S9 s9) {
        this(context, c0477o5, new C0342j0(), new TimePassedChecker(), new A5(context, c0477o5, m4, abstractC0602t5, c0494om, new Uh(c0195d7), Na.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Na.j().k(), s9), c0195d7, m4);
    }

    @Override // io.appmetrica.analytics.impl.C0652v5, io.appmetrica.analytics.impl.InterfaceC0509pb, io.appmetrica.analytics.impl.InterfaceC0224eb
    public final synchronized void a(M4 m4) {
        super.a(m4);
        this.x.a(this.w, m4.i);
    }

    public Zh(Context context, C0477o5 c0477o5, C0342j0 c0342j0, TimePassedChecker timePassedChecker, A5 a5, C0195d7 c0195d7, M4 m4) {
        super(context, c0477o5, c0342j0, timePassedChecker, a5, m4);
        this.w = c0477o5.b();
        this.x = c0195d7;
    }
}
