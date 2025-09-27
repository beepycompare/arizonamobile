package io.appmetrica.analytics.impl;

import android.location.Location;
/* loaded from: classes4.dex */
public final class N0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f587a;
    public final /* synthetic */ C0547r1 b;

    public N0(C0547r1 c0547r1, Location location) {
        this.b = c0547r1;
        this.f587a = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0671w0 c0671w0 = this.b.f1059a;
        Location location = this.f587a;
        c0671w0.getClass();
        C0646v0.c().a(location);
    }
}
