package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.hd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0300hd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0452nd f1028a;
    public final /* synthetic */ AdRevenue b;
    public final /* synthetic */ boolean c;

    public C0300hd(C0452nd c0452nd, AdRevenue adRevenue, boolean z) {
        this.f1028a = c0452nd;
        this.b = adRevenue;
        this.c = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0452nd.a(this.f1028a).reportAdRevenue(this.b, this.c);
    }
}
