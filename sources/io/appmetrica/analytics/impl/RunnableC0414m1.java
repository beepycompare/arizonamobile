package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.m1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0414m1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f1106a;
    public final /* synthetic */ C0588t1 b;

    public RunnableC0414m1(C0588t1 c0588t1, Activity activity) {
        this.b = c0588t1;
        this.f1106a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0588t1 c0588t1 = this.b;
        Wk wk = c0588t1.h;
        Activity activity = this.f1106a;
        Ia ia = c0588t1.d().f1062a;
        if (activity != null) {
            wk.f.a(activity);
        }
        if (wk.e.a(activity, EnumC0487p.PAUSED)) {
            ia.b(activity);
        }
    }
}
