package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.h1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0284h1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f914a;
    public final /* synthetic */ C0611u1 b;

    public RunnableC0284h1(C0611u1 c0611u1, Activity activity) {
        this.b = c0611u1;
        this.f914a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0611u1 c0611u1 = this.b;
        Xk xk = c0611u1.h;
        Activity activity = this.f914a;
        Ja ja = c0611u1.d().f975a;
        if (activity != null) {
            xk.f.a(activity);
        }
        if (xk.e.a(activity, EnumC0485p.RESUMED)) {
            ja.a(activity);
        }
    }
}
