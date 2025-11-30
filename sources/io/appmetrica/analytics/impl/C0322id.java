package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.id  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0322id extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0474od f939a;
    public final /* synthetic */ AdRevenue b;
    public final /* synthetic */ boolean c;

    public C0322id(C0474od c0474od, AdRevenue adRevenue, boolean z) {
        this.f939a = c0474od;
        this.b = adRevenue;
        this.c = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0474od.a(this.f939a).reportAdRevenue(this.b, this.c);
    }
}
