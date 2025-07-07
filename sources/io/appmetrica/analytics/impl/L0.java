package io.appmetrica.analytics.impl;

import android.location.Location;
/* loaded from: classes4.dex */
public final class L0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f511a;
    public final /* synthetic */ C0502p1 b;

    public L0(C0502p1 c0502p1, Location location) {
        this.b = c0502p1;
        this.f511a = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0625u0 c0625u0 = this.b.f983a;
        Location location = this.f511a;
        c0625u0.getClass();
        C0600t0.c().a(location);
    }
}
