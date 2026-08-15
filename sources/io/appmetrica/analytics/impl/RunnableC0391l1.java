package io.appmetrica.analytics.impl;

import io.appmetrica.analytics.AnrListener;
/* renamed from: io.appmetrica.analytics.impl.l1  reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public final class RunnableC0391l1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnrListener f1075a;
    public final /* synthetic */ C0650v1 b;

    public RunnableC0391l1(C0650v1 c0650v1, AnrListener anrListener) {
        this.b = c0650v1;
        this.f1075a = anrListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0650v1.a(this.b).a(this.f1075a);
    }
}
