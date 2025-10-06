package io.appmetrica.analytics.impl;

import android.location.Location;
/* loaded from: classes4.dex */
public final class N0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f587a;
    public final /* synthetic */ C0548r1 b;

    public N0(C0548r1 c0548r1, Location location) {
        this.b = c0548r1;
        this.f587a = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0672w0 c0672w0 = this.b.f1059a;
        Location location = this.f587a;
        c0672w0.getClass();
        C0647v0.c().a(location);
    }
}
