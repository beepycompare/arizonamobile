package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.k  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0363k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f1071a;
    public final /* synthetic */ C0413m b;

    public RunnableC0363k(C0413m c0413m, Activity activity) {
        this.b = c0413m;
        this.f1071a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f1071a);
    }
}
