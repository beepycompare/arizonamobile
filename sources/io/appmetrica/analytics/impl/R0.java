package io.appmetrica.analytics.impl;

import android.location.Location;
/* loaded from: classes5.dex */
public final class R0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f743a;
    public final /* synthetic */ C0644v1 b;

    public R0(C0644v1 c0644v1, Location location) {
        this.b = c0644v1;
        this.f743a = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        B0 b0 = this.b.f1246a;
        Location location = this.f743a;
        b0.getClass();
        A0.c().a(location);
    }
}
