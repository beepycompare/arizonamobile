package io.appmetrica.analytics.impl;

import android.app.Activity;
/* renamed from: io.appmetrica.analytics.impl.j  reason: case insensitive filesystem */
/* loaded from: classes4.dex */
public final class RunnableC0350j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f882a;
    public final /* synthetic */ C0400l b;

    public RunnableC0350j(C0400l c0400l, Activity activity) {
        this.b = c0400l;
        this.f882a = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a(this.f882a);
    }
}
