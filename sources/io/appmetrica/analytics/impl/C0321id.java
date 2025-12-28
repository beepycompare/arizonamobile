package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.id  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0321id extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0473od f1037a;
    public final /* synthetic */ AdRevenue b;
    public final /* synthetic */ boolean c;

    public C0321id(C0473od c0473od, AdRevenue adRevenue, boolean z) {
        this.f1037a = c0473od;
        this.b = adRevenue;
        this.c = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0473od.a(this.f1037a).reportAdRevenue(this.b, this.c);
    }
}
