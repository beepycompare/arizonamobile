package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.j  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0344j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f908a;
    public final /* synthetic */ C0394l b;

    public RunnableC0344j(C0394l c0394l, Activity activity) {
        this.b = c0394l;
        this.f908a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f908a);
    }
}
