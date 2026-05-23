package io.appmetrica.analytics.impl;

import android.location.Location;
/* loaded from: classes5.dex */
public final class R0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f737a;
    public final /* synthetic */ C0651v1 b;

    public R0(C0651v1 c0651v1, Location location) {
        this.b = c0651v1;
        this.f737a = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 b0 = this.b.f1240a;
        Location location = this.f737a;
        b0.getClass();
        A0.c().a(location);
    }
}
