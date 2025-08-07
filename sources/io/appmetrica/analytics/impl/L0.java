package io.appmetrica.analytics.impl;

import android.location.Location;
/* loaded from: classes4.dex */
public final class L0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f527a;
    public final /* synthetic */ C0497p1 b;

    public L0(C0497p1 c0497p1, Location location) {
        this.b = c0497p1;
        this.f527a = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0620u0 c0620u0 = this.b.f994a;
        Location location = this.f527a;
        c0620u0.getClass();
        C0595t0.c().a(location);
    }
}
