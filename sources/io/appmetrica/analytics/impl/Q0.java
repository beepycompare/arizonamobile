package io.appmetrica.analytics.impl;

import android.location.Location;
/* loaded from: classes5.dex */
public final class Q0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f741a;
    public final /* synthetic */ C0610u1 b;

    public Q0(C0610u1 c0610u1, Location location) {
        this.b = c0610u1;
        this.f741a = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0734z0 c0734z0 = this.b.f1238a;
        Location location = this.f741a;
        c0734z0.getClass();
        C0709y0.c().a(location);
    }
}
