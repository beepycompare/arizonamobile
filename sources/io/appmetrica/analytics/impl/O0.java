package io.appmetrica.analytics.impl;

import android.location.Location;
/* loaded from: classes5.dex */
public final class O0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Location f614a;
    public final /* synthetic */ C0561s1 b;

    public O0(C0561s1 c0561s1, Location location) {
        this.b = c0561s1;
        this.f614a = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0685x0 c0685x0 = this.b.f1103a;
        Location location = this.f614a;
        c0685x0.getClass();
        C0660w0.c().a(location);
    }
}
