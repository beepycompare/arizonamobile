package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.k  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0362k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f1060a;
    public final /* synthetic */ C0414m b;

    public RunnableC0362k(C0414m c0414m, Activity activity) {
        this.b = c0414m;
        this.f1060a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f1060a);
    }
}
