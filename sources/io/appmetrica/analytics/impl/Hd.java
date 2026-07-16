package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes5.dex */
public final class Hd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Nd f579a;
    public final /* synthetic */ AdRevenue b;
    public final /* synthetic */ boolean c;

    public Hd(Nd nd, AdRevenue adRevenue, boolean z) {
        this.f579a = nd;
        this.b = adRevenue;
        this.c = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Nd.a(this.f579a).reportAdRevenue(this.b, this.c);
    }
}
