package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.k  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0358k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f1047a;
    public final /* synthetic */ C0409m b;

    public RunnableC0358k(C0409m c0409m, Activity activity) {
        this.b = c0409m;
        this.f1047a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f1047a);
    }
}
