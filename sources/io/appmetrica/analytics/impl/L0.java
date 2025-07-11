package io.appmetrica.analytics.impl;

import android.location.Location;
/* loaded from: classes4.dex */
public final class L0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f512a;
    public final /* synthetic */ C0494p1 b;

    public L0(C0494p1 c0494p1, Location location) {
        this.b = c0494p1;
        this.f512a = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0617u0 c0617u0 = this.b.f984a;
        Location location = this.f512a;
        c0617u0.getClass();
        C0592t0.c().a(location);
    }
}
