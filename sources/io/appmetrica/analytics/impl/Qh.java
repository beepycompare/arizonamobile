package io.appmetrica.analytics.impl;

import android.content.Context;
import io.appmetrica.analytics.coreutils.internal.services.PackageManagerUtils;
import io.appmetrica.analytics.coreutils.internal.time.TimePassedChecker;
/* loaded from: classes4.dex */
public final class Qh extends C0575s5 {
    public final String v;
    public final Z6 w;

    public Qh(Context context, C0401l5 c0401l5, J4 j4, Z6 z6, C0268fm c0268fm, AbstractC0526q5 abstractC0526q5, N9 n9) {
        this(context, c0401l5, new C0322i0(), new TimePassedChecker(), new C0700x5(context, c0401l5, j4, abstractC0526q5, c0268fm, new Lh(z6), Ia.j().w().d(), PackageManagerUtils.getAppVersionCodeInt(context), Ia.j().k(), n9), z6, j4);
    }

    @Override // io.appmetrica.analytics.impl.C0575s5, io.appmetrica.analytics.impl.InterfaceC0382kb, io.appmetrica.analytics.impl.Za
    public final synchronized void a(J4 j4) {
        super.a(j4);
        this.w.a(this.v, j4.i);
    }

    public Qh(Context context, C0401l5 c0401l5, C0322i0 c0322i0, TimePassedChecker timePassedChecker, C0700x5 c0700x5, Z6 z6, J4 j4) {
        super(context, c0401l5, c0322i0, timePassedChecker, c0700x5, j4);
        this.v = c0401l5.b();
        this.w = z6;
    }
}
