package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.j  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0342j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f883a;
    public final /* synthetic */ C0392l b;

    public RunnableC0342j(C0392l c0392l, Activity activity) {
        this.b = c0392l;
        this.f883a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f883a);
    }
}
