package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class Dd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Jd f409a;
    public final /* synthetic */ AdRevenue b;
    public final /* synthetic */ boolean c;

    public Dd(Jd jd, AdRevenue adRevenue, boolean z) {
        this.f409a = jd;
        this.b = adRevenue;
        this.c = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Jd.a(this.f409a).reportAdRevenue(this.b, this.c);
    }
}
