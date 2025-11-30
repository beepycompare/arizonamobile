package io.appmetrica.analytics.impl;

import android.location.Location;
/* loaded from: classes5.dex */
public final class Q0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f644a;
    public final /* synthetic */ C0611u1 b;

    public Q0(C0611u1 c0611u1, Location location) {
        this.b = c0611u1;
        this.f644a = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0735z0 c0735z0 = this.b.f1141a;
        Location location = this.f644a;
        c0735z0.getClass();
        C0710y0.c().a(location);
    }
}
