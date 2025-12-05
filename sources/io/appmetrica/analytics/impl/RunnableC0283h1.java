package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.h1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0283h1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f997a;
    public final /* synthetic */ C0610u1 b;

    public RunnableC0283h1(C0610u1 c0610u1, Activity activity) {
        this.b = c0610u1;
        this.f997a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0610u1 c0610u1 = this.b;
        Xk xk = c0610u1.h;
        Activity activity = this.f997a;
        Ja ja = c0610u1.d().f1058a;
        if (activity != null) {
            xk.f.a(activity);
        }
        if (xk.e.a(activity, EnumC0484p.RESUMED)) {
            ja.a(activity);
        }
    }
}
