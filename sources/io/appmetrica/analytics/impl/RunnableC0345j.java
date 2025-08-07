package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.j  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0345j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f907a;
    public final /* synthetic */ C0395l b;

    public RunnableC0345j(C0395l c0395l, Activity activity) {
        this.b = c0395l;
        this.f907a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f907a);
    }
}
