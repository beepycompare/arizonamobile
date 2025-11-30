package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.k  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0359k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f964a;
    public final /* synthetic */ C0410m b;

    public RunnableC0359k(C0410m c0410m, Activity activity) {
        this.b = c0410m;
        this.f964a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f964a);
    }
}
