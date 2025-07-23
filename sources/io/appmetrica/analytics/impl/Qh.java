package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
/* loaded from: classes4.dex */
public final class Qh extends C0574s5 {
    public final String v;
    public final Z6 w;

    public Qh(Context context, C0400l5 c0400l5, J4 j4, Z6 z6, C0267fm c0267fm, AbstractC0525q5 abstractC0525q5, N9 n9) {
        this(context, c0400l5, new C0321i0(), new TimePassedChecker(), new C0699x5(context, c0400l5, j4, abstractC0525q5, c0267fm, new Lh(z6), Ia.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ia.j().k(), n9), z6, j4);
    }

    @Override // io.appmetrica.analytics.impl.C0574s5, io.appmetrica.analytics.impl.InterfaceC0381kb, io.appmetrica.analytics.impl.Za
    public final synchronized void a(J4 j4) {
        super.a(j4);
        this.w.a(this.v, j4.i);
    }

    public Qh(Context context, C0400l5 c0400l5, C0321i0 c0321i0, TimePassedChecker timePassedChecker, C0699x5 c0699x5, Z6 z6, J4 j4) {
        super(context, c0400l5, c0321i0, timePassedChecker, c0699x5, j4);
        this.v = c0400l5.b();
        this.w = z6;
    }
}
