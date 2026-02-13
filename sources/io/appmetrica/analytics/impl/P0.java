package io.appmetrica.analytics.impl;

import android.location.Location;
/* loaded from: classes5.dex */
public final class P0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f732a;
    public final /* synthetic */ C0589t1 b;

    public P0(C0589t1 c0589t1, Location location) {
        this.b = c0589t1;
        this.f732a = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0738z0 c0738z0 = this.b.f1228a;
        Location location = this.f732a;
        c0738z0.getClass();
        C0713y0.c().a(location);
    }
}
