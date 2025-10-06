package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.j  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0341j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f930a;
    public final /* synthetic */ C0393l b;

    public RunnableC0341j(C0393l c0393l, Activity activity) {
        this.b = c0393l;
        this.f930a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f930a);
    }
}
