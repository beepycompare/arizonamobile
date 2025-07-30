package io.appmetrica.analytics.impl;

import android.location.Location;
/* loaded from: classes4.dex */
public final class L0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f528a;
    public final /* synthetic */ C0496p1 b;

    public L0(C0496p1 c0496p1, Location location) {
        this.b = c0496p1;
        this.f528a = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0619u0 c0619u0 = this.b.f995a;
        Location location = this.f528a;
        c0619u0.getClass();
        C0594t0.c().a(location);
    }
}
