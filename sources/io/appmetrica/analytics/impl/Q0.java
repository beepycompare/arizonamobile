package io.appmetrica.analytics.impl;

import android.location.Location;
/* loaded from: classes5.dex */
public final class Q0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f727a;
    public final /* synthetic */ C0610u1 b;

    public Q0(C0610u1 c0610u1, Location location) {
        this.b = c0610u1;
        this.f727a = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0734z0 c0734z0 = this.b.f1224a;
        Location location = this.f727a;
        c0734z0.getClass();
        C0709y0.c().a(location);
    }
}
