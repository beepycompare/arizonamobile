package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.od  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0474od extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0623ud f1039a;
    public final /* synthetic */ AdRevenue b;
    public final /* synthetic */ boolean c;

    public C0474od(C0623ud c0623ud, AdRevenue adRevenue, boolean z) {
        this.f1039a = c0623ud;
        this.b = adRevenue;
        this.c = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0623ud.a(this.f1039a).reportAdRevenue(this.b, this.c);
    }
}
