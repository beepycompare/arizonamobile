package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.wd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0680wd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bd f1106a;
    public final /* synthetic */ AdRevenue b;
    public final /* synthetic */ boolean c;

    public C0680wd(Bd bd, AdRevenue adRevenue, boolean z) {
        this.f1106a = bd;
        this.b = adRevenue;
        this.c = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Bd.a(this.f1106a).reportAdRevenue(this.b, this.c);
    }
}
