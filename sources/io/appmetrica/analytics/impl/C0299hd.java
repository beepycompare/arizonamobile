package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AdRevenue;
import io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable;
/* renamed from: io.appmetrica.analytics.impl.hd  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class C0299hd extends SafeRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C0451nd f1032a;
    public final /* synthetic */ AdRevenue b;
    public final /* synthetic */ boolean c;

    public C0299hd(C0451nd c0451nd, AdRevenue adRevenue, boolean z) {
        this.f1032a = c0451nd;
        this.b = adRevenue;
        this.c = z;
    }

    @Override // io.appmetrica.analytics.coreutils.internal.executors.SafeRunnable
    public final void runSafety() {
        C0451nd.a(this.f1032a).reportAdRevenue(this.b, this.c);
    }
}
