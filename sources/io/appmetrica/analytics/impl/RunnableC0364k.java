package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.k  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0364k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f1057a;
    public final /* synthetic */ C0416m b;

    public RunnableC0364k(C0416m c0416m, Activity activity) {
        this.b = c0416m;
        this.f1057a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f1057a);
    }
}
