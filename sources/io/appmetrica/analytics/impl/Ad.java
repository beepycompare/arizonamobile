package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* loaded from: classes4.dex */
public final class Ad extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Fd f346a;
    public final /* synthetic */ AdRevenue b;
    public final /* synthetic */ boolean c;

    public Ad(Fd fd, AdRevenue adRevenue, boolean z) {
        this.f346a = fd;
        this.b = adRevenue;
        this.c = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Fd.a(this.f346a).reportAdRevenue(this.b, this.c);
    }
}
