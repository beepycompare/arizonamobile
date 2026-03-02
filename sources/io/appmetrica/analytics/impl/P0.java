package io.appmetrica.analytics.impl;

import android.location.Location;
/* loaded from: classes5.dex */
public final class P0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f732a;
    public final /* synthetic */ C0588t1 b;

    public P0(C0588t1 c0588t1, Location location) {
        this.b = c0588t1;
        this.f732a = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0737z0 c0737z0 = this.b.f1228a;
        Location location = this.f732a;
        c0737z0.getClass();
        C0712y0.c().a(location);
    }
}
