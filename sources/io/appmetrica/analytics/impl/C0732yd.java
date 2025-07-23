package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.yd  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class C0732yd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Dd f1154a;
    public final /* synthetic */ AdRevenue b;
    public final /* synthetic */ boolean c;

    public C0732yd(Dd dd, AdRevenue adRevenue, boolean z) {
        this.f1154a = dd;
        this.b = adRevenue;
        this.c = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        Dd.a(this.f1154a).reportAdRevenue(this.b, this.c);
    }
}
